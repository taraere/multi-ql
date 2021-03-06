package ql;

import ql.ast.Block;
import ql.ast.ComputedQuestion;
import ql.ast.Form;
import ql.ast.InputQuestion;
import ql.ast.Question;
import ql.ast.QuestionType;
import ql.ast.Questionnaire;
import ql.ast.expression.Add;
import ql.ast.expression.And;
import ql.ast.expression.BinaryExpr;
import ql.ast.expression.Div;
import ql.ast.expression.Eq;
import ql.ast.expression.GEq;
import ql.ast.expression.GT;
import ql.ast.expression.Ge;
import ql.ast.expression.IdentityExpr;
import ql.ast.expression.LEq;
import ql.ast.expression.LT;
import ql.ast.expression.Le;
import ql.ast.expression.LiteralExpr;
import ql.ast.expression.Mul;
import ql.ast.expression.NEq;
import ql.ast.expression.Neg;
import ql.ast.expression.Not;
import ql.ast.expression.Or;
import ql.ast.expression.Pos;
import ql.ast.expression.Sub;
import ql.ast.expression.UnaryExpr;
import ql.ast.literal.BooleanLiteral;
import ql.ast.literal.IntegerLiteral;
import ql.ast.literal.Literal;
import ql.ast.literal.MoneyLiteral;
import ql.ast.literal.StringLiteral;
import ql.ast.statement.IfElseStatement;
import ql.ast.statement.IfStatement;
import ql.ast.type.BooleanType;
import ql.ast.type.IntegerType;
import ql.ast.type.MoneyType;
import ql.ast.type.StringType;
import ql.parser.QLBaseVisitor;

public class QLSemanticVisitor<T> extends BaseVisitor<T>{

	@Override
	public T visit(ASTNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Block node) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Form node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Question node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(InputQuestion node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(ComputedQuestion node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Questionnaire node) {
		// TODO Auto-generated method stub
		
		// visit questions; 
		return null;
	}

	@Override
	public T visit(Add node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(And node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(BinaryExpr node) {

		return null;
	}

	@Override
	public T visit(Div node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(Eq node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(Ge node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(GEq node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(GT node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(Le node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(LEq node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(LT node) {
		return visit((BinaryExpr) node);
	}

	@Override
	public T visit(Mul node) {
		return visit((BinaryExpr) node);

	}

	@Override
	public T visit(Neg node) {
		return visit((UnaryExpr) node);

	}

	@Override
	public T visit(NEq node) {
		return visit((BinaryExpr) node);
	}

	@Override
	public T visit(Not node) {
		return visit((UnaryExpr) node);
	}

	@Override
	public T visit(Or node) {
		return visit((BinaryExpr) node);
	}

	@Override
	public T visit(Pos node) {
		return visit((UnaryExpr) node);
	}

	@Override
	public T visit(Sub node) {
		return visit((BinaryExpr) node);
	}

	@Override
	public T visit(UnaryExpr node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(IdentityExpr node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(LiteralExpr node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(IfStatement node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(IfElseStatement node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Literal node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(BooleanLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(MoneyLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(IntegerLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(StringLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(QuestionType node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(BooleanType node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(MoneyType node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(IntegerType node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(StringType node) {
		// TODO Auto-generated method stub
		return null;
	}
	
}