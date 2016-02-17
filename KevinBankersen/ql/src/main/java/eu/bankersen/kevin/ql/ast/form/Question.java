package eu.bankersen.kevin.ql.ast.form;

import eu.bankersen.kevin.ql.ast.Type;
import eu.bankersen.kevin.ql.ast.Variable;
import eu.bankersen.kevin.ql.symboltable.SymbolTabel;

public class Question {

    private final Variable variable;
    private final String text;

    public Question(final Variable variable, final String text) {
	this.variable = variable;
	this.text = text;
    }

    public final String getText() {
	return text;
    }
    
    public final void result(){
	variable.result();
    }

    public final void checkType() {
	variable.checkType();
    }

    public final Type getType() {
	return variable.getType();
    }
    
    public final String getName() {
	return variable.getName();
    }
    
    public final Object getValue() {
	return SymbolTabel.getValue(variable.getName());
    }
}
