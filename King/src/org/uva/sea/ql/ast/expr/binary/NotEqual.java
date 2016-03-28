package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.visitors.QLNodeVisitor;

public class NotEqual extends BinaryExpression {

	public NotEqual(Expr e1, Expr e2) {
		super(e1, e2);
	}

	@Override
	public <T> T accept(QLNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}