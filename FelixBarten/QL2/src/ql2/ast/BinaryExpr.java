package ql2.ast;

import ql2.BaseVisitor;

public class BinaryExpr extends Expr {
	
	Expr lefthand;
	Expr righthand;

	public BinaryExpr(Expr lhs, Expr rhs) {
		setLefthand(lhs);
		setRighthand(rhs);
	}
	
	public Expr getLefthand() {
		return lefthand;
	}

	public void setLefthand(Expr lefthand) {
		this.lefthand = lefthand;
	}

	public Expr getRighthand() {
		return righthand;
	}

	public void setRighthand(Expr righthand) {
		this.righthand = righthand;
	}

	@Override
	public <T> T accept(BaseVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
}
