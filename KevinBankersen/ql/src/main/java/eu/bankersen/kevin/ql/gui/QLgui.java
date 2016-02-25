package eu.bankersen.kevin.ql.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class QLgui extends JFrame {

    private String test2= "This is a cool test-message!";
    private JPanel panel;
    private JPanel bottomPanel;
    private Map<String, Component> components;

    public QLgui() {
	initUI();
    }

    private void initUI() {

	components = new HashMap<String,Component>();
	
	panel = new JPanel(new BorderLayout(20,20));
	panel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));

	GridBagConstraints gbc;

	// Header
	JLabel label = new JLabel("<html><p>Welcome to the Questionaire Language!</p></html>",JLabel.CENTER);
	label.setFont(new Font("Arial", Font.PLAIN, 24));
	label.setPreferredSize(new Dimension(400, 30));
	label.setName("header");



	panel.add(label, BorderLayout.NORTH);

	// Next and Back buttons
	bottomPanel = new JPanel(new BorderLayout());

	JButton next = new JButton("Next ->>");
	next.setName("next");
	
	JButton back = new JButton("<<- Back");
	back.setName("back");	
	
	ActionListener buttonClick = new ActionListener() {		
	    public void actionPerformed(ActionEvent actionEvent) {
		System.out.println("Click!");
		//QLgui.this.panel.removeAll();
		//QLgui.this.panel.remove(bottomPanel); //QLgui.this.components.get("header"));
		QLgui.this.panel.revalidate();
		QLgui.this.panel.repaint();
	    }
	};
	
	
	next.addActionListener(buttonClick);
	back.addActionListener(buttonClick);


	bottomPanel.add(next, BorderLayout.EAST);
	bottomPanel.add(back, BorderLayout.WEST);

	panel.add(bottomPanel, BorderLayout.SOUTH);



	// TRIAL WITH A BOOLEAN QUESTION
	JPanel center = new JPanel(new GridBagLayout());
	gbc = new GridBagConstraints();

	for (int i = 0; i < 8; i++) {
	    JPanel content = new JPanel(new BorderLayout());
	    JLabel question = new JLabel("<html><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut euismod nisl. Suspendisse et laoreet orci. Nam metus leo, venenatis vitae malesuada ac, blandit at.</p></html>");
	    question.setPreferredSize(new Dimension(300, 50));

	    content.add(question, BorderLayout.WEST);

	    JPanel bool = new JPanel();
	    ButtonGroup group = new ButtonGroup();
	    JRadioButton a = new JRadioButton("True");
	    JRadioButton b = new JRadioButton("False");

	    a.setName("var" + i);
	    b.setName("b" + i);

	    ActionListener sliceActionListener = new ActionListener() {		
		public void actionPerformed(ActionEvent actionEvent) {
		    AbstractButton aButton = (AbstractButton) actionEvent.getSource();
		    System.out.println("Selected: " + aButton.getText() + " " + QLgui.this.test2 + " " + aButton.getName());
		}
	    };

	    a.addActionListener(sliceActionListener);
	    b.addActionListener(sliceActionListener);
	    group.add(a);
	    group.add(b);
	    bool.add(a);
	    bool.add(b);


	    content.add(bool, BorderLayout.EAST);

	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.weightx = 1;
	    gbc.gridy++;

	    center.add(content, gbc);
	}

	// Try something with a number field.
	NumberFormat amountFormat = NumberFormat.getNumberInstance();

	JFormattedTextField txField = new JFormattedTextField(amountFormat);
	txField.setName("SomeDoubleField");
	txField.setColumns(10);
	txField.setValue(new Double(10.00));
	txField.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		JFormattedTextField field = (JFormattedTextField) e.getSource();
		System.out.println("Selected: " + field.getText() + " " + field.getName());	
	    }
	});

	//gbc.gridy++;
	//center.add(txField, gbc);
	
	txField.setVisible(false);

	// Try something with a text field.
	JFormattedTextField textField = new JFormattedTextField();
	textField.setName("SomeTextField");
	textField.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		JFormattedTextField field = (JFormattedTextField) e.getSource();
		System.out.println("Selected: " + field.getText() + " " + field.getName());	
	    }
	});

	//gbc.gridy++;
	//center.add(textField, gbc);

	// An empty JLabel to push the text up.
	gbc.gridy++;
	gbc.weighty = 1;
	center.add(new JLabel(),gbc);

	panel.add(center, BorderLayout.CENTER);
	
	// Now we should map all components to their name...
	Component[] comps = panel.getComponents();
	for (Component comp : comps) {
	    System.out.println(comp.getName());
	    components.put(comp.getName(), comp);
	}

	add(panel);
	
	pack();
	setTitle("Simple example");
	setSize(500, 700);
	//setResizable(false);
	setLocationRelativeTo(null);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
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

	UIManager.put("swing.boldMetal", Boolean.FALSE);

	EventQueue.invokeLater(new Runnable() {

	    @Override
	    public void run() {
		QLgui gui = new QLgui();
		gui.setVisible(true);

	    }
	});
    }

}
