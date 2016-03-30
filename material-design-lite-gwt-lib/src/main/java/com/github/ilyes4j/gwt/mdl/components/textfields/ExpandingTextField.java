package com.github.ilyes4j.gwt.mdl.components.textfields;

import com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonBase;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 * <p>
 * The expanding text field have all the feature you would expect from a
 * {@link TextField}. The expanding text field have an extra icon button on the
 * left side. When the focus is not on the expanding text field, only the icon
 * button is visible. When the icon button acquires the focus, the
 * {@link TextField} part shows up and disappears as soon as the focus leaves
 * the expanding field.
 * </p>
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class ExpandingTextField extends TextField {

  /**
   * While inheriting all the features of a {@link TextField}, the
   * {@link ExpandingTextField} has a slightly different DOM structure than the
   * {@link TextField} it is inheriting from. Setting up an instance of an
   * expanding text field implies making some changes to the DOM structure of
   * the text field to make it suitable for the expanding text field.
   * 
   * @param icon
   *          a material icon code for the action label
   */
  public ExpandingTextField(final String icon) {

    /**
     * While inheriting all the features of a text field, the expanding text
     * field has a slightly different DOM structure than the text field it is
     * inheriting from.
     * 
     * Setting up an instance of an expanding text field implies making some
     * changes to the DOM structure of the text field to make it suitable for
     * the expanding text field.
     * 
     * Morphing a text field into an expanding text field is achieved through
     * these steps :
     * 
     * 1. add an extra CSS class to the main container
     * 
     * 2. create the icon button and put it in the main container
     * 
     * 3. create a second level container and put it inside the main container
     * after right after the action button
     * 
     * 5. add a CSS class to the second level container.
     * 
     * 4. relocate all the regular text field parts inside the second container
     */

    // setup a regular text field
    super();

    // add an extra CSS class on the container part
    addStyleName(CSS_EXPANDING);

    // retrieve the parts of the text field
    TextBox box = getTextbox();
    Label label = getLabel();
    InlineLabel error = getErrorLabel();

    // create a label element for the icon button
    Element actionElt = Document.get().createLabelElement();
    // wire the label to the input element
    MdlGwtUtils.setFor(actionElt, box.getElement().getId());
    // add the button behavior to the label element
    ButtonBase btn = new ButtonBase(actionElt);
    // set the button to be an icon button
    btn.setType(ButtonType.ICON);
    // apply the icon to the button
    btn.setIcon(icon);
    // attach the button to the frist level container
    getElement().appendChild(actionElt);

    // create a second level container
    txtFldContainer = new FlowPanel();
    // add a CSS class to the second level container
    txtFldContainer.addStyleName(CSS_HOLDER);
    // relocate the text field parts to the second level container
    txtFldContainer.add(box);
    txtFldContainer.add(label);
    txtFldContainer.add(error);
    // add the second level container inside the first level container right
    // below the icon button
    add(txtFldContainer);
  }

  /**
   * The second level container containing the text field parts.
   */
  private FlowPanel txtFldContainer;

  /**
   * additional CSS class for the expanding text field.
   */
  private static final String CSS_EXPANDING = "mdl-textfield--expandable";

  /**
   * CSS class for the second level container.
   */
  private static final String CSS_HOLDER = "mdl-textfield__expandable-holder";
}
