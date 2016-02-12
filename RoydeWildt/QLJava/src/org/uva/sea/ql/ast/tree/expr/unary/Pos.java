package org.uva.sea.ql.ast.tree.expr.unary;

import org.uva.sea.ql.ast.visitor.Visitor;
import org.uva.sea.ql.ast.tree.expr.Expr;

/**
 * Created by roydewildt on 04/02/16.
 */
public class Pos extends UnaryExpr {
    Expr value;

    public Pos(int line, Expr lhs){
        super(line);
        this.value = lhs;
    }
    public <T> T accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String getSymbol() {
        return "+";
    }

    public Expr getValue() {
        return value;
    }
}