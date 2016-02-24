package eu.bankersen.kevin.ql.ast.form;

import java.util.List;

import eu.bankersen.kevin.ql.ast.stat.Statement;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;

public class Body {

    private final List<Statement> statements;

    public Body(List<Statement> statements) {
	this.statements = statements;
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

	// When a block is checked its contents must be hidden.	
	return visible(context, false);

    }

    public SymbolTable visible(SymbolTable symbolTable, Boolean visible) {

	for (Statement s : statements) {
	    symbolTable = s.visible(symbolTable, visible);
	}
	System.out.println(visible);
	return symbolTable;
    }

    // Make this a nice interface..
    public Context visible(Context context, Boolean visible) {

	for (Statement s : statements) {
	    context = s.visible(context, visible);
	}

	return context;
    }

    @Override
    public String toString() {

	StringBuilder sb = new StringBuilder();

	statements.forEach(statement -> sb.append(statement.toString()));

	return sb.toString();
    }

    public List<Statement> getStatements() {
	return statements;
    }
}
