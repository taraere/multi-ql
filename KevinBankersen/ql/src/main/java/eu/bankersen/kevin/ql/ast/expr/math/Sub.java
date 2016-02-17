package eu.bankersen.kevin.ql.ast.expr.math;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.IntegerExpr;

public class Sub extends IntegerExpr {

    public Sub(final Expr lhs, final Expr rhs) {
	super.lhs = lhs;
	super.rhs = rhs;
    }

    @Override
    public final Integer eval() {
	Log.debug(rhs.eval().toString());
	Log.debug(lhs.eval().toString());
	return (Integer) lhs.eval() - (Integer) rhs.eval();
    }

}