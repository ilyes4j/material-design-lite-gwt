package org.zerowarning.gwt.mdl.components.menus;

import org.zerowarning.gwt.mdl.components.menus.Menu.ItemClickListener;

import com.google.gwt.user.client.ui.Anchor;

/**
 * Every component that has menu related features should implement this
 * interface.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public interface IMenu {

  /**
   * Sets the position of the {@link Menu} on the screen related to its
   * associated action button using one of the available anchoring options
   * provided by {@link MenuAnchor}.<br>
   * <br>
   * 
   * An extra care should be taken when anchoring the menu. According to this
   * <a href="https://github.com/google/material-design-lite/issues/952"> thread
   * </a>, the menu's parent need a position:relative in order for the menu to
   * be anchored correctly.
   * 
   * @param anchor
   *          the requested {@link Anchor} position for the {@link Menu} .
   */
  void setAnchor(MenuAnchor anchor);

  /**
   * Remove all items from the menu.
   */
  void clearMenu();

  /**
   * Adds a new option to the list of options in the menu.
   * 
   * @param value
   *          The value to be added
   * 
   * @param text
   *          The text to be displayed
   * 
   * @param enabled
   *          Defines whether the option can be chosen or not.
   */
  void addItem(String value, String text, boolean enabled);

  /**
   * When an object needs to be notified upon a {@link MenuItem} click, it must
   * be be registered to the {@link Menu} as an {@link ItemClickListener} .<br>
   * <br>
   * In order to receive item click notifications, the object should :
   * <ol>
   * <li>Implement the {@link ItemClickListener} interface</li>
   * <li>Define the actions that should be performed when a {@link MenuItem} is
   * clicked inside {@link ItemClickListener#onItemClicked(ItemClickEvent)}</li>
   * <li>Call {@link Menu#addItemClickListener(ItemClickListener)} to register
   * itself to the menu and receive click notifications</li>
   * </ol>
   * 
   * @param listener
   *          The object to be notified when a {@link MenuItem} is clicked.
   * 
   * @see ItemClickListener
   */
  void addItemClickListener(ItemClickListener listener);

  /**
   * Returns the items count in a menu.
   * 
   * @return the items count in a menu
   */
  int getItemCount();

  /**
   * return the text of the item located at the position provided as input.
   * 
   * @param index
   *          the position of the item
   * 
   * @return the text of the item at input position
   */
  String getItemText(int index);

  /**
   * return the value of the item located at the position provided as input.
   * 
   * @param index
   *          the position of the item
   * 
   * @return the value of the item at input position
   */
  String getValue(int index);

  /**
   * Modify the enabled state of an item. The position of the item is provided
   * as input
   * 
   * @param index
   *          the position of the item in the item list of the menu
   * 
   * @param enabled
   *          the state to be set for the item
   * 
   * @return <code>true</code> if the state was modified, <code>false</code>
   *         otherwise.
   */
  boolean setEnabled(int index, boolean enabled);

  /**
   * Modify the enabled state of an item. The position of the item is provided
   * as input
   * 
   * @param index
   *          the position of the item in the item list of the menu
   * 
   * @return <code>true</code> if the item is enabled, <code>false</code>
   *         otherwise.
   */
  boolean isEnabled(int index);
}
