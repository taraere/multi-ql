package nl.nicasso.ql.ast.nodes.expressions.equality;

import nl.nicasso.ql.ast.nodes.CodeLocation;
import nl.nicasso.ql.ast.nodes.expressions.Expression;
import nl.nicasso.ql.visitors.ExpressionVisitor;

public class NotEqual extends Equality {

	private final Expression left;
	private final Expression right;

	public NotEqual(Expression left, Expression right, CodeLocation location) {
		super(location);
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	@Override
	public <T, U> T accept(ExpressionVisitor<T, U> visitor, U context) {
		return visitor.visit(this, context);
	}

	@Override
	public String toString() {
		return left + "!=" + right;
	}

}
