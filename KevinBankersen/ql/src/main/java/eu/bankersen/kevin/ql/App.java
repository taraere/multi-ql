package eu.bankersen.kevin.ql;

import java.io.IOException;
import java.util.Arrays;

import org.antlr.v4.runtime.tree.gui.TreeViewer;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.form.Form;
import eu.bankersen.kevin.ql.parser.FormParser;
import eu.bankersen.kevin.ql.parser.QLParser.FormContext;
import eu.bankersen.kevin.ql.symboltable.SymbolTabel;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(final String[] args) {
	Log.INFO(); // Set log level
	Log.setLogger(new CustomLogger()); // Our custom logger.

	System.out.println("Welcome to the Questionnaire Language (QL)!\n");

	String form;
	
	int selectedForm = 1;
	String resource;
	
	switch(selectedForm) {
	default: resource = "resources/Tax.form";
	case 1 : resource = "resources/Tax2.form";
	}
	
	try { // Currently the top level so here we catch exceptions.
	    form = new FileReader().read(resource);
	} catch (IOException e) {
	    Log.error("Unable to read file, Terminating");
	    System.exit(1);
	    form = null;
	}

	FormParser parser = new FormParser(form);

	Form parsedForm = parser.getForm();

	if (parser.getParseErrors() > 0) {
	    Log.error("Parse Errors, Terminating!");
	    System.exit(1);
	} else Log.info("File Parsed");

	FormContext formContext = parser.getFormContext();

	/*
	 * This is Lame code for prototyping.
	 */


	// Show UI
	boolean show = false;
	if (show) {
	    Log.info("Build view");
	    TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getParseRules()), formContext);
	    viewr.setScale(1.5); // scale a little
	    viewr.open(); // Open the viewer
	}


	// Trying to type check.
	Log.info("Type Check Start");
	if (!parsedForm.checkType()) {
	    SymbolTabel.getErrors().forEach(error -> Log.error(error.toString()));
	    Log.error("Type Check error, Terminating!");
	    System.exit(1);
	}else Log.info("Type Check succesful");

	Log.debug(parsedForm.toString());

	Log.debug(SymbolTabel.getContents());

	Boolean y = true;
	Integer z = 5;
	Integer q = 150;
	
	Log.info("Doing random weird stuff");

	
	
	if (selectedForm == 0){
	SymbolTabel.updateValue("hasBoughtHouse", z);
	parsedForm.result();
	Log.info(SymbolTabel.getContents());
	
	SymbolTabel.updateValue("hasMaintLoan", y);
	parsedForm.result();
	Log.info(SymbolTabel.getContents());
	
	SymbolTabel.updateValue("privateDebt", q);
	parsedForm.result();
	Log.info(SymbolTabel.getContents());
	} else if (selectedForm == 1) {
	    
	    Log.info("Starting State");
	    parsedForm.result(); // Initialize the form
	    Log.info(parsedForm.toString());
	    
	    Log.info("Awnser european: yes");
	    SymbolTabel.updateValue("european", new Boolean(true));
	    parsedForm.result();
	    Log.info(parsedForm.toString());
	    
	    Log.info("Awnser name: Kevin");
	    SymbolTabel.updateValue("name", new String("Kevin"));
	    parsedForm.result();
	    Log.info(parsedForm.toString());
	    
	    Log.info("Awnser age: 26");
	    SymbolTabel.updateValue("age", new Integer(26));
	    parsedForm.result();
	    Log.info(parsedForm.toString());
	    
	    Log.info("Awnser startSchool: 4");
	    SymbolTabel.updateValue("startSchool", new Integer(4));
	    parsedForm.result();
	    Log.info(parsedForm.toString());
	    
	    Log.info(parsedForm.toString());
	    
	    
	    
	    
	}


    }
}