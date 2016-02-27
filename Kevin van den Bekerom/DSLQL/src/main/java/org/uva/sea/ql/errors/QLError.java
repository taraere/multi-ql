package org.uva.sea.ql.errors;

import org.uva.sea.ql.ast.ASTNode;

public class QLError extends AbstractQLError{

	public QLError(ASTNode source, String message) {
		super.source = source;
		super.message = message;
	}
	
	public String getErrorMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ERROR on line ")
		.append(source.getStartLine())
		.append("] source: ")
		.append(source.toString())
		.append(". ")
		.append(message);
		return sb.toString();
	}
}	
