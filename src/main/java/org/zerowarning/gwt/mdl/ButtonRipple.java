package org.zerowarning.gwt.mdl;

public enum ButtonRipple {

	NONE(""), RIPPLE("mdl-js-ripple-effect");

	private ButtonRipple(final String css) {
		this.css = css;
	}

	@Override
	public String toString() {
		return css;
	}

	private final String css;
}
