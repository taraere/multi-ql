package eu.bankersen.kevin.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import eu.bankersen.kevin.ql.ast.stat.IFStat;
import eu.bankersen.kevin.ql.symboltable.SymbolTabel;

public class Block {

    private List<Question> questions;
    private List<IFStat> statements;

    public Block() {
	questions = new ArrayList<Question>();
	statements = new ArrayList<IFStat>();
    }
    
    public final void result() {
	
	visibility(true); // Inside a body meaning the above statement is true, show the questions.
	
	questions.forEach(question -> question.result());
	
	statements.forEach(statement -> statement.result());
    }

    public final void checkType() {

	questions.forEach(question -> question.checkType());
	
	statements.forEach(statement -> statement.checkType());
	
	visibility(false); // We can use the visibility modifier to determine depth.
    }
    
    public final void show() {
	visibility(true);
    }
    
    public final void hide() {
	visibility(false);
    }
    
    private void visibility(final Boolean vis) {
	questions.forEach(question -> SymbolTabel.setVisibility(question.getName(), vis));
    }

    @Override
    public final String toString() {

	StringBuilder sb;

	sb = new StringBuilder();
	for (Question q: questions) {
	    if (SymbolTabel.getVisibility(q.getName())){
	    sb.append(q.getText());
	    sb.append("\t: ");
	    sb.append(q.getType());
	    sb.append(" : ");
	    sb.append(q.getValue());
	    sb.append("\n");
	    }
	}

	for (IFStat s: statements) {
	    sb.append(s.toString() + "\n");
	}


	return sb.toString();
    }

    public final void add(final Question question) {
	questions.add(question);
    }

    public final void add(final IFStat statement) {
	statements.add(statement);
    }

    public final List<Question> getQuestions() {
	return questions;
    }

    public final List<IFStat> getStatements() {
	return statements;
    }
}
