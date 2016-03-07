package eu.bankersen.kevin.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

import eu.bankersen.kevin.ql.ast.form.Form;
import eu.bankersen.kevin.ql.typechecker.analytics.CyclicAnalyzer;
import eu.bankersen.kevin.ql.typechecker.analytics.TypeAnalyzer;
import eu.bankersen.kevin.ql.typechecker.errors.TypeCheckError;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTableBuilder;
import eu.bankersen.kevin.ql.typechecker.warnings.TypeCheckWarning;

public class TypeChecker {
    
    private final Form form;
    private final SymbolTable symbolTable;
    private final List<TypeCheckError> errorList;
    private final List<TypeCheckWarning> warningList;
    
    public TypeChecker(Form form) throws TypeCheckException {
	this.errorList = new ArrayList<>();
	this.warningList = new ArrayList<>();
	this.form = form;
	
	SymbolTableBuilder builder = new SymbolTableBuilder(form);
	this.symbolTable = builder.getSymbolTable();
	
	warningList.addAll(builder.getWarnings());
	
	errorList.addAll(builder.getErrors());
		
	errorList.addAll(new TypeAnalyzer(symbolTable, form).getErrors());
	errorList.addAll(new CyclicAnalyzer(form).getErrors());
	
	if (!errorList.isEmpty() || !warningList.isEmpty()) {
	    throw new TypeCheckException(warningList, errorList, symbolTable);
	}
    }
    
    public SymbolTable getSymbolTable() {
	return symbolTable;
    }

}