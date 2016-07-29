package com.github.ilyes4j.gwt.mdl.components;

import com.google.gwt.dom.client.Element;

/**
 * Exposes the functions provided by
 * <a href= "http://tinyurl.com/go7mm5d"> componentHandler</a>.<br>
 * 
 * <h1>On mdl components</h1> <br>
 * 
 * An mdl component is an html DOM decorated with css selectors and enhanced
 * with js behaviors. In order for the component to react to user input, listen
 * to events and display effect and animations, it has to be "upgraded".<br>
 * 
 * Behaviors that should be acquired by the component are defined in the
 * component's js class. For example,
 * <a href= "http://tinyurl.com/zbnhayt"> MaterialMenu</a> is the js class that
 * contains the behaviors to be applied on menu and <code>MaterialButton</code>
 * is the js class that operates on buttons. In general, a component class
 * definess : <br>
 * <br>
 * 
 * <ul>
 * <li>The transformations to be applied on the DOM of the component</li>
 * <li>The events to be setup on the DOM tree of the component</li>
 * <li>The actions to be performed in response to these events</li>
 * </ul>
 * <br>
 * 
 * <h1>Declarative mdl components</h1> <br>
 * When the page is loaded, <code>componentHandler</code> is initiated. The
 * components classes are then defined. Each defined component registers itself
 * to <code>componentHandler</code> and is mapped to a css selector. For
 * example, <code>MaterialMenu</code> is mapped to <code>mdl-js-menu</code> when
 * it is registered in <code>componentHandler</code> .<br>
 * <br>
 * 
 * For each registered class, <code>componentHandler</code> will retrieve the
 * mapped css and scan the DOM looking for elements decorated with that css
 * selector. The matched elements are to be upgraded using instances of the
 * component's class. Again, with the menus example, when
 * <code>componentHandler</code> finds an element in the DOM containing the css
 * selector <code>mdl-js-menu</code>, it sets up a new instance of
 * <code>MaterialMenu</code> and feeds it with the element node of the menu.<br>
 * <br>
 * The created instance of <code>MaterialMenu</code> will then "upgrade" the
 * menu. It detaches the node from the DOM and puts a container in its place.
 * Then, it puts back the menu node inside the container and puts a background
 * node just before the menu node. The background node is of animation use when
 * the menu is opened.<br>
 * <br>
 * If the menu contains a ripple css selector <code>mdl-js-ripple-effect</code>,
 * the <code>MaterialMenu</code> instance will add a ripple container in each
 * item of the menu.<br>
 * <br>
 * The <code>MaterialMenu</code> instance then retrieves the for attribute from
 * the menu element. That attributes holds the id of the action button that will
 * show the menu when it is clicked. It, then, locates the button in the DOM and
 * adds a click listener to it. It then adds the appropriate event handlers to
 * close the menu.<br>
 * <br>
 * All these behaviors occur without the intervention of the developer who
 * simply includes the mdl script into the page header and setup the DOM of the
 * required components.<br>
 * <br>
 * 
 * <h1>Dynamically generated components</h1> <br>
 * 
 * Sometimes, components are setup and added to the the DOM after
 * <code>componentHandler</code> scans the DOM looking for components to be
 * upgraded. In that case, <code>componentHandler</code> will not find the
 * dynamically generated components because they are not attached to the DOM
 * yet. To handle this use case, <code>componentHandler</code> exposes a set of
 * functions to deal with dynamically generated components.<br>
 * <br>
 * Depending on the the Material JS Class that will manage the upgrade process,
 * it might be required that the {@link Element} to be upgraded is attached to
 * the DOM before firing the upgrade. For instance <code>MaterialMenu</code>
 * require that the to-be-upgraded component is already attached to the DOM and
 * since <code>MaterialMenu</code> also scans the DOM looking for the action
 * button related to the menu it also requires that this button is itself
 * attached to the DOM.<br>
 * <br>
 * These requirements are enforced by GWT-MDL itself whenever possible to
 * prevent the developer from having to deal with the details and requirements
 * of each component.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public final class ComponentHandler {

  /**
   * A private constructor for the utility method.
   */
  private ComponentHandler() {
  }

  /**
   * Upgrade a specific component rather than all components of the DOM. To
   * upgrade a component, its DOM {@link Element} must be provided as input. The
   * {@link Element} node to be provided is the node decorated with the
   * <code>mdl-js-xxx</code> css selector.The DOM tree of the component must
   * follow the guidelines enforced on declarative components regarding the
   * expected html and css styling.<br>
   * 
   * @param element
   *          the target html node of the component to be upgraded.
   * 
   */
  public static native void upgradeElement(final Element element)
  /*-{
    $wnd.componentHandler.upgradeElement(element);
  }-*/;
}
