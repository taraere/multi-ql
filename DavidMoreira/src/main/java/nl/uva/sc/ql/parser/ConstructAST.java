package nl.uva.sc.ql.parser;

import nl.uva.sc.ql.exceptions.ErrorHandling;
import nl.uva.sc.ql.parser.QLParser.Condition_blockContext;
import nl.uva.sc.ql.parser.QLParser.StatementContext;
import nl.uva.sc.ql.parser.ast.AssignVariableNode;
import nl.uva.sc.ql.parser.ast.BooleanNode;
import nl.uva.sc.ql.parser.ast.ConditionBlockNode;
import nl.uva.sc.ql.parser.ast.ExpressionNode;
import nl.uva.sc.ql.parser.ast.IfElseNode;
import nl.uva.sc.ql.parser.ast.IfNode;
import nl.uva.sc.ql.parser.ast.LogicNode;
import nl.uva.sc.ql.parser.ast.MathExpressionNode;
import nl.uva.sc.ql.parser.ast.MoneyNode;
import nl.uva.sc.ql.parser.ast.Node;
import nl.uva.sc.ql.parser.ast.RelationalExpressionNode;
import nl.uva.sc.ql.parser.ast.StatementNode;
import nl.uva.sc.ql.parser.ast.StringNode;
import nl.uva.sc.ql.parser.ast.SymbolTable;
import nl.uva.sc.ql.parser.ast.VariableNode;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.function.Function;

public class ConstructAST extends QLBaseVisitor<Node> {
 
    // store variables
	private SymbolTable<Node> symbolTable;
    
    public ConstructAST(SymbolTable<Node> symbolTable) {
    	this.symbolTable = symbolTable;
    }
    
    @Override
    public Node visitForm(@NotNull QLParser.FormContext context) {
    	Node node = this.visit(context.block());
    	// symbolTable.addId(context.IDENTIFIER().getText(), node);
    	
        node.setLine(context.stop.getLine());
    	return node;
    }
    
    // assignment/identifiers overrides
    @Override
    public Node visitDeclarationVariable(@NotNull QLParser.DeclarationVariableContext context) {
        String name = context.IDENTIFIER().getText();
        String type = context.type().getText();
        String question = context.String().getText();
        
        if (symbolTable.probe(name) != null) {
            ErrorHandling.getInstance().addError("Already defined variable: "+name+". Line "+context.IDENTIFIER().getSymbol().getLine());
        }
        if (symbolTable.probe(question) != null) {
            ErrorHandling.getInstance().addError("Already defined question: "+question+". Line "+context.String().getSymbol().getLine());
        }
        
        Function<String, VariableNode> chooseNode = s -> { 
        	switch(s) {
				case "String":
					return new StringNode();
				case "boolean":
					return new BooleanNode();
				case "money":
					return new MoneyNode();
				default:
					ErrorHandling.getInstance().addError(s+" cannot be solved to a type. Line "+context.type().getStart().getLine());
					return null;
			}};
        
		VariableNode node = chooseNode.apply(type); 
		node.setName(name);
        node.setQuestion(question);
        node.setLine(context.stop.getLine());
        
        symbolTable.add(name, node);
        symbolTable.add(question, node);
        return node;
    }
    
    @Override
    public Node visitDeclareAssignVariable(@NotNull QLParser.DeclareAssignVariableContext context) {        
    	VariableNode left = (VariableNode) this.visit(context.declaration());
        Node right = this.visit(context.expression());
        
        Node node = new AssignVariableNode();
        node.init(left, right);
        node.setLine(context.stop.getLine());;
        return node;
    }
    
    // unity overrides
    @Override
    public Node visitIdentifierUnity(@NotNull QLParser.IdentifierUnityContext context) {
        String identifier = context.getText();
        Node node = symbolTable.lookup(identifier);
        
        if (node == null) {
        	ErrorHandling.getInstance().addError("Assigning undefined variable "+identifier+". Line "+context.IDENTIFIER().getSymbol().getLine());
        }
        node.setLine(context.start.getLine());
        return node;
    }

    @Override
    public Node visitStringUnity(@NotNull QLParser.StringUnityContext context) {
    	Node node = new StringNode();
    	node.setValue(context.getText());
        node.setLine(context.start.getLine());
    	return node;
    }

    @Override
    public Node visitBooleanUnity(@NotNull QLParser.BooleanUnityContext context) {
    	Node node = new BooleanNode();
    	node.setValue(Boolean.parseBoolean(context.getText()));
        node.setLine(context.start.getLine());
    	return node;
    }
    
    @Override 
    public Node visitMoney(@NotNull QLParser.MoneyContext context) { 
    	Node node = new MoneyNode();
    	node.setValue(Double.parseDouble(context.getText()));
        node.setLine(context.start.getLine());
    	return node;
    }

