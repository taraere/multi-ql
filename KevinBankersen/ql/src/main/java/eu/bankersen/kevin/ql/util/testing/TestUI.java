package eu.bankersen.kevin.ql.util.testing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import eu.bankersen.kevin.ql.context.Symbol;
import eu.bankersen.kevin.ql.context.SymbolTable;
import eu.bankersen.kevin.ql.interpreter.DataListener;
import eu.bankersen.kevin.ql.util.testing.widgets.QuestionWidget;

public class TestUI extends JFrame implements DataListener, ViewListener {
    private List<DataListener> listeners = new ArrayList<DataListener>();
    private List<ViewListener> ui = new ArrayList<ViewListener>();

    public TestUI(SymbolTable symbolTable) {

	// The main panel for the UI.
	JPanel mainpanel = new JPanel(new BorderLayout(20, 20));
	mainpanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

	// The header of the Application.
	String title = "Welcome to the Questionaire Language!";
	JLabel label = new JLabel("<html><p>" + title + "</p></html>", JLabel.CENTER);
	label.setFont(new Font("Arial", Font.PLAIN, 24));
	label.setPreferredSize(new Dimension(400, 30));
	mainpanel.add(label, BorderLayout.NORTH);


	// The center panel containing the questions.
	JPanel centerpanel = new JPanel(new GridBagLayout());
	centerpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

	GridBagConstraints gbc = new GridBagConstraints();
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.weightx = 1;
	for (Symbol object : symbolTable.getEntries().values()) {

	    QuestionWidget question = new QuestionWidget(object);

	    //Register listeners.
	    this.addDataListener(question);
	    question.addUIListener(this);
	    
	    gbc.gridy++;
	    centerpanel.add(question.build(), gbc);
	}
	// Lets push everything to the top
	gbc.weighty = 1;
	gbc.gridy++;
	centerpanel.add(new JLabel(), gbc);

	mainpanel.add(centerpanel, BorderLayout.CENTER);

	// The footer of the Application
	JPanel bottomPanel = new JPanel(new BorderLayout());

	JButton next = new JButton("Next ->>");
	next.setName("next");

	JButton back = new JButton("<<- Back");
	back.setName("back");	

	bottomPanel.add(next, BorderLayout.EAST);
	bottomPanel.add(back, BorderLayout.WEST);

	mainpanel.add(bottomPanel, BorderLayout.SOUTH);
	
	try {
	    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	} catch (UnsupportedLookAndFeelException ex) {
	    ex.printStackTrace();
	} catch (IllegalAccessException ex) {
	    ex.printStackTrace();
	} catch (InstantiationException ex) {
	    ex.printStackTrace();
	} catch (ClassNotFoundException ex) {
	    ex.printStackTrace();
	}
	

	//Build the application
	add(mainpanel);
	pack();
	setTitle("Questionnaire Language");
	setSize(500, 500);
	setLocationRelativeTo(null);
	setResizable(false);
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