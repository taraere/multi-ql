package ast.typechecker.errorhandler;

public class Warning {
	private String message;
	
	public Warning(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}