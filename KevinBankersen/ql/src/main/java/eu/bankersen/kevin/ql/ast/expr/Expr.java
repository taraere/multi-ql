package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.AcceptMethods;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.SymbolTableBuilder;

public abstract class Expr implements AcceptMethods {
    
    private final Type type;
    private final Expr lhs;
    private final Expr rhs;
    private final int line;
    
    public Expr(Type type, Expr lhs, Expr rhs, int line) {
	this.type = type;
	this.lhs = lhs;
	this.rhs = rhs;
	this.line = line;
    }
    
    public Expr lhs() {
	return lhs;
    }

    public Expr rhs() {
	return rhs;
    }
    
    public int line() {
	return line;
    }
    
    public Type getType(SymbolTable symbolTable) {
	return type;
    }

    public abstract Object eval(SymbolTable symbolTable) throws EvaluateExeption;    

}