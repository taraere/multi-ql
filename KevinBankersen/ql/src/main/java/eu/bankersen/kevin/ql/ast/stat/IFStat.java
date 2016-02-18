package eu.bankersen.kevin.ql.ast.stat;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.Type;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.form.Block;

public class IFStat extends AbstractStatement  {

    private final Expr expr;
    private final Block body;
    private final int line;
    private boolean statement;

    public IFStat(final Expr expression, final Block body, final int line) {
	this.expr = expression;
	this.body = body;
	this.line = line;
	this.statement = false;
    }

    public final void checkType() {

	expr.checkType();
	body.checkType();
	
	Boolean check = expr.getType().equals(Type.BOOLEAN);
	
	if (!check) {
	    super.context.addError("TYPE_ERROR @Line " + line 
		    			+ ": If must resolve to " + Type.BOOLEAN 
		    			+ " got " + expr.getType());
	}
	
    }

    @Override
    public final void eval() {
 
	try {
	    statement = (Boolean) expr.eval();
	} catch (NullPointerException e) {
	    Log.debug("If-statement cannot be evaluated");
	    statement = false;
	}
	
	Log.debug("If-statement is: " + statement);
	
	if (statement) {
	    visible(true);
	    body.eval();
	} else {
	    visible(false);
	}
    }

    public final Block getBody() {
	return body;
    }

    @Override
    public final String toString() {

	if (statement) {
	    return body.toString();
	} else {
	    return "";
	}
    }

    @Override
    public final void visible(final Boolean visible) {
	body.visible(visible);
    }
}
