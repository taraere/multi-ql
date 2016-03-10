package nl.nicasso.ql.gui.panels;

import javax.swing.JPanel;

import nl.nicasso.ql.gui.widgets.Button;

public class ControlPanel extends Panel {
		
	private JPanel panel;

	public ControlPanel() {
		panel = new JPanel();
		
		addButton("Reset");
	}
	
	public void addButton(String label) {
		Button submit = new Button(label); 
		panel.add(submit.getWidget());
	}
	
	@Override
	public JPanel getPanel() {
		return this.panel;
	}
	
}