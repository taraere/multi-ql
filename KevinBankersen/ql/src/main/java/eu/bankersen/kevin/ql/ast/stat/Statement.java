package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.AcceptMethods;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.SymbolTableBuilder;

public abstract class Statement implements AcceptMethods {
    
    private final boolean isQuestion;
    
    Statement(boolean isQuestion) {
	this.isQuestion = isQuestion;
    }
    
    public boolean isQuestion() {
	return isQuestion;
    }
    
    public abstract SymbolTable visible(SymbolTable symbolTable, Boolean visible);

    public abstract SymbolTable evalStatement(SymbolTable symbolTable);
    
    public abstract SymbolTableBuilder buildSymbolTable(SymbolTableBuilder builder);

}
