package org.zerowarning.gwt.mdl.components;

import com.google.gwt.dom.client.Element;

/**
 * Exposes functions found in <a href=
 * "https://github.com/google/material-design-lite/blob/master/src/mdlComponentHandler.js">
 * componentHandler</a>.<br>
 * 
 * <h1>On mdl components</h1> <br>
 * 
 * An mdl component is an html DOM decorated with css selectors and enhanced
 * with js behaviors. In order for the component to react to user input, listen
 * to events and display effect and animations, it has to be "upgraded".<br>
 * 
 * Behaviors that should be acquired by the component are defined in the
 * component's js class. For example, MaterialMenu is the js class that contains
 * the behaviors to be applied on menu and MaterialButton is the js class that
 * operates on buttons. In general, a component class definess :<br>
 * <br>
 * 
 * <ul>
 * <li>The transformations to be applied on the DOM of the component</li>
 * <li>The events to be setup on the DOM tree of the component</li>
 * <li>The actions to be performed in response to these events</li>
 * </ul>
 * 
 * When the page is loaded, componentsHandler is initiated. The components
 * classes are then defined. Each defined component will register itself to
 * componentsHandler and mapped to a css selector. For example, MaterialMenu is
 * mapped to mdl-js-menu when it is registered in componentsHandler.<br>
 * <br>
 * 
 * For each registered class the componentsHandler will retrieve the mapped css
 * and scan the DOM looking for elements decorated with that css selector. The
 * matched elements are the ones to be upgraded using instances of the the
 * component's js class. Again with the menus example, when componentsHandler
 * finds an element in the page's DOM containing the mdl-js-menu css selector,
 * it sets up new instance of MaterialMenu and feeds it with the element node of
 * the menu.<br>
 * <br>
 * MaterialMenu will then "upgrade" the menu as follows. It removes the node
 * from the DOM and puts a container in its place. Then, it puts back the menu
 * node inside that container and puts another node for the background just
 * before the menu node. The background node is animated when the menu is
 * opened.<br>
 * <br>
 * If the menu contains a ripple css selector <code>mdl-js-ripple-effect</code>,
 * MaterialMenu it will add a ripple container in each item of the menu.<br>
 * <br>
 * MaterialMenu then retrieves the for attribute from the menu element. That
 * attributes holds the id of the action button that will show the menu when it
 * is clicked. MaterialMenu then locates the button in the DOM and adds a click
 * listener to it. It then adds the appropriate event handlers to close the
 * menu.<br>
 * <br>
 * All these behaviors occur without the intervention of the developer who
 * simply includes the mdl script into the page header and setup the DOM of the
 * required components.<br>
 * <br>
 * 
 * <h1>On dynamically generated components</h1> <br>
 * 
 * Sometimes, components are setup and added to the the DOM after
 * componentsHandler scans the DOM looking for components to be upgraded.In this
 * case, componentsHandler will not find the dynamically generated components
 * because they are not attached to the DOM yet. To handle this use case,
 * componentsHandler exposes a set of functions to deal with dynamically
 * generated components.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class ComponentHandler {

	/**
	 * Upgrade a specific {@link Element} rather than all elements of the DOM.
	 * 
	 * @param element
	 */
	public static native void upgradeElement(Element element)
	/*-{
		$wnd.componentHandler.upgradeElement(element);
	}-*/;
}
