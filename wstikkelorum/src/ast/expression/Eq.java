package ast.expression;

import ast.Visitor;

public class Eq extends Expression {
	private Expression lhs;
	private Expression rhs;
	
	public Eq(Expression result, Expression result2) {
		this.lhs = result;
		this.rhs = result2;
	}
	
	public Expression getLhs() {
		return lhs;
	}

	public Expression getRhs() {
		return rhs;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
