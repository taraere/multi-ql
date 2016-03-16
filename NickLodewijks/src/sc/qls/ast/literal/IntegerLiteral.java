package sc.qls.ast.literal;

import sc.ql.value.NumberValue;

public final class IntegerLiteral extends Literal {

	private final NumberValue value;

	public IntegerLiteral(Integer value) {
		this.value = new NumberValue(value);
	}

	public NumberValue getValue() {
		return value;
	}
}
