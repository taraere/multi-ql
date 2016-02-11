package eu.bankersen.kevin.ql.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.expr.*;
import eu.bankersen.kevin.ql.ast.expr.logic.*;
import eu.bankersen.kevin.ql.ast.expr.math.*;
import eu.bankersen.kevin.ql.ast.stat.*;
import eu.bankersen.kevin.ql.ast.form.*;
import eu.bankersen.kevin.ql.ast.var.*;
import eu.bankersen.kevin.ql.parser.QLParser.FormContext;

public class FormParser {
	
	private final String input;
	private FormContext formContext;
	private QLParser parser;
	
	public FormParser(String input){
		this.input = input;
		parse();
	}
	
	
	private void parse(){
		
		ANTLRInputStream ANTLRstream = new ANTLRInputStream(input);
		
		QLLexer lexer = new QLLexer(ANTLRstream);
		
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		parser = new QLParser(tokenStream);
		
		formContext = parser.form();
		
		Log.info("File Parsed");
	}
	
	public FormContext getFormContext(){
		return formContext;
	}
	
	public Form getForm(){
		return formContext.result;
	}
	
	public String getParseErrors(){
		return "";
	}
	
	public String[] getParseRules(){
		return parser.getRuleNames();
	}
}