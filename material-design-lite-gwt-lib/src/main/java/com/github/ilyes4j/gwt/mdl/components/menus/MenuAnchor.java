package com.github.ilyes4j.gwt.mdl.components.menus;

/**
 * {@link MenuAnchor} defines how the {@link Menu} should be positioned
 * relatively to its associated button. There are four possible options :<br>
 * 
 * <ul>
 * <li>{@link MenuAnchor#BOTTOM_LEFT}</li>
 * <li>{@link MenuAnchor#BOTTOM_RIGHT}</li>
 * <li>{@link MenuAnchor#TOP_LEFT}</li>
 * <li>{@link MenuAnchor#TOP_RIGHT}</li>
 * </ul>
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public enum MenuAnchor {

  /**
   * {@link MenuAnchor#BOTTOM_LEFT} sets the position the top left corner of the
   * {@link Menu} next to the bottom left corner of the action button.
   */
  BOTTOM_LEFT,

  /**
   * {@link MenuAnchor#BOTTOM_RIGHT} sets the position the top right corner of
   * the {@link Menu} next to the bottom right corner of the action button.
   */
  BOTTOM_RIGHT,

  /**
   * {@link MenuAnchor#TOP_LEFT} sets the position the bottom left corner of the
   * {@link Menu} next to the top left corner of the action button.
   */
  TOP_LEFT,

  /**
   * {@link MenuAnchor#TOP_RIGHT} sets the position the bottom right corner of
   * the {@link Menu} next to the top right corner of the action button.
   */
  TOP_RIGHT;
}
