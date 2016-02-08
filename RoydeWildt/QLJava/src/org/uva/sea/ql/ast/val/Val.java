package org.uva.sea.ql.ast.val;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.checker.Visitor;
import org.uva.sea.ql.ast.expr.Expr;

import java.util.List;

/**
 * Created by roydewildt on 04/02/16.
 */
abstract public class Val extends Expr {
    private String value;

    public Val(){}
    public Val(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + value + ")";
    }

    public List<? extends Node> accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public String getValue() {
        return value;
    }
}
