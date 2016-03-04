package eu.bankersen.kevin.ql.ast;

import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.ast.type.UndifinedType;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.SymbolTableBuilder;
import eu.bankersen.kevin.ql.oldcode.QLVisitor;


public class Identifier extends Expr {

    private final String name;

    public Identifier(String name, int line) {
	super(new UndifinedType(), null, null, line);
	this.name = name;
    }
    
    public String name() {
	return name;
    }

    @Override
    public Object eval(SymbolTable symbolTable) throws EvaluateExeption {

	Object value = symbolTable.getSymbol(name).getValue();

	if (value != null) {
	    return value;   
	} else {
	    throw new EvaluateExeption();
	} 
    }

    @Override
    public Context checkType(Context context) {
	return context.evaluate(this);
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
	return symbolTable.getSymbol(name).getType();
    }

}
