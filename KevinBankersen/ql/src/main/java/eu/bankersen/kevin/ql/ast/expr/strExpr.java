package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.var.Type;

public abstract class strExpr extends Expr {

	protected Type type = Type.STRING;
	
	public abstract String result(SymbolTabel table);
	
	@Override
	public Type getType(){
		return type;
	}
}