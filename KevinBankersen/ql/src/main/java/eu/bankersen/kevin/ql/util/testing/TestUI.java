package eu.bankersen.kevin.ql.util.testing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

import eu.bankersen.kevin.ql.context.Symbol;
import eu.bankersen.kevin.ql.context.SymbolTable;

public class TestUI extends JFrame implements DataListener, ViewListener {
    private List<DataListener> listeners = new ArrayList<DataListener>();
    private List<ViewListener> ui = new ArrayList<ViewListener>();

    public TestUI(SymbolTable symbolTable) {

	JPanel mainpanel = new JPanel(new GridBagLayout());

	GridBagConstraints gbc = new GridBagConstraints();
	
	for (Entry<String, Symbol> entry : symbolTable.getEntries().entrySet()) {

	    String name = entry.getKey();
	    Symbol object = entry.getValue();
	    QuestionExample question = new QuestionExample(object);
	    
	    //Register listeners.
	    this.addDataListener(question);
	    question.addUIListener(this);
	   

	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.weightx = 1;
	    gbc.gridy++;
	    
	    mainpanel.add(question, gbc);
	}


	add(mainpanel);
	//Build the application
	setTitle("Simple Test");
	setSize(500, 800);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void dataUpdate(SymbolTable symbolTable) {
	listeners.forEach(listener -> listener.dataUpdate(symbolTable));
    }

    public void addDataListener(DataListener listener) {
	listeners.add(listener);
    }
    public void addViewListener(ViewListener listener) {
	ui.add(listener);
    }

    @Override
    public void viewUpdate(String name, Object value) {
	ui.forEach(listener -> listener.viewUpdate(name, value));
    }
}
