package eu.bankersen.kevin.ql.typechecker;

import java.util.List;

import eu.bankersen.kevin.ql.typechecker.errors.TypeCheckError;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;
import eu.bankersen.kevin.ql.typechecker.warnings.TypeCheckWarning;

public class TypeCheckException extends Exception {
    
    private final List<TypeCheckError> errors;
    private final List<TypeCheckWarning> warnings;
    private final SymbolTable symbolTable;
    
    public TypeCheckException(List<TypeCheckWarning> warningList, List<TypeCheckError> errorList, SymbolTable symboltable) {
	this.warnings = warningList;
	this.errors = errorList;
	this.symbolTable = symboltable;
    }
    
    public List<TypeCheckWarning> getWarnings() {
	return warnings;
    }
    
    public List<TypeCheckError> getErrors() {
	return errors;
    }
    
    public SymbolTable getSymbolTable() {
	return symbolTable;
    }

}