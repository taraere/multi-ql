package ast.visitor;

public interface Visitable {
	public Object accept(Visitor visitor);

}
