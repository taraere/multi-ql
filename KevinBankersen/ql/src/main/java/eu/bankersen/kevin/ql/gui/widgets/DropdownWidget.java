package eu.bankersen.kevin.ql.gui.widgets;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.typechecker.symboltable.Symbol;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public class DropdownWidget implements Widget {

    private final String name;
    private final JPanel panel;
    private final Type type;
    private final JComboBox  inputField;
    private final List<Widget> widgetListeners;

    DropdownWidget(Symbol data) {
	this.name = data.getName();
	this.type = data.getType();
	this.panel = new JPanel();
	widgetListeners = new ArrayList<>();

	String[] params = {"True", "False"}; 
	inputField = new JComboBox(params);
	inputField.setSelectedIndex(-1);
	inputField.setPreferredSize(new Dimension(120, 20));
	inputField.addActionListener(new ComboListener());
	inputField.setEditable(!data.isComputed());

	panel.add(inputField);
    }

    @Override
    public JPanel build() {
	return panel;
    }

    @Override
    public void dataUpdate(SymbolTable symbolTable) {
	Symbol data = symbolTable.getSymbol(name);

	if (data.getValue() != null) {
	    if (data.getValue().toString().equalsIgnoreCase("true")) {
		inputField.setSelectedIndex(0);
	    } else if (data.getValue().toString().equalsIgnoreCase("false")) {
		inputField.setSelectedIndex(1);
	    }
	    // Update the view.
	    DropdownWidget.this.panel.revalidate();
	    DropdownWidget.this.panel.repaint();
	}
    }

    @Override
    public void widgetUpdate(Object value) {
	widgetListeners.forEach(l -> l.widgetUpdate(value));
    }

    @Override
    public void addWidgetListener(Widget listener) {
	widgetListeners.add(listener);

    }
    class ComboListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    JComboBox cb = (JComboBox) e.getSource();
	    widgetUpdate(type.parseValue(cb.getSelectedItem().toString()));
	}
    }
}