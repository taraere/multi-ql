package ql;

import ql.ast.form.Form;
import ql.ast.visitor.Context;
import ql.ast.visitor.CyclicDependencyChecker;
import ql.ast.visitor.FindAllDeclaredQuestions;
import ql.ast.visitor.TypeChecker;

public class SemanticAnalyser {
	private Context context;

	public SemanticAnalyser() {
		context = new Context();
	}

	public void analyseForm(Form form) {
		findVariables(form);
		typeCheck(form);
		cyclicDependenciesCheck(form);
	}

	public boolean noIssues() {
		return context.getIssues().isEmpty();
	}

	// Only for debugging
	public void printData() {
		System.out.println("Identifier - Type:");
		context.getIdentifierToTypeMap().forEach((k, t) -> System.out.println(String.format("%s: %s", k, t)));
		System.out.println();
	}

	private void findVariables(Form form) {
		FindAllDeclaredQuestions<Object> fadq = new FindAllDeclaredQuestions<>(context);
		fadq.visit(form);
		context = fadq.getContext();
	}

	private void typeCheck(Form form) {
		TypeChecker<Object> typeChecker = new TypeChecker<>(context);
		typeChecker.visit(form);
		context = typeChecker.getContext();
	}

	private void cyclicDependenciesCheck(Form form) {
		CyclicDependencyChecker<Object> cdc = new CyclicDependencyChecker<>(context);
		cdc.visit(form);
		cdc.findCyclicDependencies();
		context = cdc.getContext();
	}

	public Context getContext() {
		return context;
	}
}