package eu.bankersen.kevin.ql.context;

import eu.bankersen.kevin.ql.ast.Identifier;
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

public interface ContextInterface {

    // Mathematical Expressions
    Context evaluate(Add operation);
    Context evaluate(Sub operation);
    Context evaluate(Div operation);
    Context evaluate(Mul operation);
    Context evaluate(Neg operation);
    Context evaluate(Pos operation);

    // Boolean Expression that Require Boolean
    Context evaluate(Not operation);
    Context evaluate(Or operation);
    Context evaluate(And operation);

    //Boolean Expressions for Equality
    Context evaluate(NEq operation);
    Context evaluate(LT operation);
    Context evaluate(LEq operation);
    Context evaluate(GT operation);
    Context evaluate(GEq operation);
    Context evaluate(Eq operation);
    
    // Looking at Identifiers
    Context evaluate(Identifier id);

    // Looking at Variables
    Context evaluate(Variable variable);
}