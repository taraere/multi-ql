package sc.ql.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import sc.ql.Environment;
import sc.ql.Environment.ContextListener;
import sc.ql.Interpreter;
import sc.ql.ast.Expression;
import sc.ql.ast.Expression.And;
import sc.ql.ast.Expression.BooleanLiteral;
import sc.ql.ast.Form;
import sc.ql.ast.Statement.ComputedQuestion;
import sc.ql.ast.Statement.IfThen;
import sc.ql.ast.Statement.NormalQuestion;
import sc.ql.ast.Statement.Question;
import sc.ql.ast.TopDown;
import sc.ql.ast.ValueType.BooleanType;
import sc.ql.ast.ValueType.IntegerType;
import sc.ql.ast.ValueType.StringType;
import sc.ql.ast.ValueTypeVisitor;
import sc.ql.ast.value.BooleanValue;
import sc.ql.ast.value.NumberValue;
import sc.ql.ast.value.StringValue;
import sc.ql.ui.widget.LabelWidget;
import sc.ql.ui.widget.RadioButtonWidget;
import sc.ql.ui.widget.TextFieldWidget;

public class UIFactory {

	private static UIFactory customFactory;

	public static synchronized void set(UIFactory factory) {
		customFactory = factory;
	}

	public static synchronized UIFactory get() {
		if (customFactory != null) {
			return customFactory;
		}

		return new UIFactory();
	}

	public UIQuestionnaire create(Form form) {
		Environment context;
		UIForm uiForm;

		context = new Environment();

		uiForm = createForm();

		form.accept(new TopDown<Void, Expression>() {

			@Override
			public Void visit(IfThen node, Expression condition) {
				Expression conjunction;

				conjunction = new And(condition, node.getCondition());

				node.getBody().accept(this, conjunction);

				return null;
			}

			@Override
			public Void visit(NormalQuestion node, Expression condition) {
				UIQuestion uiQuestion;

				uiQuestion = create(context, node, condition);
				uiForm.addQuestion(uiQuestion);
				return null;
			}

			@Override
			public Void visit(ComputedQuestion node, Expression condition) {
				UIQuestion uiQuestion;

				uiQuestion = create(context, node, condition, node.getComputation());
				uiForm.addQuestion(uiQuestion);
				return null;
			}

		}, BooleanLiteral.TRUE);

		return new DefaultUIQuestionnaire(uiForm);
	}

	protected UIForm createForm() {
		return new DefaultUIForm();
	}

	private UIQuestion create(Environment context, Question question, Expression condition) {
		return create(context, question, condition, null);
	}

	private UIQuestion create(Environment context, Question question, Expression condition,
			Expression valueComputation) {
		UIWidget labelWidget;
		UIWidget valueWidget;

		labelWidget = createLabelWidget(question);
		valueWidget = createValueWidget(question, context);

		return new DefaultUIQuestion(context, question, labelWidget, valueWidget, condition, valueComputation);
	}

	protected UIWidget createLabelWidget(Question question) {
		return new LabelWidget(question.getLabel());
	}

	protected UIWidget createValueWidget(Question question, Environment context) {
		return question.getType().accept(new ValueTypeVisitor<UIWidget, Void>() {

			@Override
			public UIWidget visit(BooleanType type, Void unused) {
				final UIWidgetChoice YES;
				final UIWidgetChoice NO;
				UIWidgetChoices choices;

				YES = new UIWidgetChoice("Yes", BooleanValue.TRUE);
				NO = new UIWidgetChoice("No", BooleanValue.FALSE);

				choices = new UIWidgetChoices(Arrays.asList(YES, NO), NO);

				return new RadioButtonWidget(context, question.getId(), choices);
			}

			@Override
			public UIWidget visit(StringType type, Void unused) {
				return new TextFieldWidget(context, question, new StringValue(""));
			}

			@Override
			public UIWidget visit(IntegerType type, Void unused) {
				return new TextFieldWidget(context, question, new NumberValue(0));
			}
		}, null);
	}

	private static class DefaultUIQuestionnaire implements UIQuestionnaire {

		private final JFrame jframe;
		private final JScrollPane scrollPanel;

		public DefaultUIQuestionnaire(UIForm form) {
			JPanel panel;
			JPanel root;

			jframe = new JFrame();
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			scrollPanel = new JScrollPane();
			scrollPanel.setViewportView(form.getComponent());
			scrollPanel.setBorder(null);

			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(scrollPanel);

			root = new JPanel();
			root.setLayout(new BoxLayout(root, BoxLayout.X_AXIS));

			root.add(Box.createGlue());
			root.add(panel);
			root.add(Box.createGlue());

			jframe.setContentPane(root);
			jframe.setSize(400, 600);
			jframe.setLocationRelativeTo(null);
		}

		@Override
		public void show() {
			jframe.setVisible(true);
		}
	}

	private static class DefaultUIForm implements UIForm {

		private final List<UIQuestion> questions = new ArrayList<>();
		private final JPanel panel;

		public DefaultUIForm() {
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		}

		@Override
		public void addQuestion(UIQuestion question) {
			JPanel qPanel;

			questions.add(question);

			qPanel = new JPanel(new BorderLayout());
			qPanel.add(question.getLabelWidget().getComponent(), BorderLayout.CENTER);
			qPanel.add(question.getValueWidget().getComponent(), BorderLayout.EAST);
			qPanel.setMaximumSize(new Dimension(400, 40));
			qPanel.setMinimumSize(new Dimension(200, 40));

			panel.add(qPanel);
			panel.add(Box.createRigidArea(new Dimension(0, 2)));
		}

		@Override
		public JComponent getComponent() {
			return panel;
		}
	}

	private static class DefaultUIQuestion implements UIQuestion, ContextListener {

		private final Question question;
		private final Expression condition;
		private final Expression valueComputation;

		private final UIWidget labelWidget;
		private final UIWidget valueWidget;

		public DefaultUIQuestion(Environment context, Question question, UIWidget labelWidget, UIWidget valueWidget,
				Expression condition, Expression valueComputation) {
			this.question = question;
			this.condition = condition;

			this.labelWidget = labelWidget;
			this.valueWidget = valueWidget;
			this.valueComputation = valueComputation;

			if (valueComputation != null) {
				this.valueWidget.setEditable(false);
				context.addComputedValue(question.getId(), valueComputation);
			}

			context.addContextListener(this);

			setVisible(isEnabled(context));
		}

		@Override
		public String getId() {
			return question.getId();
		}

		public boolean isEnabled(Environment context) {
			return Interpreter.interpret(condition, context).equals(BooleanValue.TRUE);
		}

		@Override
		public void contextChanged(Environment context) {
			setVisible(isEnabled(context));

			if (valueComputation != null) {
				valueWidget.setValue(context.getValue(question.getId()));
			}
		}

		private void setVisible(boolean visible) {
			SwingUtilities.invokeLater(() -> {
				labelWidget.setVisible(visible);
				valueWidget.setVisible(visible);
			});
		}

		@Override
		public UIWidget getLabelWidget() {
			return labelWidget;
		}

		@Override
		public UIWidget getValueWidget() {
			return valueWidget;
		}
	}
}