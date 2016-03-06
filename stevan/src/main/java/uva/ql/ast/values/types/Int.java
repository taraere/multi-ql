package uva.ql.ast.values.types;

import uva.ql.ast.abstracts.Type;


public class Int extends Type {

	private String type = "integer";

	@Override
	public String getType() {
		return this.type;
	}
}
