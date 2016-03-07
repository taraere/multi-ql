package eu.bankersen.kevin.ql.ast.type.value;

public interface QLOperations {
    
    // Math operations
    QLObject subtract(QLObject o);
    
    QLObject add(QLObject o);
    
    QLObject divide(QLObject o);
    
    QLObject multiply(QLObject o);
    
    QLObject absolute();
    
    QLObject negate();
    
    // Boolean operations

    QLObject or(QLObject o);
    
    QLObject and(QLObject o);
    
    QLObject equal(QLObject o);
    
    QLObject greaterOrEqual(QLObject o);
    
    QLObject greater(QLObject o);
    
    QLObject lowerOrEqual(QLObject o);
    
    QLObject lower(QLObject o);
    
    QLObject notEqual(QLObject o);

    QLObject not();

}
