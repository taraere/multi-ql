package eu.bankersen.kevin.ql.ast.expr;

import eu.bankersen.kevin.ql.ast.Type;

public abstract class IntegerExpr extends Expr {
    
    private final Type type = Type.INTEGER;
   
    protected Expr lhs;
    protected Expr rhs;

    public abstract Integer eval();

    @Override
    public final void checkType() {
	lhs.checkType();
	rhs.checkType();
	
	Boolean check = lhs.getType().equals(type) && rhs.getType().equals(type);
	
	if (!check) {
	    context.addError("Type mismatch lhs=" + lhs.getType() 
	    				+ " rhs=" + rhs.getType() 
	    				+ " expr=" + type);
	}
    }

    @Override
    public final Type getType() {
	return type;
    }

}