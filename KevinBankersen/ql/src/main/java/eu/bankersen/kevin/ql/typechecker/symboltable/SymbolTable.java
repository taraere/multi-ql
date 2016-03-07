package eu.bankersen.kevin.ql.typechecker.symboltable;

import java.util.LinkedHashMap;
import java.util.Map;


import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.ast.type.UndifinedType;

public class SymbolTable {

    private final Map<String, Symbol> symbolTable;

    public SymbolTable() {
	symbolTable = new LinkedHashMap<>();
    }

    public Symbol getSymbol(String symbol) {
	return retrieve(symbol);
    }

    public Boolean checkID(String name) {
	return symbolTable.containsKey(name);
    }

    public void addSymbol(Boolean computed, String name, String question, Type type, Object value) {
	symbolTable.put(name, new Symbol(computed, name, question, type, value));
    }
    
    public void addSymbol(String name, Symbol symbol) {
	symbolTable.put(name, symbol);
    }

    public void updateSymbol(String name, Object value) {
	Symbol symbol = retrieve(name);
	
	if (value == null) {
	    symbol.setActive(false);
	} else { 
	    symbol.setActive(true);
	}
	symbol.setValue(value);    
	symbolTable.put(name, symbol);
    }

    public void setVisibility(String name, Boolean active) {
	Symbol symbol = retrieve(name);
	symbol.setActive(active);
	if (active.equals(false)) {
	    symbol.setValue(null);
	}
	symbolTable.put(name, symbol);
    }  

    public Map<String, Symbol> getEntries() {
	return symbolTable;
    }

    private Symbol retrieve(String name) {
	if (symbolTable.containsKey(name)) {
	    return symbolTable.get(name);
	} else {
	 // Needed to continue TypeChecking in case a symbol is undefined
	    return new Symbol(null, name, "", new UndifinedType(), null);
	}
    }
    
    public int size() {
	return symbolTable.size();
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();

	for (Symbol object : symbolTable.values()) {
		sb.append(object.toString()); 
	}
	return sb.toString();
    }

}
