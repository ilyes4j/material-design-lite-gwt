package org.zerowarning.gwt.mdl.components.buttons;

/**
 * Controls the coloring option of a raised, flat or icon {@link Button}.
 * Setting this option on a button has a different effect depending on its type.
 * For a flat or icon button, this option controls the color of the text. For a
 * raised button it controls the color of the background.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public enum ButtonColor {

	/**
	 * Setup a button with no extra coloring
	 */
	BTN_NO_COLOR(""),

	/**
	 * Apply the main theme color to the button
	 */
	PRIMARY("mdl-button--primary"),

	/**
	 * Apply the accented theme color to the button
	 */
	ACCENT("mdl-button--accent");

	/**
	 * Setup the option and its corresponding css class name
	 * 
	 * @param css
	 *            the css class name associated with this option
	 */
	private ButtonColor(final String css) {
		this.css = css;
	}

	/**
	 * Returns the css class name related to this option
	 */
	@Override
	public String toString() {
		return css;
	}

	/**
	 * Stores the css class name
	 */
	private final String css;
}
