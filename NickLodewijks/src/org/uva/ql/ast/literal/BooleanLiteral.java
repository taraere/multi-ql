package org.uva.ql.ast.literal;

import org.uva.ql.ast.ASTNodeVisitor;

public class BooleanLiteral extends Literal<Boolean> {

	public BooleanLiteral(boolean value) {
		super(value);
	}

	@Override
	public <T, U> T accept(ASTNodeVisitor<T, U> visitor, U context) {
		return visitor.visit(this, context);
	}
}