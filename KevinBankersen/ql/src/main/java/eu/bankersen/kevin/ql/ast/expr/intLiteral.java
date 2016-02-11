package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.var.Type;

public class intLiteral extends intExpr {

	private final Integer value;
	
	public intLiteral(Integer value) {
		this.value = value;
	}

	@Override
	public String toString(){
		return value.toString();
	}

	@Override
	public Integer result(SymbolTabel table) {
		return value;
	}

	@Override
	public Boolean checkType() {
		return true;
	}
	
}
