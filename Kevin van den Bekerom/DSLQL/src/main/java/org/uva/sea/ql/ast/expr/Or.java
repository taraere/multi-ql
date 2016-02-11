package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Visitable;
import org.uva.sea.ql.ast.Visitor;

public class Or extends BinaryExpr implements Visitable {
	
	public Or(Expr lhs, Expr rhs) {
		super.lhs = lhs;
		super.rhs = rhs;
	}
	
	@Override
	public Boolean eval() {
		return (Boolean) lhs.eval() || (Boolean) rhs.eval();
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}