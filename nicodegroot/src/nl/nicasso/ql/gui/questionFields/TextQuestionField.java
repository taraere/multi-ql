package nl.nicasso.ql.gui.questionFields;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import nl.nicasso.ql.ast.nodes.expressions.Identifier;
import nl.nicasso.ql.gui.Observer;
import nl.nicasso.ql.gui.QuestionFieldParameter;
import nl.nicasso.ql.gui.evaluator.values.StringValue;
import nl.nicasso.ql.gui.widgets.Label;

public class TextQuestionField extends QuestionField {

	private Identifier identifier;
	private JTextField field;
	private Label label;
	private Observer main;

	public TextQuestionField(QuestionFieldParameter params) {
		this.identifier = params.getIdentifier();
		this.main = params.getMain();
		
		setupField(params.isEnabled());
	}
	
	private void setupField(boolean enabled) {
		field = new JTextField();
		field.setColumns(20);
		field.setEnabled(enabled);
		
		addListenerToField();
	}
	
	private void addListenerToField() {
		field.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				StringValue value = new StringValue(field.getText());
				main.fieldValueChanged(identifier, value);
				main.updateAllPanels();
			}
			
		});
	}
	
	public void setValue(Object value) {
		field.setText((String) value);
	}
	
	public boolean equalValues(Object value) {
		//System.out.println(value+" - "+field.getText() + " EQUALS? "+ value.equals((field.getText())));
		return value.equals(field.getText());
	}
	
	public void setFeedbackLabel(Label label) {
		this.label = label;
	}
	
	public JTextField getField() {
		return this.field;
	}
	
}
