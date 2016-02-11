package eu.bankersen.kevin.ql.ast.form;

import eu.bankersen.kevin.ql.ast.expr.SymbolTabel;
import eu.bankersen.kevin.ql.ast.var.Type;

public class Form{

	private String name;
	public Block body;
	protected SymbolTabel table;

	public Form(String name, Block body) {
		this.name = name;
		this.body = body;
	}
	
	public void setSymbolTable(SymbolTabel table){
		this.table = table;
	}
	
	
	public Boolean checkType(){
		return body.checkType(table);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb;

		sb = new StringBuilder();
		sb.append("Form: " + name + "\n");
		sb.append(body);
		sb.append("\n");

		return sb.toString();
	}
}
