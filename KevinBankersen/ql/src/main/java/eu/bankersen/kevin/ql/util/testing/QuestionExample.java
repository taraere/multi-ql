package eu.bankersen.kevin.ql.util.testing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.esotericsoftware.minlog.Log;

import eu.bankersen.kevin.ql.ast.Type;
import eu.bankersen.kevin.ql.context.Symbol;
import eu.bankersen.kevin.ql.context.SymbolTable;

public class QuestionExample extends JPanel implements DataListener {

    private final JPanel mainPanel;
    private final JLabel label;
    private final JFormattedTextField txField;
    private final String panelName;
    private final Type type;
    private final JLabel name;
    
    private List<ViewListener> ui = new ArrayList<ViewListener>();


    public QuestionExample(Symbol object) {
	this.panelName = object.getName();
	this.type = object.getType();
	Boolean visible = object.getActive();
	
	mainPanel = new JPanel(new BorderLayout());

	name = new JLabel(object.getQuestion());
	name.setVisible(visible);
	
	mainPanel.add(name, BorderLayout.NORTH);

	txField = new JFormattedTextField();
	txField.setVisible(visible);

	txField.addKeyListener(new KeyListener() {

	    @Override
	    public void keyTyped(KeyEvent e) {


	    }

	    @Override
	    public void keyReleased(KeyEvent e) {

		JFormattedTextField field = (JFormattedTextField) e.getSource();

		if (field.getText().equals("")) {
		    viewUpdate("Empty");
		} else {
		    viewUpdate(returnData(field.getText()));
		}
		QuestionExample.this.mainPanel.revalidate();
		QuestionExample.this.mainPanel.repaint();

	    }

	    @Override
	    public void keyPressed(KeyEvent e) {


	    }
	});

	txField.setPreferredSize(new Dimension(200, 30));
	mainPanel.add(txField, BorderLayout.CENTER);

	label = new JLabel("Test");
	label.setVisible(visible);

	mainPanel.add(label, BorderLayout.SOUTH);
	add(mainPanel);
    }

    public void addUIListener(ViewListener toAdd) {
	ui.add(toAdd);
    }

    @Override
    public void dataUpdate(SymbolTable symbolTable) {
	Symbol data = symbolTable.getSymbol(panelName);
	label.setText(String.valueOf(data.getValue()));
	name.setVisible(data.getActive());
	label.setVisible(data.getActive());
	txField.setVisible(data.getActive());
	
	// Update the view.
	QuestionExample.this.mainPanel.revalidate();
	QuestionExample.this.mainPanel.repaint();
    }

    private void viewUpdate(Object value) {
	ui.forEach(l -> l.viewUpdate(panelName, value));
    }

    private Object returnData(String data) {

	switch(type){
	case BOOLEAN : return data.equals("true") || data.equals("false") ? Boolean.valueOf(data) : Type.EMPTY;
	case INTEGER : return Integer.valueOf(data);
	default : return data;
	}
    }

}
