package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.form.Body;
import eu.bankersen.kevin.ql.ast.type.BooleanType;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.SymbolTableBuilder;
import eu.bankersen.kevin.ql.context.errors.ExprTypeError;

public class IFStat extends Statement  {

    private final Expr expr;
    private final Type type;
    private final Body body;
    private final int line;
    private boolean exprValue;

    public IFStat(Expr expression, Body body, int line) {
	super(false);
	this.expr = expression;
	this.type = new BooleanType();
	this.body = body;
	this.line = line;
	this.exprValue = false;
    }

    public Context checkType(Context context) {

	context = expr.checkType(context);
	context = body.checkType(context);

	if (!expr.getType(context.getSymbolTable()).isCompatible(type)) {
	    context.addError(new ExprTypeError(line, type, expr.getType(context.getSymbolTable())));
	}
	return context;
    }

    public SymbolTable evalStatement(SymbolTable symbolTable) {	

	try {
	    exprValue = (Boolean) expr.eval(symbolTable);
	} catch (EvaluateExeption e) {
	    exprValue = false;
	}

	if (exprValue) {
	    symbolTable = visible(symbolTable, true);
	    return body.evalBody(symbolTable);
	} else {
	    return visible(symbolTable, false);
	} 
    }

    public SymbolTable visible(SymbolTable symbolTable, Boolean visible) {
	return body.visible(symbolTable, visible);
    }
    
    @Override
    public SymbolTableBuilder buildSymbolTable(SymbolTableBuilder builder) {
	return body.buildSymbolTable(builder);
    }
}
