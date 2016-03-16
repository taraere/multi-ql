package ql.ast.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ql.ast.literal.Variable;
import ql.ast.literal.VariableExpression;
import ql.ast.statement.Question;
import ql.issue.DuplicateLabel;
import ql.issue.DuplicateQuestionWithDifferentType;
import ql.issue.Issue;
import ql.issue.ReferenceToUndefinedQuestion;

public class Context {
	private List<Question> declaredQuestions;
	private List<String> labels;
	private HashMap<String, Type> nameToType;
	private HashMap<String, Object> nameToValue;
	private List<Issue> issues;

	public Context() {
		declaredQuestions = new ArrayList<Question>();
		labels = new ArrayList<String>();
		nameToType = new HashMap<String, Type>();
		nameToValue = new HashMap<String, Object>();
		issues = new ArrayList<Issue>();
	}

	public void putValueForQuestion(Question question, Object value) {
		nameToValue.put(question.getVariable().getIdentifier(), value);
	}

	public Object getValueForVariable(VariableExpression variableExpression) {
		return getValue(variableExpression.getIdentifier(), variableExpression.getLineNumber());
	}

	public Object getValueForVariable(Variable variable) {
		return getValue(variable.getIdentifier(), variable.getLineNumber());
	}

	private Object getValue(String identifier, int lineNumber) {
		if (!nameToValue.containsKey(identifier)) {
			issues.add(new ReferenceToUndefinedQuestion(identifier, lineNumber));
			return null;
		}
		return nameToValue.get(identifier);
	}

	public void addQuestion(Question question) {
		String identifier = question.getVariable().getIdentifier();
		Type type = question.getVariable().getType();

		if (nameToType.containsKey(identifier) && nameToType.get(identifier) != type) {
			issues.add(new DuplicateQuestionWithDifferentType(question));
			return;
		}

		declaredQuestions.add(question);
		nameToType.put(identifier, type);
		nameToValue.put(identifier, null);
		addLabel(question);
	}

	private void addLabel(Question question) {
		String label = question.getQuestionString();
		if (!labels.contains(label)) {
			labels.add(question.getQuestionString());
		} else {
			issues.add(new DuplicateLabel(label, question.getLineNumber()));
		}
	}

	public Type getType(String identifier, int lineNumber) {
		if (!nameToType.containsKey(identifier)) {
			issues.add(new ReferenceToUndefinedQuestion(identifier, lineNumber));
			return null;
		}
		return nameToType.get(identifier);
	}

	public void addIssue(Issue issue) {
		issues.add(issue);
	}

	public List<Question> getDeclaredQuestions() {
		return declaredQuestions;
	}

	public HashMap<String, Type> getIdentifierToTypeMap() {
		return nameToType;
	}

	public HashMap<String, Object> getIdentifierToValueMap() {
		return nameToValue;
	}

	public List<Issue> getIssues() {
		return issues;
	}
}