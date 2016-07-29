package com.github.ilyes4j.gwt.mdl.components.menus;

import com.github.ilyes4j.gwt.mdl.components.menus.Menu.ItemClickListener;

/**
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
   * @param inputIndex
   *          the position of the clicked {@link MenuItem} in the list.
   * @param inputValue
   *          the displayed label of the clicked {@link MenuItem}.
   */
  public ItemClickEvent(final int inputIndex, final String inputValue) {
    super();
    this.index = inputIndex;
    this.value = inputValue;
  }

  /**
   * 
   * @return the position of the clicked {@link MenuItem}
   */
  public final int getIndex() {
    return index;
  }

  /**
   * 
   * @return the displayed label of the clicked {@link MenuItem}
   */
  public final String getValue() {
    return value;
  }

  /**
   * Sequential position of the item in the list of items.
   */
  private int index;

  /**
   * The Text of the item.
   */
  private String value;
}
