package eu.bankersen.kevin.ql.ast;

import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;
import eu.bankersen.kevin.ql.ast.expr.NumberExpr;
import eu.bankersen.kevin.ql.ast.expr.logic.And;
import eu.bankersen.kevin.ql.ast.expr.logic.Eq;
import eu.bankersen.kevin.ql.ast.expr.logic.GEq;
import eu.bankersen.kevin.ql.ast.expr.logic.GT;
import eu.bankersen.kevin.ql.ast.expr.logic.LEq;
import eu.bankersen.kevin.ql.ast.expr.logic.LT;
import eu.bankersen.kevin.ql.ast.expr.logic.NEq;
import eu.bankersen.kevin.ql.ast.expr.logic.Not;
import eu.bankersen.kevin.ql.ast.expr.logic.Or;
import eu.bankersen.kevin.ql.ast.expr.math.Add;
import eu.bankersen.kevin.ql.ast.expr.math.Div;
import eu.bankersen.kevin.ql.ast.expr.math.Mul;
import eu.bankersen.kevin.ql.ast.expr.math.Neg;
import eu.bankersen.kevin.ql.ast.expr.math.Pos;
import eu.bankersen.kevin.ql.ast.expr.math.Sub;

public interface FullVisitor<T, U> extends BasicVisitor<T, U> {
    
    void visit(NumberExpr o);

    void visit(Sub o);

    void visit(Add o);

    void visit(Div o);

    void visit(Mul o);

    void visit(Pos o);

    void visit(Neg o);
    
    void visit(BooleanExpr o);

    void visit(Or o);

    void visit(And o);

    void visit(Eq o);

    void visit(GEq o);

    void visit(GT o);

    void visit(LEq o);

    void visit(LT o);

    void visit(NEq o);

    void visit(Not o);

}
