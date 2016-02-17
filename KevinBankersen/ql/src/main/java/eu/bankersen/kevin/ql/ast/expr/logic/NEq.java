package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;

public class NEq extends BooleanExpr {

    public NEq(final Expr lhs, final Expr rhs) {
	super.lhs = lhs;
	super.rhs = rhs;
    }

    @Override
    public final Boolean eval() {
	return !lhs.eval().equals(rhs.eval());
    }

}