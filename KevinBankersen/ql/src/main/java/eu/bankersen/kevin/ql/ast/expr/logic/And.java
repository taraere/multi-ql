package eu.bankersen.kevin.ql.ast.expr.logic;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;
import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;

public class And extends BooleanExpr {

    public And(Expr lhs, Expr rhs, int line) {
	super(lhs, rhs, line);
    }

    @Override
    public Boolean eval(SymbolTable symbolTable) throws EvaluateExeption {
	return (Boolean) lhs().eval(symbolTable) && (Boolean) rhs().eval(symbolTable);
    }

}
