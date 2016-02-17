package eu.bankersen.kevin.ql.ast;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.form.AbstractForm;

public class Variable extends AbstractForm {

    private final String name;
    private final Type type;
    private Expr expr;

    public Variable(final String name, final Type type, final Expr expr) {
	this.name = name;
	this.type = type;
	this.expr = expr;
    }

    public final String getName() {
	return name;
    }

    public final Type getType() {
	return type;
    }

    public final void checkType() {
	super.context.addSymbol(name, type);

	expr.checkType();
	if (!expr.getType().equals(type)) {
	    super.context.addError("Type missmatch, expected " + type + "got" + expr.getType());
	}
    }

    public final Object getValue() {
	return super.context.getSymbol(name).getValue();
    }

    public final void eval() {

	try {
	    Object value = expr.eval();
	    super.context.updateSymbol(name, value);
	    Log.debug(name + ", new value=" + value);
	} catch (NullPointerException e) {
	    Log.debug(name + " cannot be evaluated yet");
	}
    }
}
