package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.stat.IFStat;

public class Block {
	private List<Question> questions;
	private List<IFStat> statements;

	public Block() {
		questions = new ArrayList<Question>();
		statements = new ArrayList<IFStat>();
	}

	public void add(Question question) {
		questions.add(question);
	}

	public void add(IFStat statement) {
		statements.add(statement);
	}

	public List<Question> getQuestions() {
		return questions;
	}

}