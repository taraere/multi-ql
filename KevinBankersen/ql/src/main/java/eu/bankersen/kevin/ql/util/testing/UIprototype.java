package eu.bankersen.kevin.ql.util.testing;

import java.io.IOException;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.form.Form;
import eu.bankersen.kevin.ql.context.TypeChecker;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.errors.ContextBuildException;
import eu.bankersen.kevin.ql.interpreter.Interpreter;
import eu.bankersen.kevin.ql.parser.ANTLRParseException;
import eu.bankersen.kevin.ql.parser.FormParser;
import eu.bankersen.kevin.ql.util.FileReader;

public class UIprototype {
    
    public static void main(String[] args) {
	// The example form.
	String resource = "resources/Tax.form";
	
	// Read the file.
	String file;
	try { // Currently the top level so here we catch exceptions.
	    file = new FileReader().read(resource);
	} catch (IOException e) {
	    Log.error("Unable to read file, Terminating");
	    System.exit(1);
	    file = null;
	}
	
	// Parse the form to an AST
	Form form;
	try {
	    FormParser parser = new FormParser(file);
	    form = parser.getForm();
	    Log.info("File Parsed");
	} catch (ANTLRParseException e) {
	    form = null;
	    e.getErrors().forEach(error -> Log.error("Line " + error[0] + ": " + error[1]));
	    Log.error("Parse Errors, Terminating!");
	    System.exit(1);
	}
	
	// Build the context object (type-checking and symbol table)
	SymbolTable symbolTable;
	try {
	    symbolTable = new TypeChecker(form).getSymbolTable();
	    Log.info("Build Context");
	} catch (ContextBuildException e) {
	    symbolTable = null;
	    e.getErrors().forEach(error -> Log.error(error.toString()));
	    Log.error("Context errors, Terminating!");
	    System.exit(1);
	}
	
	// Create the GUI
	TestUI ui = new TestUI(symbolTable);
	
	Interpreter interp = new Interpreter(form, symbolTable);
	
	// Link Context to UI
	ui.addViewListener(interp);
	
	// Link UI to context
	interp.addDataListener(ui);
	
	ui.setVisible(true);

    }

}
