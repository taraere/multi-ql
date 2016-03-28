package org.uva.sea.ql.gui.widget;

import javax.swing.JTextField;

public class QLQuestionTextFeild extends Widget {

	/**
	 * 
	 */
	private static final long serialVersionUID = -797635111479794335L;
	private JTextField qlQuestionTextFeild;

	public QLQuestionTextFeild(String variable, String money) {
		qlQuestionTextFeild = new JTextField(5);
		qlQuestionTextFeild.setName(variable);
		qlQuestionTextFeild.setText(money);
	}

	public void setQlQuestionTextFeild(JTextField qlQuestionTextFeild) {
		this.qlQuestionTextFeild = qlQuestionTextFeild;
	}

	@Override
	public JTextField getQlComponent() {
		return qlQuestionTextFeild;
	}

}