package eu.bankersen.kevin.ql.ast.expr.math;

import java.math.BigDecimal;

import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.NumberExpr;
import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTable;

public class Div extends NumberExpr {

    public Div(final Expr lhs, final Expr rhs,  final int line) {
	super(lhs, rhs, line);
    }

    @Override
    public final BigDecimal eval(SymbolTable symbolTable) throws EvaluateExeption {
	return ((BigDecimal) lhs().eval(symbolTable)).divide((BigDecimal) rhs().eval(symbolTable), 2 , BigDecimal.ROUND_CEILING);
    }

    @Override
    public Context checkType(Context context) {
	return context.evaluate(this);
    }


}
