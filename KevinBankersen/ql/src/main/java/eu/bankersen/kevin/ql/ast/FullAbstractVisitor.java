package eu.bankersen.kevin.ql.ast;

import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;
import eu.bankersen.kevin.ql.ast.expr.Expr;
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
import eu.bankersen.kevin.ql.ast.form.Body;
import eu.bankersen.kevin.ql.ast.form.Form;
import eu.bankersen.kevin.ql.ast.stat.AbstractQuestion;
import eu.bankersen.kevin.ql.ast.stat.AbstractStatement;
import eu.bankersen.kevin.ql.ast.stat.ComputedQuestion;
import eu.bankersen.kevin.ql.ast.stat.ElseStatement;
import eu.bankersen.kevin.ql.ast.stat.IFStatement;
import eu.bankersen.kevin.ql.ast.stat.NormalQuestion;

public abstract class FullAbstractVisitor<T, U> implements FullVisitor<T, U> {

    @Override
    public abstract T visit(Form o, U context);

    @Override
    public void visit(Body o) {
    }

    @Override
    public void visit(AbstractStatement o) {
    }

    @Override
    public void visit(ElseStatement o) {
    }

    @Override
    public void visit(IFStatement o) {
    }

    @Override
    public void visit(AbstractQuestion o) {
    }

    @Override
    public void visit(NormalQuestion o) {
    }

    @Override
    public void visit(ComputedQuestion o) {
    }

    @Override
    public void visit(Expr expr) {
    }

    @Override
    public void visit(NumberExpr expr) {
    }

    @Override
    public void visit(Sub o) {
    }

    @Override
    public void visit(Add o) {
    }

    @Override
    public void visit(Div o) {
    }

    @Override
    public void visit(Mul o) {
    }

    @Override
    public void visit(Pos o) {
    }

    @Override
    public void visit(Neg o) {
    }

    @Override
    public void visit(BooleanExpr expr) {
    }

    @Override
    public void visit(Or o) {
    }

    @Override
    public void visit(And o) {
    }

    @Override
    public void visit(Eq o) {
    }

    @Override
    public void visit(GEq o) {
    }

    @Override
    public void visit(GT o) {
    }

    @Override
    public void visit(LEq o) {
    }

    @Override
    public void visit(LT o) {
    }

    @Override
    public void visit(NEq o) {
    }

    @Override
    public void visit(Not o) {
    }

    @Override
    public void visit(Identifier o) {
    }

    @Override
    public void visit(Literal o) {
    }
}
