package eu.bankersen.kevin.ql.ast.var;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.SymbolTabel;

public class Variable  extends Expr{

	private final String name;
	private final Type type;
	private Expr value;

	public Variable(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public Variable(String name, Type type, Expr expr) {
		this.name = name;
		this.type = type;
		this.value = expr;
	}

	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public Boolean checkType(SymbolTabel table){
		if(value != null){
			return value.checkType(table) && value.getType() == type;
		}
		return true;
	}
	
	public void setValue(Expr value){
		this.value = value;
	}
	
	public Object getValue(SymbolTabel table){
		return value.result(table);
	}

	@Override
	public Object result(SymbolTabel expr) {
		return expr.getValue(name);
	}
}