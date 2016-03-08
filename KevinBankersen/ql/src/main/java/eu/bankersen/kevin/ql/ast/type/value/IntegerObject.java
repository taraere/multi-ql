package eu.bankersen.kevin.ql.ast.type.value;

public class IntegerObject extends NumberObject {

    @Override
    public boolean isSimilar(QLObject type) {
	return type instanceof IntegerObject;
    }
    
    @Override
    public String toString() {
	return String.valueOf(super.value());
    }
}
