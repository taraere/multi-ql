package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.Visitable;
import org.uva.sea.ql.ast.Visitor;

public class ElseStatement extends Stat implements Visitable {
	private Block block;
	
	public ElseStatement(Block block) {
		this.block = block;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public Block getBlock() {
		return block;
	}
	
	@Override
	public String toString() {
		return "ElseStatement";
	}
}
