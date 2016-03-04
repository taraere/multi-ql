package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.Variable;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.SymbolTableBuilder;

public abstract class Question extends Statement {

    private final String name;
    private final Type type;
    private final Expr expr;
    private final Boolean computed;
    private final int line;
    private final String text;

    private final Variable variable; // Refactor out soon..

    public Question(Boolean computed, Variable variable, String text) {
	super(true); // tell super we are a question, can we factor this out?
	
	this.variable = variable; // refactor out.. 
	this.text = text.substring(1, text.length() - 1);
	this.computed = computed;
	
	// This must change to constructor if working
	this.name = variable.getName();
	this.expr = variable.expr();
	this.type = variable.getType();
	this.line = variable.line();
    }

    public String getText() {
	return text;
    }
    
    // Refactor out
    public Variable variable() {
	return variable;
    }
    
    public Expr expr() {
	return expr;
    }
    
    public boolean isComputed() {
	return computed;
    }

    
    
    public Context checkType(Context context) {
	return variable.checkType(context, text, computed);
    }

    public Type getType() {
	return variable.getType();
    }
    
    public String getName() {
	return variable.getName();
    }
    
    public SymbolTable visible(SymbolTable symbolTable, Boolean visible) {
	symbolTable.setVisibility(this.getName(), visible);
	return symbolTable;
    }
    
    public SymbolTable evalStatement(SymbolTable symbolTable) {
	return variable.eval(symbolTable);
    }
    
    @Override
    public SymbolTableBuilder buildSymbolTable(SymbolTableBuilder builder) {
	return builder.construct(this);
    }
}
