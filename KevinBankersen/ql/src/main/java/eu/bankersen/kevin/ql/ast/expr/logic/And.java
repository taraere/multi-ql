package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;

public class And extends BooleanExpr {

    public And(final Expr lhs, final Expr rhs) {
	super.lhs = lhs;
	super.rhs = rhs;
    }

    @Override
    public final Boolean result() {
	return (Boolean) lhs.result() && (Boolean) rhs.result();
    }

}