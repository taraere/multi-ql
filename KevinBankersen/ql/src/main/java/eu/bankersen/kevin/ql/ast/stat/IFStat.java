package eu.bankersen.kevin.ql.ast.stat;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.Type;
import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.form.Body;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.context.errors.ExprTypeError;

public class IFStat extends Statement  {

    private final Expr expr;
    private final Body body;
    private final int line;
    private boolean exprValue;

    public IFStat(Expr expression, Body body, int line) {
	this.expr = expression;
	this.body = body;
	this.line = line;
	this.exprValue = false;
    }

    public Context checkType(Context context) {

	context = expr.checkType(context);
	context = body.checkType(context);

	Boolean check = expr.getType(context).equals(Type.BOOLEAN);

	if (!check) {
	    context.addError(new ExprTypeError(
		    line,
		    Type.BOOLEAN,
		    expr.getType(context)
		    ));
	}
	return context;
    }

    public SymbolTable evalStatement(SymbolTable symbolTable) {	

	try {
	    exprValue = (Boolean) expr.eval(symbolTable);
	} catch (EvaluateExeption e) {
	    Log.debug("If-statement cannot be evaluated");
	    exprValue = false;
	}

	Log.debug("If-statement is: " + exprValue);

	if (exprValue) {
	    symbolTable = visible(symbolTable, true);
	    return body.evalBody(symbolTable);
	} else {
	    return visible(symbolTable, false);
	} 
    }


    @Override
    public String toString() {

	if (exprValue) {
	    return body.toString();
	} else {
	    return "";
	}
    }

    @Override
    public SymbolTable visible(SymbolTable symbolTable, Boolean visible) {
	return body.visible(symbolTable, visible);
    }
    
    // Turn this into a nice interface..
    public Context visible(Context context, Boolean visible) {
	return body.visible(context, visible);
    }
    
}
