package eu.bankersen.kevin.ql.ast;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.form.AbstractForm;

public class Variable extends AbstractForm {

    private final String name;
    private final Type type;
    private final int line;
    private Expr expr;

    public Variable(final String name, final Type type, final Expr expr, final int line) {
	this.name = name;
	this.type = type;
	this.expr = expr;
	this.line = line;
    }

    public final String getName() {
	return name;
    }

    public final Type getType() {
	return type;
    }

    public final void checkType() {

	if (super.context.checkID(name)) {
	    super.context.addError("TYPE_ERROR @Line " + line 
		    			+ " question " + name + " already defined!");
	} else {
	    super.context.addSymbol(name, type);
	}

	expr.checkType();
	
	if (!expr.getType().equals(type)) {
	    super.context.addError("TYPE_ERROR @Line " + line 
		    			+ ": expected " + type 
		    			+ " got " + expr.getType() + "!");
	}
    }

    public final Object getValue() {
	return super.context.getSymbol(name).getValue();
    }

    public final String toString() {
	return this.getName() + ": " + this.getType() + "=" + this.getValue();
    }

    public final void eval() {

	try {
	    Object value = expr.eval();
	    super.context.updateSymbol(name, value);
	} catch (NullPointerException e) {
	    super.context.updateSymbol(name, null);
	}
    }
}
