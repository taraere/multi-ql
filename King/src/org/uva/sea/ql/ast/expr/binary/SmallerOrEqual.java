package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.ast.visitors.QLNodeVisitor;

public class SmallerOrEqual extends BinaryExpression {

	public SmallerOrEqual(Expr e1, Expr e2) {
		super(e1, e2);
	}
	
	@Override
	public <T> T accept(QLNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
