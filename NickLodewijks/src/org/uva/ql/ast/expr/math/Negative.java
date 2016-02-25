package org.uva.ql.ast.expr.math;

import org.antlr.v4.runtime.ParserRuleContext;
import org.uva.ql.ast.ASTNodeVisitor;
import org.uva.ql.ast.expr.Expr;
import org.uva.ql.ast.expr.UnaryExpr;

public class Negative extends UnaryExpr {

	public Negative(ParserRuleContext context, Expr expr) {
		super(context, expr);
	}

	@Override
	public <T, U> T accept(ASTNodeVisitor<T, U> visitor, U context) {
		return visitor.visit(this, context);
	}
}