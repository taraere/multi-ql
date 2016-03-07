package eu.bankersen.kevin.ql.ast.expr.math;

import java.math.BigDecimal;

import eu.bankersen.kevin.ql.ast.BasicVisitor;
import eu.bankersen.kevin.ql.ast.expr.EvaluateExeption;
import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.NumberExpr;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public class Pos extends NumberExpr {
    
    public Pos(final Expr expr, final int line) {
	super(expr, null, line);
    }

    @Override
    public final BigDecimal evalExpr(SymbolTable symbolTable) throws EvaluateExeption {
	return ((BigDecimal) lhs().evalExpr(symbolTable)).abs();
    }
    
    @Override
    public <T> void accept(BasicVisitor v, T context) {
	v.visit(this);
    }
   
}
