package uva.ql.ast.variables;

import uva.ql.ast.EnumType;
import uva.ql.ast.abstracts.Node;
import uva.ql.ast.variables.abstracts.Variable;
import uva.ql.ast.variables.types.Generic;
import uva.ql.typechecker.visitors.ICyclicDependencyVisitor;
import uva.ql.typechecker.visitors.IUndefinedQuestionVisitor;

public class VarGeneric extends Variable {

	private Generic type = new Generic();
	
	public VarGeneric(Node parent, String name, int startLine, int startColumn) {
		super(parent, name, startLine, startColumn);
	}
	
	@Override
	public EnumType evalType() {
		return this.getType();
	}
	
	@Override
	public EnumType getType() {
		return this.type.getType();
	}

	@Override
	public void accept(IUndefinedQuestionVisitor visitor) {
		visitor.visitVarGeneric(this);
	}
	
	@Override
	public void accept(ICyclicDependencyVisitor visitor) {
		visitor.visitVarGeneric(this);
	}
}