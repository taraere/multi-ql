package eu.bankersen.kevin.ql.util.testing.old;

import eu.bankersen.kevin.ql.ast.Type;

public class BooleanType extends ValueObject {

    public BooleanType() {
	super(Type.BOOLEAN, Type.EMPTY);
    }
    
    public BooleanType(boolean value) {
	super(Type.BOOLEAN, value);
    }
}
