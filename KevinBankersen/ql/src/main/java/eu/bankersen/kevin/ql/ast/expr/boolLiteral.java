package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.var.Type;

public class boolLiteral extends boolExpr {

	private final Boolean value;
	
	public boolLiteral(Boolean value) {
		this.value = value;
	}
	
	public Type getType(){
		return Type.BOOLEAN;
	}

	@Override
	public Boolean result(SymbolTabel table) {
		return value;
	}
	
	public Boolean result() {
		return value;
	}

	@Override
	public Boolean checkType() {
		return true;
	}
}
