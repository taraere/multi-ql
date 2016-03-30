package ql.ast.visitor;

import ql.ast.form.Form;
import ql.ast.statement.IfStatement;
import ql.ast.statement.question.ComputedQuestion;
import ql.ast.statement.question.InputQuestion;
import ql.gui.QLWindow;
import ql.gui.VisibleElements;

public class GuiVisitor<T> extends Evaluator {
	private VisibleElements visibleQuestions;
	private QLWindow parent;

	public GuiVisitor(Context context, QLWindow parent) {
		super(context);
		this.parent = parent;
		visibleQuestions = new VisibleElements();
	}

	@Override
	public T visit(ComputedQuestion computedQuestion) {
		context.putValueForQuestion(computedQuestion, computedQuestion.getExpression().accept(this));
		visibleQuestions.addQuestion(computedQuestion);
		return null;
	}

	@Override
	public T visit(InputQuestion inputQuestion) {
		inputQuestion.getVariable().accept(this);
		visibleQuestions.addQuestion(inputQuestion, parent);
		return null;
	}

	@Override
	public T visit(IfStatement ifStatement) {
		Boolean condition = (Boolean) ifStatement.getCondition().accept(this);
		if (condition == null) {
			return null;
		}
		if (condition) {
			ifStatement.getBody().accept(this);
		}
		return null;
	}

	public VisibleElements getVisibleQuestions(Form form, Context newContext) {
		this.context = newContext;
		this.visit(form);
		return visibleQuestions;
	}

	public void setNewContext(Context newContext) {
		context = newContext;
	}
}
