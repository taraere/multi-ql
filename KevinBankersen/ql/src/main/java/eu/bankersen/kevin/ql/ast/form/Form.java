package eu.bankersen.kevin.ql.ast.form;

import eu.bankersen.kevin.ql.ast.BasicVisitor;
import eu.bankersen.kevin.ql.ast.AcceptVisitor;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public class Form implements AcceptVisitor {

    private final String name;
    private final Body body;

    public Form(String name, Body body) {
	this.name = name;
	this.body = body;
    }
    
    public Body body() {
	return body;
    }
    
    public String name() {
	return name;
    }
    
    public SymbolTable evalForm(SymbolTable symbolTable) {
	return body.evalBody(symbolTable);
    }
    
    @Override
    public <T> void accept(BasicVisitor v, T context) {
	v.visit(this, context);
    }
    
    
    
}

