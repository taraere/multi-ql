package eu.bankersen.kevin.ql.ast;

import eu.bankersen.kevin.ql.ast.expr.Expr;

public class Identifier extends Expr {

    private final String name;

    public Identifier(final String name) {
	this.name = name;
    }

    @Override
    public final Object eval() {
	return super.context.getSymbol(name).getValue();
    }

    @Override
    public final void checkType() {
	if (!super.context.checkID(name)) {
	    super.context.addError("SYMANTIC_ERROR " + name + " does not exist!");
	}
    }

    @Override
    public final Type getType() {
	return super.context.getSymbol(name).getType();
    }
}