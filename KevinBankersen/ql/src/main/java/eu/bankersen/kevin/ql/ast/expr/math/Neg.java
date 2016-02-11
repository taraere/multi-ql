package eu.bankersen.kevin.ql.ast.expr.math;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.intExpr;
import eu.bankersen.kevin.ql.ast.expr.SymbolTabel;

public class Neg extends intExpr {

	private final intExpr value;

	public Neg(Expr expr) {
		this.value = (intExpr) expr;
	}

	@Override
	public Integer result(SymbolTabel table) {
		return value.result(table) * -1;
	}

}
