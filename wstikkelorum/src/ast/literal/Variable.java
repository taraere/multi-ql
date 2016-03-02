package ast.literal;

import ast.expression.Expression;
import ast.visitor.Type;
import ast.visitor.Visitor;

public class Variable extends Expression {
	private String name;
	private VariableType type;

	public Variable(int lineNumber, String name, VariableType type) {
		super(lineNumber);
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public VariableType getType() {
		return type;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
