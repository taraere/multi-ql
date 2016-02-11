package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.var.Type;

public abstract class intExpr extends Expr { 
	
	private final Type type = Type.INTEGER;
	
	public abstract Integer result(SymbolTabel table);
	
	@Override
	public Boolean checkType(SymbolTabel table) {
		return lhs.checkType(table) && lhs.getType().equals(type) && rhs.checkType(table) && rhs.getType().equals(type);
	}
	
	@Override
	public Type getType(){
		return type;
	}
	
}