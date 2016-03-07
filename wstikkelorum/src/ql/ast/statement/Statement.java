package ql.ast.statement;

import ql.ast.TreeNode;
import ql.ast.visitor.Visitable;
import ql.ast.visitor.Visitor;

public class Statement extends TreeNode implements Visitable {
	private Question question;
	private IfStatement ifStatement;

	public Statement(Question result) {
		super(result.getLineNumber());
		this.question = result;
	}

	public Statement(IfStatement result) {
		super(result.getLineNumber());
		this.ifStatement = result;
	}

	public Question getQuestion() {
		return question;
	}

	public IfStatement getIfStatement() {
		return ifStatement;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}