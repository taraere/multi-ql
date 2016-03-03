package org.uva.sea.ql.type;

public class IntType extends Type {
	
	@Override
	public boolean equals(Object t) {
		return t instanceof IntType;
	}

	@Override
	public String toString() {
		return "Integer";
	}
	
}
