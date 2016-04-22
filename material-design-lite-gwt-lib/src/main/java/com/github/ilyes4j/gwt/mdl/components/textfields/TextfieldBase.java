package com.github.ilyes4j.gwt.mdl.components.textfields;

import com.github.ilyes4j.gwt.mdl.components.ComponentHandler;
import com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.ValueBoxBase;

/**
 * A base class for Material Text Fields.
 * <p>
 * Material design lite provides three options to type text.
 * <ul>
 * <li>Text field</li>
 * <li>Expanding text field</li>
 * <li>Text area</li>
 * </ul>
 * {@link TextfieldBase} holds common features for text based material
 * components. The DOM structure of a text field is simple. At the top level, a
 * <code>div</code> element contains an <code>input</code> element, a
 * <code>div</code> element to set the label to displayed inside the input and a
 * <code>span</code> to display an error message below the input box when the
 * input text does not comply to the validation rule.
 * </p>
 * <p>
 * The {@link TextfieldBase} uses a {@link TextBoxBase} under the hood to handle
 * the input. The exact instance of input Widget to wrap is provided from the
 * outside to insure a better flexibility. Wrappings for the usual GWT input
 * Widgets are provided out of the box.
 * <ul>
 * <li>{@link TextField} for {@link TextBox}</li>
 * <li>{@link PasswordField} for {@link PasswordTextBox}</li>
 * <li>{@link MultilineTextField} for {@link TextArea}</li>
 * </ul>
 * </p>
 * 
 * @param <T>
 *          the input Widget to wrap.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class TextfieldBase<T extends TextBoxBase> extends FlowPanel {

  /**
   * Setup an instance of {@link TextfieldBase} type. The appropriate input
   * Widget depends on the context and therefore provided from the outside.
   * 
   * @param inputBox
   *          the input type to be used
   */
  public TextfieldBase(final T inputBox) {

    // generate a unique id to be supplied to the input and the associated label
    String txtId = Document.get().createUniqueId();

    // create a CSS switcher for the float behavior
    cssFloat = new FloatSwitcher();
    cssFloat.setTarget(getElement());

    // setting up the main CSS style for the text field
    setStyleName(MDL_TXTFLD);
    addStyleName(MDL_JS_TXTFLD);

    // setting up the input field
    box = inputBox;
    // assigning the unique id to the input
    box.getElement().setId(txtId);
    // setting the mdl input CSS class
    box.setStyleName(MDL_TXTFLD_INPUT);
    // attaching the text box to the container
    add(box);

    // setup the label displayed inside the empty input
    label = new Label();
    // bind the label widget to the input Widget
    MdlGwtUtils.setFor(label.getElement(), txtId);
    // setting the mdl lable CSS class
    label.setStyleName(MDL_TXTFLD_LBL);
    // attaching the label to the container
    add(label);
  }

  /**
   * Setup a new instance of {@link TextfieldBase} type and provide a label.
   * 
   * @param inputLabel
   *          a hint to be displayed in the text box.
   * 
   * @param inputBox
   *          the input Widget to be used
   */
  public TextfieldBase(final String inputLabel, final T inputBox) {
    // create the DOM structure of the input component
    this(inputBox);
    // set the label text
    setLabel(inputLabel);
  }

  /**
   * Make the label float over the text box when the input acquires the focus.
   * If the input is still empty after the focus leaves the input, then the
   * label will get back to its original position. If the input is filled with
   * characters, the label remains above the input. The label gets back inside
   * the input as soon as the focus leaves an empty input.
   * 
   * @param inputFloat
   *          the floating state of the label
   */
  public final void setFloat(final Float inputFloat) {
    cssFloat.setValue(inputFloat);
  }

  /**
   * The {@link TextfieldBase} contains a sub-type {@link TextBoxBase} under the
   * hood.
   * 
   * @return the underlying input Widget
   */
  public final T getTextbox() {
    return box;
  }

  /**
   * The {@link TextfieldBase} contains a {@link Label} under the hood to
   * display the hint inside the text box when it is empty.
   * 
   * @return the label Widget containing the label text
   */
  protected final Label getLabel() {
    return label;
  }

  /**
   * Set the label of the text field. The label is a text positioned inside the
   * text box instead of traditionally being besides the text box.
   * 
   * @param inputLabel
   *          a hint about the field
   * 
   */
  public final void setLabel(final String inputLabel) {
    label.setText(inputLabel);
  }

  /**
   * programmatically provides the input field with a text. This method
   * transfers the provided text to {@link ValueBoxBase#setText(String)} and
   * makes sure the label is correctly positioned.
   * 
   * @param text
   *          the text to be fed to the input field
   */
  public void setText(final String text) {
    box.setText(text);
    checkDirty(getElement());
  }

  @Override
  protected final void onLoad() {
    super.onLoad();

    // upgrade the component
    ComponentHandler.upgradeElement(getElement());
  }

  /**
   * Checks whether the text field is empty and relocates the label accordingly.
   * <ul>
   * <li>If the text field is empty the label is replaced inside the text box.
   * </li>
   * <li>If the text field is not empty then the label is relocated above the
   * text box</li>
   * </ul>
   * 
   * @param element
   *          the root element of the text field
   */
  private native void checkDirty(final Element element)
  /*-{
    element.MaterialTextfield.checkDirty();
  }-*/;

  /**
   * {@link Label} widget for the text field.
   */
  private Label label;

  /**
   * The CSS class switcher responsible for managing the float state.
   */
  private FloatSwitcher cssFloat;

  /**
   * A {@link TextBoxBase} sub-type used to acquire user input.
   */
  private T box;

  /**
   * CSS class for the label.
   */
  private static final String MDL_TXTFLD_LBL = "mdl-textfield__label";

  /**
   * CSS class for the embedded input field.
   */
  private static final String MDL_TXTFLD_INPUT = "mdl-textfield__input";

  /**
   * CSS class the container element.
   */
  private static final String MDL_TXTFLD = "mdl-textfield";

  /**
   * CSS flag intended for upgrading text field component.
   */
  private static final String MDL_JS_TXTFLD = "mdl-js-textfield";
}
