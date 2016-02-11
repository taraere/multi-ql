package org.uva.ql.ast.form;

import org.uva.ql.ast.ASTNode;
import org.uva.ql.ast.ASTNodeVisitor;

public class Form extends ASTNode {

	private String name;
	private Block body;

	public Form(String id, Block body) {
		this.name = id;
		this.body = body;
	}

	public Block getBody() {
		return body;
	}

	public String getName() {
		return name;
	}

	@Override
	public <T, U> T accept(ASTNodeVisitor<T, U> visitor, U context) {
		return visitor.visit(this, context);
	}
}
