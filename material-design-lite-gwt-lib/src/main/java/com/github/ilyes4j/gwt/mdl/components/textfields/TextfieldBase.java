package com.github.ilyes4j.gwt.mdl.components.textfields;

import java.text.ParseException;

import com.github.ilyes4j.gwt.mdl.components.ComponentHandler;
import com.github.ilyes4j.gwt.mdl.components.IUpgrade;
import com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils;
import com.github.ilyes4j.gwt.mdl.components.UpgradeHelper;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DragEndEvent;
import com.google.gwt.event.dom.client.DragEndHandler;
import com.google.gwt.event.dom.client.DragEnterEvent;
import com.google.gwt.event.dom.client.DragEnterHandler;
import com.google.gwt.event.dom.client.DragEvent;
import com.google.gwt.event.dom.client.DragHandler;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragLeaveHandler;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragOverHandler;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DragStartHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.GestureChangeEvent;
import com.google.gwt.event.dom.client.GestureChangeHandler;
import com.google.gwt.event.dom.client.GestureEndEvent;
import com.google.gwt.event.dom.client.GestureEndHandler;
import com.google.gwt.event.dom.client.GestureStartEvent;
import com.google.gwt.event.dom.client.GestureStartHandler;
import com.google.gwt.event.dom.client.HasAllDragAndDropHandlers;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllGestureHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.dom.client.TouchCancelEvent;
import com.google.gwt.event.dom.client.TouchCancelHandler;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.AutoDirectionHandler;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;

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
public class TextfieldBase<T extends TextBoxBase> extends FlowPanel
    implements Focusable, HasChangeHandlers, HasName, HasDirectionEstimator,
    HasValue<String>, HasText, AutoDirectionHandler.Target,
    IsEditor<ValueBoxEditor<String>>, HasClickHandlers, HasDoubleClickHandlers,
    HasEnabled, HasAllDragAndDropHandlers, HasAllFocusHandlers,
    HasAllGestureHandlers, HasAllKeyHandlers, HasAllMouseHandlers,
    HasAllTouchHandlers, ITextBox, IsTextBoxBase<T>, IsValueBoxBase<String>,
    IUpgrade {

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

    // make sure the label is correctly positioned only when the text field is
    // already upgraded (which occurs when the component is attached)
    if (isAttached()) {
      checkDirty(getElement());
    }
  }

  @Override
  public HandlerRegistration addDragEndHandler(final DragEndHandler handler) {
    return addBitlessDomHandler(handler, DragEndEvent.getType());
  }

  @Override
  public HandlerRegistration addDragEnterHandler(
      final DragEnterHandler handler) {
    return addBitlessDomHandler(handler, DragEnterEvent.getType());
  }

  @Override
  public HandlerRegistration addDragLeaveHandler(
      final DragLeaveHandler handler) {
    return addBitlessDomHandler(handler, DragLeaveEvent.getType());
  }

  @Override
  public HandlerRegistration addDragHandler(final DragHandler handler) {
    return addBitlessDomHandler(handler, DragEvent.getType());
  }

  @Override
  public HandlerRegistration addDragOverHandler(final DragOverHandler handler) {
    return addBitlessDomHandler(handler, DragOverEvent.getType());
  }

  @Override
  public HandlerRegistration addDragStartHandler(
      final DragStartHandler handler) {
    return addBitlessDomHandler(handler, DragStartEvent.getType());
  }

  @Override
  public HandlerRegistration addDropHandler(final DropHandler handler) {
    return addBitlessDomHandler(handler, DropEvent.getType());
  }

  @Override
  public HandlerRegistration addFocusHandler(final FocusHandler handler) {
    return addBitlessDomHandler(handler, FocusEvent.getType());
  }

  @Override
  public HandlerRegistration addBlurHandler(final BlurHandler handler) {
    return addBitlessDomHandler(handler, BlurEvent.getType());
  }

  @Override
  public HandlerRegistration addGestureStartHandler(
      final GestureStartHandler handler) {
    return addBitlessDomHandler(handler, GestureStartEvent.getType());
  }

  @Override
  public HandlerRegistration addGestureChangeHandler(
      final GestureChangeHandler handler) {
    return addBitlessDomHandler(handler, GestureChangeEvent.getType());
  }

  @Override
  public HandlerRegistration addGestureEndHandler(
      final GestureEndHandler handler) {
    return addBitlessDomHandler(handler, GestureEndEvent.getType());
  }

  @Override
  public HandlerRegistration addKeyDownHandler(final KeyDownHandler handler) {
    return addBitlessDomHandler(handler, KeyDownEvent.getType());
  }

  @Override
  public HandlerRegistration addKeyPressHandler(final KeyPressHandler handler) {
    return addBitlessDomHandler(handler, KeyPressEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseDownHandler(
      final MouseDownHandler handler) {
    return addBitlessDomHandler(handler, MouseDownEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseUpHandler(final MouseUpHandler handler) {
    return addBitlessDomHandler(handler, MouseUpEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseOutHandler(final MouseOutHandler handler) {
    return addBitlessDomHandler(handler, MouseOutEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseOverHandler(
      final MouseOverHandler handler) {
    return addBitlessDomHandler(handler, MouseOverEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseMoveHandler(
      final MouseMoveHandler handler) {
    return addBitlessDomHandler(handler, MouseMoveEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseWheelHandler(
      final MouseWheelHandler handler) {
    return addBitlessDomHandler(handler, MouseWheelEvent.getType());
  }

  @Override
  public HandlerRegistration addTouchStartHandler(
      final TouchStartHandler handler) {
    return addBitlessDomHandler(handler, TouchStartEvent.getType());
  }

  @Override
  public HandlerRegistration addTouchMoveHandler(
      final TouchMoveHandler handler) {
    return addDomHandler(handler, TouchMoveEvent.getType());
  }

  @Override
  public HandlerRegistration addTouchEndHandler(final TouchEndHandler handler) {
    return addDomHandler(handler, TouchEndEvent.getType());
  }

  @Override
  public HandlerRegistration addTouchCancelHandler(
      final TouchCancelHandler handler) {
    return addDomHandler(handler, TouchCancelEvent.getType());
  }

  @Override
  public boolean isEnabled() {
    return box.isEnabled();
  }

  @Override
  public void setEnabled(final boolean enabled) {
    box.setEnabled(enabled);
  }

  @Override
  public HandlerRegistration addDoubleClickHandler(
      final DoubleClickHandler handler) {
    return addDomHandler(handler, DoubleClickEvent.getType());
  }

  @Override
  public HandlerRegistration addClickHandler(final ClickHandler handler) {
    return addDomHandler(handler, ClickEvent.getType());
  }

  @Override
  public int getTabIndex() {
    return box.getTabIndex();
  }

  @Override
  public void setAccessKey(final char key) {
    box.setAccessKey(key);
  }

  @Override
  public void setFocus(final boolean focused) {
    box.setFocus(focused);
  }

  @Override
  public void setTabIndex(final int index) {
    box.setTabIndex(index);
  }

  @Override
  public HandlerRegistration addValueChangeHandler(
      final ValueChangeHandler<String> handler) {
    // Initialization code
    if (!valueChangeHandlerInitialized) {
      valueChangeHandlerInitialized = true;
      addChangeHandler(new ChangeHandler() {
        public void onChange(final ChangeEvent event) {
          ValueChangeEvent.fire(TextfieldBase.this, getValue());
        }
      });
    }
    return addHandler(handler, ValueChangeEvent.getType());
  }

  @Override
  public void setDirection(final Direction direction) {
    box.setDirection(direction);
  }

  @Override
  public Direction getDirection() {
    return box.getDirection();
  }

  @Override
  public HandlerRegistration addKeyUpHandler(final KeyUpHandler handler) {
    return addDomHandler(handler, KeyUpEvent.getType());
  }

  @Override
  public ValueBoxEditor<String> asEditor() {
    return box.asEditor();
  }

  @Override
  public String getText() {
    return box.getText();
  }

  @Override
  public String getValue() {
    return box.getValue();
  }

  @Override
  public void setValue(final String value) {
    box.setValue(value);
  }

  @Override
  public void setValue(final String value, final boolean fireEvents) {
    box.setValue(value, fireEvents);
  }

  @Override
  public DirectionEstimator getDirectionEstimator() {
    return box.getDirectionEstimator();
  }

  @Override
  public void setDirectionEstimator(final boolean enabled) {
    box.setDirectionEstimator(enabled);
  }

  @Override
  public void setDirectionEstimator(
      final DirectionEstimator directionEstimator) {
    box.setDirectionEstimator(directionEstimator);
  }

  @Override
  public void setName(final String name) {
    box.setName(name);
  }

  @Override
  public String getName() {
    return box.getName();
  }

  @Override
  public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
    return addDomHandler(handler, ChangeEvent.getType());
  }

  @Override
  public int getMaxLength() {
    return getInputElement().getMaxLength();
  }

  @Override
  public int getVisibleLength() {
    return getInputElement().getSize();
  }

  @Override
  public void setMaxLength(final int length) {
    getInputElement().setMaxLength(length);
  }

  @Override
  public void setVisibleLength(final int length) {
    getInputElement().setSize(length);
  }

  @Override
  public T asTextBoxBase() {
    return box;
  }

  @Override
  public void cancelKey() {
    if (currentEvent != null) {
      currentEvent.preventDefault();
    }
  }

  @Override
  public int getCursorPos() {
    return box.getCursorPos();
  }

  @Override
  public String getSelectedText() {
    return box.getSelectedText();
  }

  @Override
  public int getSelectionLength() {
    return box.getSelectionLength();
  }

  @Override
  public String getValueOrThrow() throws ParseException {
    return box.getValueOrThrow();
  }

  @Override
  public boolean isReadOnly() {
    return box.isReadOnly();
  }

  @Override
  public void selectAll() {
    box.selectAll();
  }

  @Override
  public void setAlignment(final TextAlignment align) {
    box.setAlignment(align);
  }

  @Override
  public void setCursorPos(final int pos) {
    box.setCursorPos(pos);
  }

  @Override
  public void setReadOnly(final boolean readOnly) {
    box.setReadOnly(readOnly);
  }

  @Override
  public void setSelectionRange(final int pos, final int length) {
    box.setSelectionRange(pos, length);
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

  @Override
  protected final void onLoad() {
    super.onLoad();

    upgrade();
  }

  @Override
  public void upgrade() {

    // upgrade the component
    ComponentHandler.upgradeElement(getElement());

    upgrade.upgrade();
  }

  @Override
  public boolean isUpgraded() {
    return upgrade.isUpgraded();
  }

  /**
   * @return the input element
   */
  private InputElement getInputElement() {
    return box.getElement().cast();
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
   * Upgrade manager.
   */
  private UpgradeHelper upgrade = new UpgradeHelper();

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

  /**
   * Keeps track of the value change handler initialization.
   */
  private boolean valueChangeHandlerInitialized;
}
