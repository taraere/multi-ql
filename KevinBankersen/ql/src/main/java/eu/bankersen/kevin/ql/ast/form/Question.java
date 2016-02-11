package eu.bankersen.kevin.ql.ast.form;

import eu.bankersen.kevin.ql.ast.var.Type;
import eu.bankersen.kevin.ql.ast.var.Variable;

public class Question {

	private final Variable variable;
	private final String text;

	public Question(Variable variable, String text) {
		this.variable = variable;
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
	public Boolean checkType(){
		return variable.checkType();
	}
	
	public Type getType(){
		return variable.getType();
	}
	
	@Override
	public String toString(){
		return text + ";" + variable.toString();
	}
}
