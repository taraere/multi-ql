package uva.ql.ast.values.types;

import uva.ql.ast.abstracts.Type;

public class Bool extends Type {

	private String type = "boolean";

	@Override
	public String getType() {
		return this.type;
	}
}
