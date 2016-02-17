package eu.bankersen.kevin.ql.ast;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.symboltable.SymbolTabel;

public class Variable {

    private final String name;
    private final Type type;
    private Expr expr;

    public Variable(final String name, final Type type) {
	this.name = name;
	this.type = type;
    }

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

	SymbolTabel.addVariable(name, type);

	if (expr != null) {
	    expr.checkType();
	    if (!expr.getType().equals(type)) {
		SymbolTabel.addError("Type missmatch, expected " + type + "got" + expr.getType());
	    }
	}
    }

    public final Object getValue() {
	return SymbolTabel.getValue(name);
    }

    public final void result() {

	if (expr != null) {
	    try {
		Object value = expr.result();
		SymbolTabel.updateValue(name, value);
		Log.debug(name + ", new value=" + value);
	    } catch (NullPointerException e) {
		Log.debug(name + "requires more data");
	    }
	}

    }
}
