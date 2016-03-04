package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;
import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;

public class And extends BooleanExpr {

    public And(Expr lhs, Expr rhs, int line) {
	super(lhs, rhs, line);
    }

    @Override
    public Boolean eval(SymbolTable symbolTable) throws EvaluateExeption {
	return (Boolean) lhs().eval(symbolTable) && (Boolean) rhs().eval(symbolTable);
    }
    
    @Override
    public Context checkType(Context context) {
	return context.evaluate(this);
    }
}
