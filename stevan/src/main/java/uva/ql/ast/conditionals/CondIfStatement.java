package uva.ql.ast.conditionals;

import uva.ql.ast.Block;
import uva.ql.ast.abstracts.Type;
import uva.ql.ast.conditionals.abstracts.Condition;
import uva.ql.ast.conditionals.types.IfStatement;
import uva.ql.ast.expressions.abstracts.Expression;
import uva.ql.visitors.INodeVisitor;

public class CondIfStatement extends Condition {

	private Type type = new IfStatement();
	private Block lhs;
	
	public CondIfStatement(Expression expression, Block block, int startLine, int startColumn) {
		super(null, expression, startLine, startColumn);
		this.lhs = block;
	}
	
	@Override
	public Type getType() {
		return this.type;
	}
	
	public void setLhs(Block lhs) {
		this.lhs = lhs;
	}
	
	public Block getLhs() {
		return this.lhs;
	}

	@Override
	public void accept(INodeVisitor visitor) {
		visitor.visitIfCondition(this);
	}
}
