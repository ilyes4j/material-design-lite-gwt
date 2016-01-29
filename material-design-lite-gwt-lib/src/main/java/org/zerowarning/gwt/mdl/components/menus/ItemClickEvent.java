package org.zerowarning.gwt.mdl.components.menus;

import org.zerowarning.gwt.mdl.components.menus.Menu.ItemClickListener;

/***
 * Event dispatched from a {@link Menu} to all its {@link ItemClickListener}s to
 * send them the required informations about the clicked {@link MenuItem}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ItemClickEvent {

	/**
	 * Create an {@link ItemClickEvent} provided the displayed label of the
	 * {@link MenuItem} that was clicked and its position in the list of
	 * {@link MenuItem}s.
	 * 
	 * 
	 * @param index
	 *            the position of the clicked {@link MenuItem} in the list.
	 * @param value
	 *            the displayed label of the clicked {@link MenuItem}.
	 */
	public ItemClickEvent(int index, String value) {
		super();
		this.index = index;
		this.value = value;
	}

	/**
	 * 
	 * @return the position of the clicked {@link MenuItem}
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * 
	 * @return the displayed label of the clicked {@link MenuItem}
	 */
	public String getValue() {
		return value;
	}

	private int index;

	private String value;
}
