package eu.bankersen.kevin.ql.context;

import java.util.LinkedHashMap;
import java.util.Map;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.Type;

public class SymbolTable {
    
    private final String name;
    private final Map<String, Symbol> symbolTable;
    
    public SymbolTable(String name) {
	this.name = name;
	symbolTable = new LinkedHashMap<>();
    }
    
    public Symbol getSymbol(String symbol) {
	return symbolTable.get(symbol);
    }
    
    public Boolean checkID(String name) {
	return symbolTable.containsKey(name);
    }
    
    public void addSymbol(String name, String question, Type type, Object value) {
	symbolTable.put(name, new Symbol(name, question, type, value));
    }
    
    public void updateSymbol(String name, Object value) {
	Symbol symbol = symbolTable.get(name);
	symbol.setValue(value);
	symbolTable.put(name, symbol);
    }
    
    public void setVisibility(String name, Boolean active) {
	Symbol symbol = symbolTable.get(name);
	symbol.setActive(active);
	symbolTable.put(name, symbol);
    }  
    
    public Map<String, Symbol> getEntries() {
	return symbolTable;
    }

}
