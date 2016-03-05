package eu.bankersen.kevin.ql.interpreter;


import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.form.Form;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.gui.ViewListener;

public class Interpreter implements ViewListener {

    private final Form form;
    private SymbolTable symbolTable;
    private List<DataListener> dataListeners;

    public Interpreter(Form form, SymbolTable symbolTable) {
	this.form = form;
	this.symbolTable = form.evalForm(symbolTable);
	this.dataListeners = new ArrayList<>();
    }

    public void addDataListener(DataListener listener) {
	dataListeners.add(listener);
    }

    private void dataUpdate() {
	dataListeners.forEach(listener -> listener.dataUpdate(symbolTable));
    }

    @Override
    public void viewUpdate(String name, Object value) {
	symbolTable.updateSymbol(name, value);
	symbolTable = form.evalForm(symbolTable);
	// Evaluate a second time to remove from invisible questions.
	symbolTable = form.evalForm(symbolTable);
	Log.info("Symbol Table Contents\n" + symbolTable.toString());
	dataUpdate();
    }
}
