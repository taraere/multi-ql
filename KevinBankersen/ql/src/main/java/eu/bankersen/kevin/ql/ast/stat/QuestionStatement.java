package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.Variable;

public class QuestionStatement extends Question {

    public QuestionStatement(Variable variable, String text) {
	super(false, variable, text);
    }
    
    

}
