package nl.nicasso.ql.ast.structure;

import java.util.List;

import nl.nicasso.ql.ast.ASTNode;
import nl.nicasso.ql.ast.Traversable;
import nl.nicasso.ql.ast.Visitor;
import nl.nicasso.ql.ast.statement.Statement;

public class Block extends ASTNode implements Traversable {

	private final List<Statement> statements;

	public Block(List<Statement> statements) {
		this.statements = statements;
	}

	public List<Statement> getStatements() {
		return statements;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
