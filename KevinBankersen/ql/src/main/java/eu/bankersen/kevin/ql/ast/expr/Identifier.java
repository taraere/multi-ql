package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.var.Type;

public class Identifier extends Expr{


	private final String name;
	private Type type;

	public Identifier(String name) {
		this.name = name;
	}

	@Override
	public Object result(SymbolTabel table) {
		return table.getValue(name);
	}

	@Override
	public Boolean checkType(SymbolTabel table) {
		type = table.getValue(name).getType();
		return true;
	}

	@Override
	public Type getType() {
		return type;
	}
}