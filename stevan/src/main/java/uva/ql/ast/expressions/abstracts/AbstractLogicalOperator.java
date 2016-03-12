package uva.ql.ast.expressions.abstracts;

import uva.ql.ast.abstracts.Node;
import uva.ql.visitors.interfaces.typechecker.IBinaryOperatorVisitor;
import uva.ql.visitors.interfaces.typechecker.ICyclicDependencyVisitor;
import uva.ql.visitors.interfaces.typechecker.IDupllicateLabelsVisitor;
import uva.ql.visitors.interfaces.typechecker.IDupllicateQuestionDifferentTypesVisitor;
import uva.ql.visitors.interfaces.typechecker.IUndefinedQuestionVisitor;

public abstract class AbstractLogicalOperator extends Expression {

	private Expression lhs, rhs;
	
	public AbstractLogicalOperator(Node parent, int startLine, int startColumn, Expression lhs, Expression rhs) {
		
		super(parent, startLine, startColumn);
		
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getLhs() {
		
		return this.lhs;
	}
	
	public Expression getRhs() {
		
		return this.rhs;
	}

	@Override
	public void accept(IUndefinedQuestionVisitor visitor) {
		visitor.visitLogicalOperator(this);
	}
	
	@Override
	public void accept(ICyclicDependencyVisitor visitor) {
		visitor.visitLogicalOperator(this);
	}
	
	@Override
	public void accept(IDupllicateLabelsVisitor visitor) {
		visitor.visitLogicalOperator(this);
	}

	@Override
	public void accept(IDupllicateQuestionDifferentTypesVisitor visitor) {
		visitor.visitLogicalOperator(this);
	}

	@Override
	public void accept(IBinaryOperatorVisitor visitor) {
		visitor.visitLogicalOperator(this);
	}
}
