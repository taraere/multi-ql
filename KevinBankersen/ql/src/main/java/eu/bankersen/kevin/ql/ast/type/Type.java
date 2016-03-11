package eu.bankersen.kevin.ql.ast.type;

public abstract class Type {

    public abstract boolean isSimilar(Type type);

    public boolean isCompatible(Type type) {
	return isSimilar(type);
    }
    
    public boolean isNumber() {
	return false;
    }
    
    public boolean isString() {
	return false;
    }
    
    public boolean isBoolean() {
	return false;
    }
    
    public String formatTypeToString(String value) {
	return value;
    }

    public Object parseValue(String value) {
	return null;
    }

    public Object parseValue(Double value) {
	return null;
    }

    public Object parseValue(Boolean value) {
	return null;
    }

}