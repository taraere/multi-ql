package uva.ql.ast.expressions.types;

import uva.ql.ast.abstracts.Type;

public class Divide extends Type {

	private String type = "divide";

	@Override
	public String getType() {
		return this.type;
	}
}