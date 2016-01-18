package org.zerowarning.gwt.mdl.components.buttons;

public enum ButtonType {

	RAISED("mdl-button--raised"), FLAT(""), ICON("mdl-button--icon"), FAB("mdl-button--fab"), MINIFAB(
			"mdl-button--fab mdl-button--mini-fab");

	private ButtonType(final String css) {
		this.css = css;
	}

	@Override
	public String toString() {
		return css;
	}

	private final String css;
}
