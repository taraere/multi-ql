package eu.bankersen.kevin.ql.ast.form;

import java.util.List;

import eu.bankersen.kevin.ql.ast.BasicVisitor;
import eu.bankersen.kevin.ql.ast.AcceptVisitor;
import eu.bankersen.kevin.ql.ast.stat.AbstractStatement;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public class Body implements AcceptVisitor {

    private final List<AbstractStatement> statements;

    public Body(List<AbstractStatement> statements) {
	this.statements = statements;
    }

    public List<AbstractStatement> statements() {
	return statements;
    }

    public SymbolTable evalBody(SymbolTable symbolTable) {
	
	for (AbstractStatement s : statements) {
	    symbolTable = s.evalStatement(symbolTable);
	}
	return symbolTable;
    }

    public SymbolTable visible(SymbolTable symbolTable, Boolean visible) {

	for (AbstractStatement s : statements) {
	    symbolTable = s.visible(symbolTable, visible);
	}
	return symbolTable;
    }
    
    @Override
    public <T> void accept(BasicVisitor v, T context) {
	v.visit(this);
    }
}