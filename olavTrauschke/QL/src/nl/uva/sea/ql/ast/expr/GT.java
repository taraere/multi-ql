package nl.uva.sea.ql.ast.expr;

import nl.uva.sea.ql.answerTable.*;

/**
 * Representation of "greater than" comparisons in an AST.
 * 
 * @author Olav Trauschke
 * @version 26-mar-2016
 */
public class GT extends OrderedComparisonExpr {
    
    /**
     * Constructor for objects of class <code>GT</code>.
     * 
     * @param firstExpr the <code>Expr</code> on the left hand side of the operator
     * @param secondExpr the <code>Expr</code> on the right hand side of the operator
     */
    public GT(Expr firstExpr, Expr secondExpr) {
        super(firstExpr, secondExpr);
    }
    
    /**
     * Evaluate <code>this GT</code>.
     * 
     * @param answerTable an <code>AnswerTable</code> mapping all <code>Ident</code>s
     *                      that might appear in <code>Expr</code>s in
     *                      <code>this GT</code> to the <code>Value</code> of
     *                      the <code>Question</code> they represent
     * @return a <code>BooleanValue</code> representing the result of checking
     *          whether <code>this GT</code>'s <code>firstExpr</code> is greater
     *          than its <code>secondExpr</code>
     */
    @Override
    public BooleanValue eval(AnswerTable answerTable) {
        NumericValue firstValue = NumericValue.cast(getFirstExpr().eval(answerTable));
        NumericValue secondValue = NumericValue.cast(getSecondExpr().eval(answerTable));
        return firstValue.ternaryGreaterThan(secondValue);
    }
    
}
