package eu.bankersen.kevin.ql.gui.widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.typechecker.symboltable.Symbol;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public class RadioButtonWidget implements Widget {

    private final String name;
    private final JPanel panel;
    private final Type type;
    private final JRadioButton trueToggle;
    private final JRadioButton falseToggle;
    private final List<Widget> widgetListeners;
    private final ButtonGroup group;

    public RadioButtonWidget(Symbol data) {
	this.name = data.getName();
	this.type = data.getType();
	this.panel = new JPanel();
	widgetListeners = new ArrayList<>();

	trueToggle = new JRadioButton("True");
	trueToggle.setEnabled(!data.isComputed());
	falseToggle = new JRadioButton("False");
	falseToggle.setEnabled(!data.isComputed());
	
	group = new ButtonGroup();
	group.add(trueToggle);
	group.add(falseToggle);

	ActionListener toggleListerner =  new ActionListener() {	
	    public void actionPerformed(ActionEvent actionEvent) {
		AbstractButton aButton = (AbstractButton) actionEvent.getSource();
		widgetUpdate(type.parseValue(aButton.getText()));
	    }
	};

	trueToggle.addActionListener(toggleListerner);
	falseToggle.addActionListener(toggleListerner);

	panel.add(trueToggle);
	panel.add(falseToggle);
    }

    @Override
    public JPanel build() {
	return panel;
    }

    @Override
    public void dataUpdate(SymbolTable symbolTable) {
	Symbol data = symbolTable.getSymbol(name);

	if (data.getValue() != null) {
	    if (data.getValue().equals(true)) {
		trueToggle.setSelected(true);
	    } else if (data.getValue().equals(false)) {
		falseToggle.setSelected(true);
	    }
	} else {
	    group.clearSelection();
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
}
