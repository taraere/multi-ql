package org.uva.sea.ql.ast.tree.expr.binary;

import org.uva.sea.ql.ast.tree.expr.Expr;
import org.uva.sea.ql.ast.visitor.interfaces.ExprVisitor;

/**
 * Created by roydewildt on 04/02/16.
 */
public class Div extends BinaryExpr {

    public Div(int line, Expr lhs, Expr rhs) {
        super(line, lhs, rhs);
    }

    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public <EXPR, CONTEXT> EXPR accept(ExprVisitor<EXPR, CONTEXT> visitor, CONTEXT context) {
        return visitor.visit(this,context);
    }
}