    // expression overrides
    @Override
    public Node visitParentisisExpression(@NotNull QLParser.ParentisisExpressionContext context) {
        return this.visit(context.expression());
    }
    
    @Override
    public Node visitMinusExpression(@NotNull QLParser.MinusExpressionContext context) {
        Node node = this.visit(context.money());
        
        Double d = (Double) node.getValue();
        node.setValue(d*-1);
    	return node;
    }

    @Override
    public Node visitNotExpression(@NotNull QLParser.NotExpressionContext context) {
        Node expression = this.visit(context.expression());
        
        ExpressionNode node = new RelationalExpressionNode();
        node.init(expression, null, "!");
        node.setLine(context.start.getLine());
        return node;
    }
    
    @Override
    public Node visitMultDivModExpression(@NotNull QLParser.MultDivModExpressionContext context) {
    	Node left = this.visit(context.expression(0));
        Node right = this.visit(context.expression(1));
        
        ExpressionNode node = new MathExpressionNode();
        node.init(left, right, context.op.getText());
        node.setLine(context.start.getLine());
    	return node;
    }

    @Override
    public Node visitAdditiveExpression(@NotNull QLParser.AdditiveExpressionContext context) {
        Node left = this.visit(context.expression(0));
        Node right = this.visit(context.expression(1));
        
        ExpressionNode node = new MathExpressionNode();
        node.init(left, right, context.op.getText());
        node.setLine(context.start.getLine());
    	return node;
    }

    @Override
    public Node visitRelationalExpression(@NotNull QLParser.RelationalExpressionContext context) {
        Node left = this.visit(context.expression(0));
        Node right = this.visit(context.expression(1));

        ExpressionNode node = new RelationalExpressionNode();
        node.init(left, right, context.op.getText());
        node.setLine(context.start.getLine());
        return node;
    }

    @Override
    public Node visitEqualityExpression(@NotNull QLParser.EqualityExpressionContext context) {
        Node left = this.visit(context.expression(0));
        Node right = this.visit(context.expression(1));
        
        ExpressionNode node = new RelationalExpressionNode();
        node.init(left, right, context.op.getText());
        node.setLine(context.start.getLine());
        return node;
    }

    @Override
    public Node visitAndExpression(@NotNull QLParser.AndExpressionContext context) {
        Node left = this.visit(context.expression(0));
        Node right = this.visit(context.expression(1));
        
        ExpressionNode node = new LogicNode();
        node.init(left, right, "&&");
        node.setLine(context.start.getLine());
        return node;  
    }

    @Override
    public Node visitOrExpression(@NotNull QLParser.OrExpressionContext context) {
        Node left = this.visit(context.expression(0));
        Node right = this.visit(context.expression(1));
        
        ExpressionNode node = new LogicNode();
        node.init(left, right, "||");
        node.setLine(context.start.getLine());
        return node;  
    }

    // if override
    @Override
    public Node visitIf_stat(@NotNull QLParser.If_statContext context) {
    	Node left = auxVisitListIfStatements(context.condition_block());
    	Node right = context.stat_block() != null ? this.visit(context.stat_block()) : null;
    	
    	Node node = new IfElseNode();
    	node.init(left, right);

        return node;
    }
    
    private Node auxVisitListIfStatements(List<Condition_blockContext> list){
    	Node node, left = null, right = null;
    	
    	if (list.size() == 1){
    		return this.visit(list.get(0));
    	}
    	
    	Condition_blockContext leftContext = list.get(0);
    	left = this.visit(leftContext);
		if (list.size() > 1) {
			list.remove(0);
			right = auxVisitListIfStatements(list);
		}
		
    	node = new IfNode();
    	node.init(left, right);
        node.setLine(leftContext.start.getLine());
    	return node;
    }
    
    //scope
    @Override
    public Node visitBlock(@NotNull QLParser.BlockContext context) {
    	symbolTable.enterScope();
    	Node value = this.visit(context.list_statements()); 
    	symbolTable.exitScope();
        
        return value;
    }
    
    //rest of the overrides
    @Override 
    public Node visitList_statements(@NotNull QLParser.List_statementsContext context) {     	
    	Node aux = auxVisitListStatements(context.statement());
    	return aux;
    }
    
    private Node auxVisitListStatements(List<StatementContext> list){
    	Node node, left = null, right = null;
    	
		if (!list.isEmpty()){
			left = this.visit(list.get(0));
		
			if (list.size() > 1) {
				list.remove(0);
				right = auxVisitListStatements(list);
			}
		}
		
    	node = new StatementNode();
    	node.init(left, right);
    	return node;
    }

    @Override 
    public Node visitCondition_block(@NotNull QLParser.Condition_blockContext context) { 
    	Node left = this.visit(context.expression());
    	Node right = this.visit(context.stat_block());
    	
    	Node node = new ConditionBlockNode();
    	node.init(left, right);
    	node.setLine(context.start.getLine());
    	return node;
    }
}