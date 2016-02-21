package uva.ql.ast;

import uva.ql.interfaces.IExpression;
import uva.ql.interfaces.INode;

public abstract class AVariable extends AExpression {

	private int varType = 0;
	private String name = "";
	
	protected AVariable(AST ast) {
		super(ast);
		
		setVarType(getVarType0());
	}

	protected abstract int getVarType0();
	
	
	public final int getVarType() {
		return this.varType;
	}
	
	private void setVarType(int varType) {
		this.varType = varType;	
	}

	@Override
	protected int getNodeType0() {
		return INode.EXPRESSION;
	}
	
	@Override
	protected int getExprType0() {
		return IExpression.VARIABLE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
