package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.BasicVisitor;
import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.form.Body;
import eu.bankersen.kevin.ql.ast.type.BooleanType;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public class ElseStatement extends AbstractStatement  {

    private final Body body;
    private final Body elseBody;

    public ElseStatement(Expr expr, Body body, Body elseBody, int line) {
	super(new BooleanType(), expr, line);
	this.body = body;
	this.elseBody = elseBody;
    }

    public Body body() {
	return body;
    }

    public Body elseBody() {
	return elseBody;
    }
    
    private boolean evalIFexpr(SymbolTable symbolTable) {
	boolean exprValue;
	
	try {
	    exprValue = (Boolean) expr().evalExpr(symbolTable);
	} catch (EvaluateExeption e) {
	    exprValue = false;
	}
	
	return exprValue;
    }

    private SymbolTable evaluateBodies(SymbolTable symbolTable) {
	symbolTable = body.evalBody(symbolTable);
	return elseBody.evalBody(symbolTable);
    }

    @Override
    public SymbolTable evalStatement(SymbolTable symbolTable) {	
	
	return visible(evaluateBodies(symbolTable), true);
    }

    @Override
    public SymbolTable visible(SymbolTable symbolTable, Boolean visible) {
	symbolTable = body.visible(symbolTable, evalIFexpr(symbolTable));
	return elseBody.visible(symbolTable, !evalIFexpr(symbolTable));
    }
    
    @Override
    public <T> void accept(BasicVisitor v, T context) {
	v.visit(this);
    }
}
