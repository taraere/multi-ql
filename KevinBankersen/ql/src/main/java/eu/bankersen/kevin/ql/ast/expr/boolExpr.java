package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.var.Type;

public abstract class boolExpr extends Expr {

	protected boolExpr lhs;
	protected boolExpr rhs;
	private final Type type = Type.BOOLEAN;
		
	public abstract Boolean result(SymbolTabel table);
	
	@Override
	public Boolean checkType() {
		return lhs.getType() == type && rhs.getType() == type;
	}
	
	@Override
	public Type getType(){
		return type;
	}
}
