package eu.bankersen.kevin.ql.context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import eu.bankersen.kevin.ql.ast.stat.Question;
import eu.bankersen.kevin.ql.ast.type.Type;

public class SymbolTableBuilder {

    private final Map<String, List<Symbol>> symbolTable;

    public SymbolTableBuilder() {
	symbolTable = new LinkedHashMap<>();
    }

    public Map<String, List<Symbol>> getSymbolTable() {
	return symbolTable;
    }

    private void addSymbol(Boolean computed, String name, String question, Type type) {
	Symbol symbolObject = new Symbol(computed, name, question, type, null);
	List<Symbol> symbolList;
	if (symbolTable.containsKey(name)) {
	    symbolList = symbolTable.get(name);
	    symbolList.add(symbolObject);
	} else {
	    symbolList = new ArrayList<>();
	    symbolList.add(symbolObject);
	}
	symbolTable.put(name, symbolList);
    }

    public SymbolTableBuilder construct(Question data) {
	addSymbol(data.isComputed(), data.getName(), data.getText(), data.getType());
	return this;
    }

}
