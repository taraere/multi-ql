package org.uva.ql.ast.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.uva.ql.ast.ASTNodeVisitor;

public class Mul extends BinaryExpr {

	public Mul(ParserRuleContext context, Expr lhs, Expr rhs) {
		super(context, lhs, rhs);
	}

	@Override
	public Integer interpret(Context context) {
		return (Integer) left().interpret(context) * (Integer) right().interpret(context);
	}

	@Override
	public <T, U> T accept(ASTNodeVisitor<T, U> visitor, U context) {
		return visitor.visit(this, context);
	}
}
