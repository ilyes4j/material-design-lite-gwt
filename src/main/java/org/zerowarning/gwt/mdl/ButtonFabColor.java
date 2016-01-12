package org.zerowarning.gwt.mdl;

public enum ButtonFabColor {
	FAB_NO_COLOR(""), COLORED("mdl-button--colored");

	private ButtonFabColor(final String css) {
		this.css = css;
	}

	@Override
	public String toString() {
		return css;
	}

	private final String css;
}
