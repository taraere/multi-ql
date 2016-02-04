package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.Result;
import org.uva.sea.ql.ast.VariableIdentifier;

public class Question extends ASTNode {

	private final VariableIdentifier variableIdentifier;
	private final String text;

	public Question(VariableIdentifier variableIdentifier, String text) {
		this.variableIdentifier = variableIdentifier;
		this.text = text;
	}

	public VariableIdentifier getVariableId() {
		return variableIdentifier;
	}

	public String getText() {
		return text;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Result validate() {
		return Result.TRUE();
	}
}
