package org.uva.sea.ql.ast.expr;

public class BooleanConjunctiveExpr extends BooleanExpr {
    
    public static final int HASH_ORIGIN = 3;
    public static final int HASH_FACTOR = 29;
    
    private final Expr firstExpr;
    private final Expr secondExpr;
    
    public BooleanConjunctiveExpr(Expr theFirstExpr, Expr theSecondExpr) {
        assert theFirstExpr != null && theSecondExpr != null;
        firstExpr = theFirstExpr;
        secondExpr = theSecondExpr;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            BooleanConjunctiveExpr other = (BooleanConjunctiveExpr) o;
            return firstExpr.equals(other.firstExpr) && secondExpr.equals(other.secondExpr);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = HASH_ORIGIN;
        hash = HASH_FACTOR * hash + firstExpr.hashCode();
        hash = HASH_FACTOR * hash + secondExpr.hashCode();
        return hash;
    }
    
}
