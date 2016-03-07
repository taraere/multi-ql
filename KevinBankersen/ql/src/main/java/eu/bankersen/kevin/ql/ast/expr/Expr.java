package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.AcceptVisitor;
import eu.bankersen.kevin.ql.ast.BasicVisitor;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.ast.type.value.QLObject;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public abstract class Expr implements AcceptVisitor {
    
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

    public abstract Object evalExpr(SymbolTable symbolTable) throws EvaluateExeption;  
    
    @Override
    public <T> void accept(BasicVisitor v, T context) {
	v.visit(this);
    }

}