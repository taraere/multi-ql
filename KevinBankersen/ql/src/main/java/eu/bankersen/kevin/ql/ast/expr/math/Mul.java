package eu.bankersen.kevin.ql.ast.expr.math;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.IntegerExpr;

public class Mul extends IntegerExpr {

    public Mul(final Expr lhs, final Expr rhs) {
	super.lhs =  lhs;
	super.rhs =  rhs;
    }

    @Override
    public final Integer eval() {
	return (Integer) lhs.eval() * (Integer) rhs.eval();
    }


}
