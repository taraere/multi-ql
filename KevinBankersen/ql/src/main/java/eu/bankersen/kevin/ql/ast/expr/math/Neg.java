package eu.bankersen.kevin.ql.ast.expr.math;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.IntegerExpr;

public class Neg extends IntegerExpr {

    public Neg(final Expr expr, final int line) {
	super.rhs =  expr;
	super.line = line;
    }

    @Override
    public final Integer eval() {
	return -(Integer) rhs.eval();
    }

}
