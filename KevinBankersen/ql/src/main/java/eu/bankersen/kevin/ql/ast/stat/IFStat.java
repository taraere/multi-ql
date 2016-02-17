package eu.bankersen.kevin.ql.ast.stat;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.Type;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.form.Block;
import eu.bankersen.kevin.ql.symboltable.SymbolTabel;

public class IFStat {

    private final Expr expr;
    private final Block body;

    public IFStat(final Expr expression, final Block body) {
	this.expr = expression;
	this.body = body;
    }

    public final void checkType() {

	expr.checkType();
	body.checkType();
	
	Boolean check = expr.getType().equals(Type.BOOLEAN);
	
	if (!check) {
	    SymbolTabel.addError("If statement needs a Boolean, statement=" + expr.getType());
	}
		
    }

    public final void result() {
	
	boolean statement; 
	
	try {
	    statement = (Boolean) expr.result();
	} catch (NullPointerException e) {
	    Log.info("If statement cannot be evaluated");
	    statement = false;
	}
	if (statement) {
	    body.show();
	    body.result();
	} else {
	    body.hide();
	}
    }

    public final Block getBody() {
	return body;
    }

    @Override
    public final String toString() {
	return body.toString();
    }
}
