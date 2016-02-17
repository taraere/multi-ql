package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;

public class Not extends BooleanExpr {

    private final Expr expr;

    public Not(final Expr expr) {
	this.expr = expr;
    }
    
    @Override
    public final void checkType() {
	expr.checkType();
	expr.getType().equals(this.getType());
    }

    @Override
    public final Boolean eval() {
	return !(Boolean) expr.eval();
    }

}