package uva.ql.ast.expressions;

import uva.ql.ast.abstracts.Node;
import uva.ql.ast.abstracts.Type;
import uva.ql.ast.expressions.abstracts.LogicalOperator;
import uva.ql.ast.expressions.types.Or;

public class ExpOr extends LogicalOperator {

	private Type type = new Or();
	
	public ExpOr(Node parent, Node lhs, Node rhs, int startLine, int startColumn) {
		super(parent, startLine, startColumn, lhs, rhs);
	}

	@Override
	public Type getType() {
		return type;
	}
}
