package org.uva.sea.ql.ast.visit;

public interface Visitable<U> {
	public void accept(Visitor visitor, U context);
}
