package org.uva.sea.ql.gui.panels;

import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.gui.widgets.Widget;

public class IfStatementPanel extends Panel {
	
	// u need the expression? go to sleep...see this tomorrow...

	private IfStatement ifStatement;
	private Widget widget;
	
	
	public IfStatement getIfStatement() {
		return ifStatement;
	}
	
	public Widget getWidget() {
		return widget;
	}
	
}