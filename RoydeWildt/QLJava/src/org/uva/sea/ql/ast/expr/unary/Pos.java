package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.checker.Visitor;
import org.uva.sea.ql.ast.expr.Expr;

import java.util.List;

/**
 * Created by roydewildt on 04/02/16.
 */
public class Pos extends UnaryExpr {

    public Pos(Expr lhs){
        super(lhs);
    }
    public List<? extends Node> accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
