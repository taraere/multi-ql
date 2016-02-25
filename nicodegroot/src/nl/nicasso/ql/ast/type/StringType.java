package nl.nicasso.ql.ast.type;

import nl.nicasso.ql.ast.Traversable;
import nl.nicasso.ql.ast.Visitor;

public class StringType extends Type {

	private final String type;

	public StringType() {
		super();
		this.type = "String";
	}

	public String getType() {
		return type;
	}
	
	public boolean CompatibleWith(Type type) {
		switch(type.getType()) {
			case "Boolean":
				return false;
			case "Integer":
				return false;
			case "Money":
				return false;
			case "String":
				return true;
			default:
				return false;
		}
	}
	
}
