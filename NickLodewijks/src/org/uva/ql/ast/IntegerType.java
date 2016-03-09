package org.uva.ql.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public final class IntegerType extends VariableType {

	public IntegerType(ParserRuleContext context) {
		super(context);
	}

	@Override
	public <T, U> T accept(ASTNodeVisitor<T, U> visitor, U context) {
		return visitor.visit(this, context);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof IntegerType;
	}

	@Override
	public int hashCode() {
		return 42;
	}
}