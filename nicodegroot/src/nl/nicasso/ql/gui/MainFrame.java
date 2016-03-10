package nl.nicasso.ql.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;
import nl.nicasso.ql.gui.panels.ComputedQuestionPanel;
import nl.nicasso.ql.gui.panels.Panel;

public class MainFrame implements Observer {

	private List<Panel> panels;
	private JFrame mainFrame;
	
	public MainFrame() {
		panels = new ArrayList<Panel>();
		
		mainFrame = new JFrame("Questionnaire");
		mainFrame.setSize(800, 600);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(new MigLayout());
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void setVisible(boolean visible) {
		mainFrame.setVisible(visible);
	}
	
	public void addPanel(Panel panel) {
		panels.add(panel);
	}
	
	public void addPanelsToMainFrame() {
		for (Panel p : panels) {
			mainFrame.add(p.getPanel(), "wrap");
		}
		
		setVisible(true);
	}

	@Override
	public void updatePanel() {
		for (Panel p : panels) {
			// I dont want to use instanceof :(
			if (p instanceof ComputedQuestionPanel) {
				ComputedQuestionPanel k = (ComputedQuestionPanel) p;
				k.updatePanel();
			}
		}
	}

}