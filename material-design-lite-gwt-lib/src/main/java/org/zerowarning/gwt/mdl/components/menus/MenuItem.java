package org.zerowarning.gwt.mdl.components.menus;

import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * {@link MenuItem} is an option in the list of options in a Material
 * {@link Menu}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MenuItem extends HTMLPanel {

	/**
	 * Create an item and set its label.
	 * 
	 * @param text
	 *            The displayed label.
	 */
	public MenuItem(String text) {
		// the container is a list item tag
		super(LIElement.TAG, "");

		// that has the menu item material css style
		addStyleName(CSS_MENU_ITEM);

		// the item contains a span that holds the label to be displayed.
		content = new HTMLPanel(SpanElement.TAG);

		// add the text container to the item container
		add(content);

		// set the label to the provided text
		content.getElement().setInnerText(text);
	}

	/**
	 * If false, the used is prohibited from selecting the item.
	 * 
	 * @param enabled
	 *            if false make
	 */
	public void setEnabled(boolean enable) {

		boolean isDisabled = getElement().hasAttribute(ATTR_DISABLED);

		// if the requested state is identical to the actual state then leave
		// without doing anything
		if (enable == !isDisabled) {
			return;
		}

		// if the item is disabled and a request is made to enable it then
		// remove the disabled attribute
		if (enable && isDisabled) {
			getElement().removeAttribute(ATTR_DISABLED);
		}
		// if the item is enabled and a request is made to disable it then
		// add a disabled attribute
		else if (!enable && !isDisabled) {
			getElement().setAttribute(ATTR_DISABLED, "true");
		}
	}

	/**
	 * Returns the displayed text of the item.
	 * 
	 * @return the label of the item.
	 */
	public String getText() {
		return content.getElement().getInnerText();
	}

	// span tag to hold the displayed label of the item
	private HTMLPanel content;

	// menu item mdl css style
	private static final String CSS_MENU_ITEM = "mdl-menu__item";

	// disabled attribute name
	private static String ATTR_DISABLED = "disabled";
}
