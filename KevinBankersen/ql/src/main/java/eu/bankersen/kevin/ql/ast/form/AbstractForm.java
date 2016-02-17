package eu.bankersen.kevin.ql.ast.form;

import eu.bankersen.kevin.ql.symboltable.Context;

public abstract class AbstractForm {
    
    protected Context context = Context.getInstance();
    
    public abstract void checkType();
    public abstract void eval();

}
