package ql.issue;

import ql.ast.expression.Expression;
import ql.ast.types.ValueType;

public class ConditionNonBoolean extends Issue {
	public ConditionNonBoolean(Expression expression, ValueType expectedType, ValueType actualType) {
		super.errorMessage = String
				.format("Invalid type for condition. Expected Type: %s. Actual type: %s. On line number: %d",
						expectedType, actualType, expression.getLineNumber());
	}
}
