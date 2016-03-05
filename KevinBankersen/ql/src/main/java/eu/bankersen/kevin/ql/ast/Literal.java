package eu.bankersen.kevin.ql.ast;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.SymbolTableBuilder;
import eu.bankersen.kevin.ql.oldcode.QLVisitor;

public class Literal extends Expr {

    private final Object value;
    
    public Literal(Object value, Type type, int line) {
	super(type, null, null, line);
	this.value = value;
    }
    
    @Override
    public Object eval(SymbolTable symbolTable) {
	return value; 
    }

    @Override
    public Context checkType(Context context) {
	return context;
    }
    
    @Override
    public String toString() {
	return value.toString();
    }
    
//    @Override
//    public SymbolTableBuilder buildSymbolTable(SymbolTableBuilder builder) {
//	System.out.println("returning literal");
//	return builder;
//    }
}
