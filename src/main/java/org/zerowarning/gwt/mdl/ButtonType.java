package org.zerowarning.gwt.mdl;

public enum ButtonType {

	RAISED("mdl-button--raised"), FLAT(""), ICON("mdl-button--icon"), FAB("mdl-button--fab");

	private ButtonType(final String css) {
		this.css = css;
	}

	@Override
	public String toString() {
		return css;
	}

	private final String css;
}
