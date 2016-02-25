package nl.nicasso.ql;

import java.awt.GridLayout;

import javax.swing.JFrame;

import nl.nicasso.ql.ast.ASTNode;
import nl.nicasso.ql.ast.Visitor;
import nl.nicasso.ql.ast.expression.Expression;
import nl.nicasso.ql.ast.expression.Identifier;
import nl.nicasso.ql.ast.expression.Parenthesis;
import nl.nicasso.ql.ast.expression.additive.Addition;
import nl.nicasso.ql.ast.expression.additive.Subtraction;
import nl.nicasso.ql.ast.expression.conditional.And;
import nl.nicasso.ql.ast.expression.conditional.Not;
import nl.nicasso.ql.ast.expression.conditional.Or;
import nl.nicasso.ql.ast.expression.equality.Equal;
import nl.nicasso.ql.ast.expression.equality.NotEqual;
import nl.nicasso.ql.ast.expression.multiplicative.Division;
import nl.nicasso.ql.ast.expression.multiplicative.Multiplication;
import nl.nicasso.ql.ast.expression.relational.Greater;
import nl.nicasso.ql.ast.expression.relational.GreaterEqual;
import nl.nicasso.ql.ast.expression.relational.Less;
import nl.nicasso.ql.ast.expression.relational.LessEqual;
import nl.nicasso.ql.ast.literal.BooleanLit;
import nl.nicasso.ql.ast.literal.IntegerLit;
import nl.nicasso.ql.ast.literal.Literal;
import nl.nicasso.ql.ast.literal.StringLit;
import nl.nicasso.ql.ast.statement.ComputedQuestion;
import nl.nicasso.ql.ast.statement.IfElseStatement;
import nl.nicasso.ql.ast.statement.IfStatement;
import nl.nicasso.ql.ast.statement.Question;
import nl.nicasso.ql.ast.statement.Statement;
import nl.nicasso.ql.ast.structure.Block;
import nl.nicasso.ql.ast.structure.Form;
import nl.nicasso.ql.ast.type.BooleanType;
import nl.nicasso.ql.ast.type.IntegerType;
import nl.nicasso.ql.ast.type.MoneyType;
import nl.nicasso.ql.ast.type.StringType;

public class Gui implements Visitor<Void> {
	
	private boolean debug = false;
	
	private JFrame frame;

	public Gui() {
		initGui();
	}
	
	private void initGui() {
		frame = new JFrame("Questionnaire");
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(0, 1));
        //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.setVisible(true);
	}

	@Override
	public Void visit(Form value) {
		if (debug) {
			System.out.println("Form");
		}

		value.getBlock().accept(this);
		
		return null;
	}

	@Override
	public Void visit(Block value) {
		if (debug) {
			System.out.println("Block");
		}

		for (Statement cur : value.getStatements()) {
			cur.accept(this);
		}

		return null;
	}

	@Override
	public Void visit(Question value) {
		if (debug) {
			System.out.println("Question");
		}
						
		return null;
	}

	@Override
	public Void visit(ComputedQuestion value) {
		if (debug) {
			System.out.println("ComputedQuestion");
		}
						
		value.getExpr().accept(this);
				
		return null;
	}

	@Override
	public Void visit(Identifier value) {
		if (debug) {
			System.out.println("Void: " + value.getValue());
		}
		
		return null;
	}

	@Override
	public Void visit(IfStatement value) {
		return null;
	}

	@Override
	public Void visit(IfElseStatement value) {
		return null;
	}

	@Override
	public Void visit(Addition value) {
		return null;
	}

	@Override
	public Void visit(Subtraction value) {
		return null;
	}

	@Override
	public Void visit(And value) {
		return null;
	}

	@Override
	public Void visit(Or value) {
		return null;
	}

	@Override
	public Void visit(Not value) {
		return null;
	}

	@Override
	public Void visit(Parenthesis value) {
		return null;
	}

	@Override
	public Void visit(Equal value) {
		return null;
	}

	@Override
	public Void visit(NotEqual value) {
		return null;
	}

	@Override
	public Void visit(Division value) {
		return null;
	}

	@Override
	public Void visit(Multiplication value) {
		return null;
	}

	@Override
	public Void visit(Greater value) {
		return null;
	}

	@Override
	public Void visit(GreaterEqual value) {
		return null;
	}

	@Override
	public Void visit(Less value) {
		return null;
	}

	@Override
	public Void visit(LessEqual value) {
		return null;
	}

	@Override
	public Void visit(BooleanLit value) {
		return null;
	}

	@Override
	public Void visit(IntegerLit value) {
		return null;
	}

	@Override
	public Void visit(StringLit value) {
		return null;
	}
	
	private void addQuestionToGui(Question question){
		Identifier id = question.getId();
		
		
	}

}
