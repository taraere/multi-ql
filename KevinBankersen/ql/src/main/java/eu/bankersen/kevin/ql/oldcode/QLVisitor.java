package eu.bankersen.kevin.ql.oldcode;

import eu.bankersen.kevin.ql.ast.Identifier;
import eu.bankersen.kevin.ql.ast.Literal;
import eu.bankersen.kevin.ql.ast.Variable;
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
import eu.bankersen.kevin.ql.ast.stat.IFStat;
import eu.bankersen.kevin.ql.ast.stat.Question;
import eu.bankersen.kevin.ql.ast.stat.Statement;

public interface QLVisitor {
    
    void visit(Form data);
    void visit(Body data);
    void visit(Statement data);
    void visit(IFStat data);
    void visit(Question data);
    void visit(Variable data);
    void visit(Identifier data);
    void visit(Literal data);
    void visit(And data);
    void visit(Eq data);
    void visit(GEq data);
    void visit(GT data);
    void visit(LEq data);
    void visit(LT data);
    void visit(NEq data);
    void visit(Not data);
    void visit(Or data);
    void visit(Add data);
    void visit(Div data);
    void visit(Mul data);
    void visit(Neg data);
    void visit(Pos data);
    void visit(Sub data);

}
