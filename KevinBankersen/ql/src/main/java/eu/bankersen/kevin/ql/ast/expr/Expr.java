package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.Type;
import eu.bankersen.kevin.ql.symboltable.Context;

public abstract class Expr {
    
    protected Context context = Context.getInstance();

    public abstract Object eval();

    public abstract void checkType();

    public abstract Type getType();

}