package nl.nicasso.ql.gui.questionFields;

import java.awt.Component;

public abstract class QuestionField {
	
	public QuestionField() {
		//throw new AssertionError("QuestionField");
	}
	
	public void setValue(Object value) {
		//throw new AssertionError("QuestionField setValue");
	}
	
	public Component getField() {
		throw new AssertionError("QuestionField getField");
	}
	
}
