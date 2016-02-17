package eu.bankersen.kevin.ql.ast.form;

public class Form extends AbstractForm  {

    private String name;
    private Block body;

    public Form(final String name, final Block body) {
	this.name = name;
	this.body = body;
    }

    public final void checkType() {
	body.checkType();
    }

    public final void eval() {
	body.eval();
    }
    
    @Override
    public final String toString() {

	StringBuilder sb;

	sb = new StringBuilder();
	sb.append("\nForm: " + name + "\n");
	sb.append(body);
	sb.append("\n");

	return sb.toString();
    }
}
