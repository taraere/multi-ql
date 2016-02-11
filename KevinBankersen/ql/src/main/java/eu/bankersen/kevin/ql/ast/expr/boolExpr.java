package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.var.Type;

public abstract class boolExpr extends Expr {

	private final Type type = Type.BOOLEAN;
		
	public abstract Boolean result(SymbolTabel table);
	
	@Override
	public Boolean checkType(SymbolTabel table) {
		return lhs.getType().equals(rhs.getType());
	}
	
	@Override
	public Type getType(){
		return type;
	}
}