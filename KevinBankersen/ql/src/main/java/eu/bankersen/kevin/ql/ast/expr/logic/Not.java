package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.boolExpr;
import eu.bankersen.kevin.ql.ast.expr.SymbolTabel;
import eu.bankersen.kevin.ql.ast.var.Type;

public class Not extends boolExpr {

	private final boolExpr expr;

	public Not(Expr expr) {
		this.expr = (boolExpr) expr;
	}

	@Override
	public Boolean result(SymbolTabel table) {
		return !expr.result(table);
	}

}
