package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.BasicVisitor;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public abstract class AbstractQuestion extends AbstractStatement {

    private final String name;
    private final String text;

    public AbstractQuestion(String name, String text, Type type, Expr expr, int line) {
	super(type, expr, line);
	this.name = name;
	this.text = text.substring(1, text.length() - 1);
    }

    public String text() {
	return text;
    }
    
    public String name() {
	return name;
    }
    
    public SymbolTable visible(SymbolTable symbolTable, Boolean visible) {
	symbolTable.setVisibility(this.name(), visible);
	return symbolTable;
    }
    
    @Override
    public <T> void accept(BasicVisitor v, T context) {
	v.visit(this);
    }
}