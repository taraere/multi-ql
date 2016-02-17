package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.Expr;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;

public class GT extends BooleanExpr {

    public GT(final Expr lhs, final Expr rhs) {
	super.lhs = lhs;
	super.rhs = rhs;
    }

    @Override
    public final Boolean result() {
	Log.error("Made it here");
	
	return (Integer) lhs.result() > (Integer) rhs.result();
    }
}