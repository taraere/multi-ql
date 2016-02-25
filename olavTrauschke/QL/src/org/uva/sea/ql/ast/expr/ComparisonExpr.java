package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.checker.ASTVisitor;

/**
 * Representation of <code>Expr</code>s which compare two other <code>Expr</code>s
 * in some way in an AST.
 * 
 * @author Olav Trauschke
 * @version 25-feb-2016
 */
public abstract class ComparisonExpr extends BooleanExpr {
    
    /**
     * Start value used to calculate hashes for objects of this class.
     */
    public static final int HASH_ORIGIN = 7;
    
    /**
     * Factor partial hashes are multiplied by to generate a hash for objects of this class.
     */
    public static final int HASH_FACTOR = 83;
    
    private final Expr firstExpr;
    private final Expr secondExpr;
    
    /**
     * Constructor for objects of class <code>ComparisonExpr</code>.
     * 
     * @param theFirstExpr the <code>Expr</code> on the left hand side of the operator
     * @param theSecondExpr the <code>Expr</code> on the right hand side of the operator
     */
    public ComparisonExpr(Expr theFirstExpr, Expr theSecondExpr) {
        assert theFirstExpr != null && theSecondExpr != null;
        firstExpr = theFirstExpr;
        secondExpr = theSecondExpr;
    }
    
    /**
     * Has the <code>firstExpr</code> and the <code>secondExpr</code> of
     * <code>this ComparisonExpr accept v</code> and then has
     * <code>v visit this ComparisonExpr</code>.
     * 
     * @param v an <code>ASTVisitor</code> that should
     *          <code>visit this ComparisonExpr</code> and its children
     */
    @Override
    public void accept(ASTVisitor v) {
        firstExprAccept(v);
        secondExprAccept(v);
        
        v.visit(this);
    }
    
    /**
     * Has the <code>firstExpr</code> of <code>this Question accept v</code>.
     * 
     * @param v an <code>ASTVisitor</code> that the <code>firstExpr</code> of
     *          <code>this Question</code> should <code>accept</code>
     */
    protected void firstExprAccept(ASTVisitor v) {
        firstExpr.accept(v);
    }
    
    /**
     * Has the <code>secondExpr</code> of <code>this Question accept v</code>.
     * 
     * @param v an <code>ASTVisitor</code> that the <code>secondExpr</code> of
     *          <code>this Question</code> should <code>accept</code>
     */
    protected void secondExprAccept(ASTVisitor v) {
        secondExpr.accept(v);
    }
    
    /**
     * Compares <code>this ComparisonExpr</code> to another <code>Object</code>.
     * A <code>ComparisonExpr</code> is considered equal only to other objects
     * of the same class as <code>this ComparisonExpr</code>, for which
     * <code>theFirstExpr</code> and <code>theSecondExpr</code> are equal to its
     * own values for these field.
     * 
     * @param o the <code>Object</code> to compare to <code>this ComparisonExpr</code>
     * @return <code>true</code> if and only if o is equal to
     *          <code>this ComparisonExpr</code> 
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        
        ComparisonExpr other = (ComparisonExpr) o;
        return firstExpr.equals(other.firstExpr) && secondExpr.equals(other.secondExpr);
    }
    
    /**
     * @return an <code>int</code> containing a hash for <code>this ComparisonExpr</code>
     */
    @Override
    public int hashCode() {
        int hash = HASH_ORIGIN;
        hash = HASH_FACTOR * hash + firstExpr.hashCode();
        hash = HASH_FACTOR * hash + secondExpr.hashCode();
        return hash;
    }
}
