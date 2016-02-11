package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Visitable;
import org.uva.sea.ql.ast.Visitor;

public class NEq extends BinaryExpr implements Visitable {
	
	public NEq(Expr lhs, Expr rhs) {
		super.lhs = lhs;
		super.rhs = rhs;
	}
	
	@Override
	public Boolean eval() {
		return lhs.eval() != rhs.eval();
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}