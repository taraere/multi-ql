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
	return retrieve(symbol);
    }

    public Boolean checkID(String name) {
	return symbolTable.containsKey(name);
    }

    public void addSymbol(String name, String question, Type type, Object value) {
	symbolTable.put(name, new Symbol(name, question, type, value));
    }

    public void updateSymbol(String name, Object value) {
	Log.info(this.toString());
	Symbol symbol = retrieve(name);

	symbol.setValue(value);    

	symbolTable.put(name, symbol);
    }

    public void setVisibility(String name, Boolean active) {
	Symbol symbol = retrieve(name);
	symbol.setActive(active);
	if (!active) {
	    symbol.setValue(Type.EMPTY);
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
	    return new Symbol(name, "", Type.UNDIFINED, null);
	}
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();

	for (Symbol object : symbolTable.values()) {
	    if (object.getActive()) {
		sb.append(object.toString() + "\n"); 
	    }
	}
	return sb.toString();
    }

}