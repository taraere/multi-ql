package eu.bankersen.kevin.ql.gui.dialog;

import java.util.List;

import javax.swing.JOptionPane;

import eu.bankersen.kevin.ql.typechecker.warnings.TypeCheckWarning;

public class WarningDialog {
    
    public WarningDialog(List<TypeCheckWarning> list) {
	StringBuilder sb = new StringBuilder();
	list.forEach(warning -> sb.append(warning + "\n"));
	showWarning(sb.toString());
    }
    
    private void showWarning(String message) {
	Object[] labels = {"Continue", "Abort"};
	int input = JOptionPane.showOptionDialog(
		    null,
		    message,
		    "Warnings Encountered",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.WARNING_MESSAGE,
		    null,
		    labels,
		    labels[0]);
	
	if (input == JOptionPane.NO_OPTION) {
	    System.exit(1);
	}
    }
}