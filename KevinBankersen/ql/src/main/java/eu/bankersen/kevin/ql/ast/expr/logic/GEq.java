package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;

public class GEq extends BooleanExpr {

    public GEq(final Expr lhs, final Expr rhs) {
	super.lhs = lhs;
	super.rhs = rhs;
    }

    @Override
    public final Boolean result() {
	return (Integer) lhs.result() >= (Integer) rhs.result();
    }

}
