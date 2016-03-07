package eu.bankersen.kevin.ql.gui.widgets;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eu.bankersen.kevin.ql.gui.ViewListener;
import eu.bankersen.kevin.ql.typechecker.symboltable.Symbol;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public class QuestionWidget implements Widget {

    private final String name;
    private final JPanel questionContainer;
    private final Widget questionInput;
    private final List<ViewListener> viewListeners;
    private final List<Widget> widgetListeners;

    public QuestionWidget(Symbol data) {

	viewListeners = new ArrayList<>();
	widgetListeners = new ArrayList<>();
	name = data.getName();

	questionContainer = new JPanel(new BorderLayout());
	questionContainer.setVisible(data.getActive());

	String questionString = data.getQuestion();
	JLabel questionText = new JLabel("<html><p>" + questionString + "</p></html>");
	int rows = (questionString.length() / 40);
	questionText.setPreferredSize(new Dimension(290, rows * 20));

	questionContainer.add(questionText, BorderLayout.WEST);


	if (data.getType().isBoolean()) {
	    questionInput = new RadioButtonWidget(data);
	} else {
	    questionInput = new BoxWidget(data);
	}

	questionInput.addWidgetListener(this);
	questionContainer.add(questionInput.build(), BorderLayout.EAST);
    }

    @Override
    public JPanel build() {
	return questionContainer;
    }

    @Override
    public void dataUpdate(SymbolTable symbolTable) {
	questionContainer.setVisible(symbolTable.getSymbol(name).getActive());
	questionInput.dataUpdate(symbolTable);

	// Update the view.
	QuestionWidget.this.questionContainer.revalidate();
	QuestionWidget.this.questionContainer.repaint();
    }

    @Override
    public void widgetUpdate(Object value) {
	viewListeners.forEach(l -> l.viewUpdate(name, value));	
    }

    public void addUIListener(ViewListener listener) {
	viewListeners.add(listener);
    }

    @Override
    public void addWidgetListener(Widget listener) {
	widgetListeners.add(listener);
    }

}
