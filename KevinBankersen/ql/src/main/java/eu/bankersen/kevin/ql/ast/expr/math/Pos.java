package eu.bankersen.kevin.ql.ast.expr.math;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.intExpr;
import eu.bankersen.kevin.ql.ast.expr.SymbolTabel;

public class Pos extends intExpr {

	private final Expr expr;

	public Pos(Expr expr) {
		this.expr = expr;
	}

	@Override
	public Integer result(SymbolTabel table) {
		return ( (Integer) expr.result(table) < 0) ? -1 * (Integer) expr.result(table) : (Integer) expr.result(table);
	}

}