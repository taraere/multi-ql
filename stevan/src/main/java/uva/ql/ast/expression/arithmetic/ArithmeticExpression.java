package uva.ql.ast.expression.arithmetic;

import uva.ql.ast.Node;
import uva.ql.ast.expression.BinaryExpression;
import uva.ql.ast.expression.Expression;

public abstract class ArithmeticExpression extends BinaryExpression{

	public ArithmeticExpression(Node parent, int startLine, int startColumn,
			Expression lhs, Expression rhs) {
		super(parent, startLine, startColumn, lhs, rhs);
	}

}
