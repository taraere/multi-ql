package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.Type;
import eu.bankersen.kevin.ql.symboltable.SymbolTabel;

public abstract class BooleanExpr extends Expr {

    private final Type type = Type.BOOLEAN;
    
    protected Expr lhs;
    protected Expr rhs;

    public abstract Boolean result();

    @Override
    public final void checkType() {
	lhs.checkType();
	rhs.checkType();
	
	if (!lhs.getType().equals(rhs.getType())) {
	  SymbolTabel.addError("Type mismatch lhs=" + lhs.getType() + " rhs=" + rhs.getType());  
	}
    }

    @Override
    public final Type getType() {
	return type;
    }
}