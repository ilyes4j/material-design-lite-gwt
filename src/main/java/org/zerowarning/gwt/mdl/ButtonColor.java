package org.zerowarning.gwt.mdl;

public enum ButtonColor {
	BTN_NO_COLOR(""),  PRIMARY("mdl-button--primary"), ACCENT("mdl-button--accent");
	
	private ButtonColor(final String css) {
		this.css = css;
	}

	@Override
	public String toString() {
		return css;
	}

	private final String css;
}
