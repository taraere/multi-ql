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
    public final Integer result() {
	Log.debug(rhs.result().toString());
	Log.debug(lhs.result().toString());
	return (Integer) lhs.result() - (Integer) rhs.result();
    }

}