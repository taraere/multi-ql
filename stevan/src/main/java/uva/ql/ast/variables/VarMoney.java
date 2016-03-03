package uva.ql.ast.variables;

import uva.ql.ast.abstracts.Node;
import uva.ql.ast.abstracts.Type;
import uva.ql.ast.variables.abstracts.Variable;
import uva.ql.ast.variables.types.Money;

public class VarMoney extends Variable {

	private Type type = new Money();
	
	public VarMoney(Node parent, String name, int startLine, int startColumn) {
		super(parent, name, startLine, startColumn);
	}
	
	public Type getType() {
		return this.type;
	}
}
