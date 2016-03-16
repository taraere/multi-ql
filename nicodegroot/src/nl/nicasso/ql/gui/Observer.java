package nl.nicasso.ql.gui;

import nl.nicasso.ql.ast.nodes.expressions.Identifier;
import nl.nicasso.ql.gui.evaluator.values.Value;

public interface Observer {

	public boolean fieldValueChanged(Identifier identifier, Value value);
	
	public void updateAllPanels();
	
}