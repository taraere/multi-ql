package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.Type;
import eu.bankersen.kevin.ql.ast.Variable;

public class Question extends AbstractStatement  {

    private final Variable variable;
    private final String text;

    public Question(final Variable variable, final String text) {
	this.variable = variable;
	this.text = text;
    }

    public final String getText() {
	return text;
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
	return super.context.getSymbol(variable.getName()).getValue();
    }
    
    public final void visible(final Boolean visible) {
	super.context.setVisibility(this.getName(), visible);
    }

    @Override
    public final void eval() {
	variable.eval();
    }
}