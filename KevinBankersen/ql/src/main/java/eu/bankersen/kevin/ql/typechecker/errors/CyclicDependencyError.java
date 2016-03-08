package eu.bankersen.kevin.ql.typechecker.errors;

import java.util.Set;

public class CyclicDependencyError extends TypeCheckError {
    
    public CyclicDependencyError(String variable, Set<String> dependencySet) {
	super(0, String.format("The variable \"%s\" has a cyclic dependency with %s!", variable, dependencySet));
    }
    
    public CyclicDependencyError(Set<String> variables, Set<String> dependencySet) {
	super(0, String.format("The expression \"if(%s)\" has a cyclic dependency with its own block %s!", variables, dependencySet));
    }

}
