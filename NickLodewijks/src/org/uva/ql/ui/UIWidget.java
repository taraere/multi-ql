package org.uva.ql.ui;

/**
 * A QLWidget represents the GUI component for an input field, or computed value
 * in the questionnaire.
 */
public interface UIWidget<T> extends UIComponent<T> {

	/**
	 * Return the current value of the widget
	 * 
	 * @return the value of the widget.
	 */
	public Object getValue();

	/**
	 * Set the value and return whether the value has changed.
	 * 
	 * @param value
	 *            the value to set
	 * @return {@code true} if the value has changed, {@code false} otherwise.
	 */
	public boolean setValue(Object value);

	/**
	 * Set whether this QLWidget is editable.
	 * 
	 * @param editable
	 *            the boolean to set.
	 */
	public void setEditable(boolean editable);
}
