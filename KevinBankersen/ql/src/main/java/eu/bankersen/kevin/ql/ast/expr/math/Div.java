package eu.bankersen.kevin.ql.ast.expr.math;

import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.IntegerExpr;
import eu.bankersen.kevin.ql.context.SymbolTable;

public class Div extends IntegerExpr {

    public Div(final Expr lhs, final Expr rhs,  final int line) {
	super(lhs, rhs, line);
    }

    @Override
    public final Integer eval(SymbolTable symbolTable) throws EvaluateExeption {
	return (Integer) lhs().eval(symbolTable) / (Integer) rhs().eval(symbolTable);
    }

}
