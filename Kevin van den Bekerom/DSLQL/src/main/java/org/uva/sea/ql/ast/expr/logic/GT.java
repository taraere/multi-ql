package org.uva.sea.ql.ast.expr.logic;

import org.uva.sea.ql.ast.expr.BinaryExpr;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.form.Context;
import org.uva.sea.ql.ast.form.ValueMap;
import org.uva.sea.ql.ast.visit.Visitor;
import org.uva.sea.ql.type.NumericalType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;

public class GT extends BinaryExpr {
	
	public GT(Expr lhs, Expr rhs, int startLine) {
		super(lhs, rhs, startLine);
	}
	
	@Override
	public Value eval(ValueMap valueMap) {
		return  rhs.eval(valueMap).gt(lhs.eval(valueMap), false);
	}
	
	public void accept(Visitor visitor, Object context) {
		visitor.visit(this, context);
	}

	@Override
	public String toString() {
		return super.toString() + " (>)";
	}
	
	@Override
	public Type getType(Context context) {
		return new NumericalType();
	}
}
