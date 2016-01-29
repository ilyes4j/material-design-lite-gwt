package org.zerowarning.gwt.mdl.components.ripples;

/**
 * Indicates whether ripples are enabled for the Material component or not.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public enum Ripple {

	NONE(""), HAS_RIPPLE("mdl-js-ripple-effect");

	/**
	 * Create a {@link Ripple} enum and provide its css style name.
	 * 
	 * @param css
	 *            the css style name of the ripple effect.
	 */
	private Ripple(final String css) {
		this.css = css;
	}

	@Override
	public String toString() {
		return css;
	}

	private final String css;
}
