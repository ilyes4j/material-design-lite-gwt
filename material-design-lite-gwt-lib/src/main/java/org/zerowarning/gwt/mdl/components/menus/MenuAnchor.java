package org.zerowarning.gwt.mdl.components.menus;

/**
 * {@link MenuAnchor} defines how the {@link Menu} should be positioned
 * relatively to its associated button. There are four possible options :<br>
 * <br>
 * 
 * <li>{@link MenuAnchor#BOTTOM_LEFT}</li>
 * <li>{@link MenuAnchor#BOTTOM_RIGHT}</li>
 * <li>{@link MenuAnchor#TOP_LEFT}</li>
 * <li>{@link MenuAnchor#TOP_RIGHT}</li>
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public enum MenuAnchor {

	/**
	 * {@link MenuAnchor#BOTTOM_LEFT} sets the position the top left corner of
	 * the {@link Menu} next to the bottom left corner of the action button.
	 */
	BOTTOM_LEFT(""),

	/**
	 * {@link MenuAnchor#BOTTOM_RIGHT} sets the position the top right corner of
	 * the {@link Menu} next to the bottom right corner of the action button.
	 */
	BOTTOM_RIGHT("mdl-menu--bottom-right"),

	/**
	 * {@link MenuAnchor#TOP_LEFT} sets the position the bottom left corner of
	 * the {@link Menu} next to the top left corner of the action button.
	 */
	TOP_LEFT("mdl-menu--top-left"),

	/**
	 * {@link MenuAnchor#TOP_RIGHT} sets the position the bottom right corner of
	 * the {@link Menu} next to the top right corner of the action button.
	 */
	TOP_RIGHT("mdl-menu--top-right");

	private MenuAnchor(final String css) {
		this.css = css;
	}

	/**
	 * Returns the css selector responsible for the anchoring behavior.
	 */
	@Override
	public String toString() {
		return css;
	}

	private final String css;
}
