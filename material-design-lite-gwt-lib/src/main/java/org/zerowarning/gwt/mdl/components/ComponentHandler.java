package org.zerowarning.gwt.mdl.components;

import com.google.gwt.dom.client.Element;

public class ComponentHandler {

	public static native void upgradeElement(Element element)
	/*-{
		$wnd.componentHandler.upgradeElement(element);
	}-*/;
}
