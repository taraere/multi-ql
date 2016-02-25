package issue;

import ast.expression.Expression;
import ast.visitor.Type;

public class InvalidTypeForOperant extends Issue{
	public InvalidTypeForOperant(Expression expression, Type expectedType, Type actualType){
		super.errorMessage = String.format("Invalid type for operant. Expected Type: %s. Actual type: %s. On line number: %d",
				expectedType, actualType, expression.getLineNumber());
	}

}