package eu.bankersen.kevin.ql;

import java.io.IOException;

import com.esotericsoftware.minlog.Log;
import eu.bankersen.kevin.ql.ast.form.Form;
import eu.bankersen.kevin.ql.parser.FormParser;
import eu.bankersen.kevin.ql.symboltable.Context;

/**
 * Hello world!
 *
 */
public final class App {
    
    private App() {
    }

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
	} else {
	    Log.info("File Parsed");
	}

	Context context = Context.getInstance();

	// Trying to type check.
	Log.info("Type Check Start");
	parsedForm.checkType();
	if (context.getErrors().size() > 0) {
	    context.getErrors().forEach(error -> Log.error(error.toString()));
	    Log.error("Type Check error, Terminating!");
	    System.exit(1);
	} else {
	    Log.info("Type Check succesful");
	}


	Log.info("\n\n****************************\n"
		   + "* Doing random weird stuff *\n"
		   + "****************************\n");

	if (selectedForm == 1) {

	    Log.info("Starting State");
	    parsedForm.eval(); // Initialize the form
	    Log.info(parsedForm.toString());

	    Log.info("Awnser european: yes");
	    context.updateSymbol("European", new Boolean(true));
	    parsedForm.eval();
	    Log.info(parsedForm.toString());

	    Log.info("Awnser name: Kevin");
	    context.updateSymbol("name", new String("Kevin"));
	    parsedForm.eval();
	    Log.info(parsedForm.toString());

	    Log.info("Awnser age: 26");
	    context.updateSymbol("age", new Integer(26));
	    parsedForm.eval();
	    Log.info(parsedForm.toString());

	    Integer age = 4;
	    Log.info("Awnser startSchool: " + age.toString());
	    context.updateSymbol("startSchool", age);
	    parsedForm.eval();
	    Log.info(parsedForm.toString());

	    Log.info(parsedForm.toString());
	}

    }
}
