package eu.bankersen.kevin.ql.ast.form;

import java.util.List;

import eu.bankersen.kevin.ql.ast.AcceptMethods;
import eu.bankersen.kevin.ql.ast.stat.Statement;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.SymbolTableBuilder;

public class Body implements AcceptMethods {

    private final List<Statement> statements;

    public Body(List<Statement> statements) {
	this.statements = statements;
    }

    public List<Statement> statements() {
	return statements;
    }

    public SymbolTable evalBody(SymbolTable symbolTable) {

	// To evaluate a block its contents must be visible.
	symbolTable = visible(symbolTable, true);

	for (Statement s : statements) {
	    symbolTable = s.evalStatement(symbolTable);
	}
	return symbolTable;
    }

    public Context checkType(Context context) {
	for (Statement s : statements) {
	    context = s.checkType(context);
	}
	return context;
    }


    public SymbolTable visible(SymbolTable symbolTable, Boolean visible) {

	for (Statement s : statements) {
	    symbolTable = s.visible(symbolTable, visible);
	}
	return symbolTable;
    }


    public List<Statement> getStatements() {
	return statements;
    }

    public SymbolTableBuilder buildSymbolTable(SymbolTableBuilder builder) {
	for (Statement s : statements) {
	    builder = s.buildSymbolTable(builder);
	}
	return builder;
    }
}
