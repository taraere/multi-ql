package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.boolExpr;
import eu.bankersen.kevin.ql.ast.expr.SymbolTabel;
import eu.bankersen.kevin.ql.ast.var.Type;

public class Eq extends boolExpr {

	public Eq(Expr lhs, Expr rhs) {
		super.lhs = lhs;
		super.rhs = rhs;
	}

	@Override
	public Boolean result(SymbolTabel table) {
		return lhs.result(table).equals(rhs.result(table));
	}

}