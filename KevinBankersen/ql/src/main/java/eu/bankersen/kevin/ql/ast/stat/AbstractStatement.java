package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.BasicVisitor;
import eu.bankersen.kevin.ql.ast.AcceptVisitor;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public abstract class AbstractStatement implements AcceptVisitor {

    private final Type type;
    private final Expr expr;
    private final int line;

    public AbstractStatement(Type type, Expr expr, int line) {
	this.type = type;
	this.expr = expr;
	this.line = line;
    }

    public Expr expr() {
	return expr;
    }

    public int line() {
	return line;
    }

    public Type type() {
	return type;
    }

    public abstract SymbolTable evalStatement(SymbolTable symbolTable);

    public abstract SymbolTable visible(SymbolTable symbolTable, Boolean visible);

    @Override
    public <T> void accept(BasicVisitor v, T context) {
	v.visit(this);
    }

}
