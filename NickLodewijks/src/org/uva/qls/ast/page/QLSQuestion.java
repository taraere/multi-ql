package org.uva.qls.ast.page;

import org.uva.qls.ast.QLSASTNode;
import org.uva.qls.ast.widget.QLSWidget;

public class QLSQuestion extends QLSASTNode {

	private final String id;
	private final QLSWidget widget;

	public QLSQuestion(String id) {
		this.id = id;
		this.widget = null;
	}

	public QLSQuestion(String id, QLSWidget widget) {
		this.id = id;
		this.widget = widget;
	}

	public String getId() {
		return id;
	}

	public QLSWidget getWidget() {
		return widget;
	}

}