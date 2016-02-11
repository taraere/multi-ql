package eu.bankersen.kevin.ql;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.antlr.v4.runtime.tree.gui.TreeViewer;

import com.esotericsoftware.minlog.*;

import eu.bankersen.kevin.ql.ast.expr.SymbolTabel;
import eu.bankersen.kevin.ql.ast.expr.boolLiteral;
import eu.bankersen.kevin.ql.ast.form.Form;
import eu.bankersen.kevin.ql.ast.var.Type;
import eu.bankersen.kevin.ql.ast.var.Variable;
import eu.bankersen.kevin.ql.parser.FormParser;
import eu.bankersen.kevin.ql.parser.QLParser.FormContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Questionnaire Language (QL)!\n" );
        
        String form;
        try { // Currently the top level so here we catch exceptions.
        	form = new FileReader().read("resources/Tax.form");
		} catch (IOException e) {
			Log.error("Unable to read file, Terminating");
			System.exit(1);
			form = null;
		}
        
        FormParser parser = new FormParser(form);
        
        Form parsedForm = parser.getForm();
        
        FormContext formContext = parser.getFormContext();
        
        /*
         * This is Lame code for prototyping.
         */
        
		// Form to string
		//System.out.println(parsedForm.toString());
		
		// Show UI
		TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getParseRules()), formContext);
		viewr.setScale(1.5);// scale a little
		viewr.open(); // Open the viewer
		
		

		// Trying to create a symbolTable
		SymbolTabel symbolTable = new SymbolTabel();
		
		symbolTable.setValue("hasSoldHouse", (new Variable("hasSoldHouse", Type.BOOLEAN)));
		symbolTable.setValue("hasBoughtHouse", new Variable("hasBoughtHouse", Type.BOOLEAN));
		symbolTable.setValue("hasMaintLoan", new Variable("hasMaintLoan", Type.BOOLEAN));
		symbolTable.setValue("sellingPrice", new Variable("sellingPrice", Type.INTEGER));
		symbolTable.setValue("privateDebt", new Variable("privateDebt", Type.INTEGER));
		symbolTable.setValue("valueResidue", new Variable("valueResidue", Type.INTEGER));
		
		//TypeChecker test
		parsedForm.setSymbolTable(symbolTable);
		System.out.println("TypeCheck result: " + parsedForm.checkType());
		
        
    }
}