package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.var.Type;

public abstract class Expr {
	
	public abstract Object result(SymbolTabel table);
	
	public abstract Boolean checkType();
	
	public abstract Type getType();
	
}