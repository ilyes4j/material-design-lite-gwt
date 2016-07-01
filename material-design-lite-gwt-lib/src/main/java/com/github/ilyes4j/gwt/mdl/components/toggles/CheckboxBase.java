package com.github.ilyes4j.gwt.mdl.components.toggles;

import com.github.ilyes4j.gwt.mdl.components.IUpgrade;
import com.github.ilyes4j.gwt.mdl.components.ripples.HasRipple;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Style.WhiteSpace;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.ButtonBase;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DirectionalTextHelper;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasDirectionalSafeHtml;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWordWrap;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 * This class is the base structure for the material toggle-based components.
 * <p>
 * The material toggle is the material design alternative for check boxes and
 * radio buttons. The material toggle is as capable as the GWT {@link CheckBox}.
 * It is important that the material toggle offers at least all the available
 * feature in the standard GWT Widget. To avoid re-inventing the wheel the
 * material toggle should ideally inherit or embed the original Widget.
 * Unfortunately, due to severe divergence in the DOM structure between the
 * material toggle and the GWT check box, this is not technically possible. As a
 * result, this class is a copy of the original {@link CheckBox} Widget with
 * additional material related features.
 * </p>
 * <p>
 * {@link CheckboxBase} re-implements the DOM structure needed to fit the mdl
 * structure and adds the material layer on top of it.
 * </p>
 *
 * @param <T>
 *          the flavor to be applied
 */
public class CheckboxBase<T extends Enum<T>> extends ButtonBase implements
    HasRipple, HasName, HasValue<Boolean>, HasWordWrap, HasDirectionalSafeHtml,
    HasDirectionEstimator, IsEditor<LeafValueEditor<Boolean>>, IUpgrade {

  /**
   * Creates a check box with no label.
   * 
   * @param paramToggle
   *          the material design selector
   */
  public CheckboxBase(final ToggleStyleOperator<T> paramToggle) {
    this(Document.get().createCheckInputElement(), paramToggle);
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param paramToggle
   *          the material design selector
   */
  public CheckboxBase(final SafeHtml label,
      final ToggleStyleOperator<T> paramToggle) {
    this(label.asString(), true, paramToggle);
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param dir
   *          the text's direction. Note that {@code DEFAULT} means direction
   *          should be inherited from the widget's parent element.
   * 
   * @param paramToggle
   *          the material design selector
   */
  public CheckboxBase(final SafeHtml label, final Direction dir,
      final ToggleStyleOperator<T> paramToggle) {
    this(paramToggle);
    setHTML(label, dir);
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param directionEstimator
   *          A DirectionEstimator object used for automatic direction
   *          adjustment.
   * 
   * @param paramToggle
   *          the design flavor selector
   */
  public CheckboxBase(final SafeHtml label,
      final DirectionEstimator directionEstimator,
      final ToggleStyleOperator<T> paramToggle) {
    this(paramToggle);
    setDirectionEstimator(directionEstimator);
    setHTML(label.asString());
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param paramToggle
   *          the design flavor selector
   */
  public CheckboxBase(final String label,
      final ToggleStyleOperator<T> paramToggle) {
    this(paramToggle);
    setText(label);
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param dir
   *          the text's direction. Note that {@code DEFAULT} means direction
   *          should be inherited from the widget's parent element.
   * 
   * @param paramToggle
   *          the material design selector
   */
  public CheckboxBase(final String label, final Direction dir,
      final ToggleStyleOperator<T> paramToggle) {
    this(paramToggle);
    setText(label, dir);
  }

  /**
   * Creates a label with the specified text and a default direction estimator.
   * 
   * @param label
   *          the check box's label
   * 
   * @param directionEstimator
   *          A DirectionEstimator object used for automatic direction
   *          adjustment.
   * 
   * @param paramToggle
   *          the material design selector
   */
  public CheckboxBase(final String label,
      final DirectionEstimator directionEstimator,
      final ToggleStyleOperator<T> paramToggle) {
    this(paramToggle);
    setDirectionEstimator(directionEstimator);
    setText(label);
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param asHTML
   *          <code>true</code> to treat the specified label as html
   * 
   * @param paramToggle
   *          the material design selector
   */
  public CheckboxBase(final String label, final boolean asHTML,
      final ToggleStyleOperator<T> paramToggle) {
    this(paramToggle);
    if (asHTML) {
      setHTML(label);
    } else {
      setText(label);
    }
  }

  /**
   * 
   * @param elem
   *          the input element
   * 
   * @param paramToggle
   *          the material design selector
   * 
   */
  protected CheckboxBase(final Element elem,
      final ToggleStyleOperator<T> paramToggle) {
    super(Document.get().createLabelElement());

    String uid = Document.get().createUniqueId();

    containerElem = (LabelElement) (Element) getElement();
    containerElem.setHtmlFor(uid);

    inputElem = InputElement.as(elem);
    labelElem = Document.get().createSpanElement();

    getElement().appendChild(inputElem);
    getElement().appendChild(labelElem);

    inputElem.setId(uid);

    directionalTextHelper = new DirectionalTextHelper(labelElem, true);

    // Accessibility: setting tab index to be 0 by default, ensuring element
    // appears in tab sequence. FocusWidget's setElement method already
    // calls setTabIndex, which is overridden below. However, at the time
    // that this call is made, inputElem has not been created. So, we have
    // to call setTabIndex again, once inputElem has been created.
    setTabIndex(0);

    toggle = paramToggle;
    toggle.setTarget(containerElem, inputElem, labelElem);
  }

  @Override
  public final void setRipple(final Ripple inputRipple) {
    toggle.setRipple(inputRipple);
  }

  @Override
  public final Ripple getRipple() {
    return toggle.getRipple();
  }

  @Override
  public HandlerRegistration addValueChangeHandler(
      final ValueChangeHandler<Boolean> handler) {
    // Is this the first value change handler? If so, time to add handlers
    if (!valueChangeHandlerInitialized) {
      ensureDomEventHandlers();
      valueChangeHandlerInitialized = true;
    }
    return addHandler(handler, ValueChangeEvent.getType());
  }

  @Override
  public LeafValueEditor<Boolean> asEditor() {
    if (editor == null) {
      editor = TakesValueEditor.of(this);
    }
    return editor;
  }

  @Override
  public DirectionEstimator getDirectionEstimator() {
    return directionalTextHelper.getDirectionEstimator();
  }

  /**
   * Returns the value property of the input element that backs this widget.
   * This is the value that will be associated with the CheckBox name and
   * submitted to the server if a {@link FormPanel} that holds it is submitted
   * and the box is checked.
   * <p>
   * Don't confuse this with {@link #getValue}, which returns true or false if
   * the widget is checked.
   * 
   * @return the value sent to the server
   */
  public String getFormValue() {
    return inputElem.getValue();
  }

  @Override
  public String getHTML() {
    return directionalTextHelper.getTextOrHtml(true);
  }

  @Override
  public String getName() {
    return inputElem.getName();
  }

  @Override
  public int getTabIndex() {
    return inputElem.getTabIndex();
  }

  @Override
  public String getText() {
    return directionalTextHelper.getTextOrHtml(false);
  }

  @Override
  public Direction getTextDirection() {
    return directionalTextHelper.getTextDirection();
  }

  /**
   * Determines whether this check box is currently checked.
   * <p>
   * Note that this <em>does not</em> return the value property of the checkbox
   * input element wrapped by this widget. For access to that property, see
   * {@link #getFormValue()}
   * 
   * @return <code>true</code> if the check box is checked, false otherwise.
   *         Will not return null
   */
  @Override
  public Boolean getValue() {
    if (isAttached()) {
      return inputElem.isChecked();
    } else {
      return inputElem.isDefaultChecked();
    }
  }

  @Override
  public boolean getWordWrap() {
    return !WhiteSpace.NOWRAP.getCssName()
        .equals(getElement().getStyle().getWhiteSpace());
  }

  /**
   * Determines whether this check box is currently checked.
   * 
   * @return <code>true</code> if the check box is checked
   * @deprecated Use {@link #getValue} instead
   */
  @Deprecated
  public boolean isChecked() {
    // Funny comparison b/c getValue could in theory return null
    return getValue();
  }

  @Override
  public boolean isEnabled() {
    return !inputElem.isDisabled();
  }

  @Override
  public void setAccessKey(final char key) {
    inputElem.setAccessKey("" + key);
  }

  /**
   * Checks or unchecks this check box. Does not fire {@link ValueChangeEvent}.
   * (If you want the event to fire, use {@link #setValue(Boolean, boolean)})
   * 
   * @param checked
   *          <code>true</code> to check the check box.
   * @deprecated Use {@link #setValue(Boolean)} instead
   */
  @Deprecated
  public void setChecked(final boolean checked) {
    setValue(checked);
  }

  /**
   * {@inheritDoc}
   * <p>
   * See note at {@link #setDirectionEstimator(DirectionEstimator)}.
   */
  @Override
  public void setDirectionEstimator(final boolean enabled) {
    directionalTextHelper.setDirectionEstimator(enabled);
  }

  /**
   * {@inheritDoc}
   * <p>
   * Note: DirectionEstimator should be set before the label has any content;
   * it's highly recommended to set it using a constructor. Reason: if the label
   * already has non-empty content, this will update its direction according to
   * the new estimator's result. This may cause flicker, and thus should be
   * avoided.
   */
  @Override
  public void setDirectionEstimator(
      final DirectionEstimator directionEstimator) {
    directionalTextHelper.setDirectionEstimator(directionEstimator);
  }

  @Override
  public void setEnabled(final boolean enabled) {
    inputElem.setDisabled(!enabled);
    if (enabled) {
      removeStyleDependentName("disabled");
    } else {
      addStyleDependentName("disabled");
    }
    toggle.setEnabled(enabled);
  }

  @Override
  public void setFocus(final boolean focused) {
    if (focused) {
      inputElem.focus();
    } else {
      inputElem.blur();
    }
  }

  /**
   * Set the value property on the input element that backs this widget. This is
   * the value that will be associated with the CheckBox's name and submitted to
   * the server if a {@link FormPanel} that holds it is submitted and the box is
   * checked.
   * <p>
   * Don't confuse this with {@link #setValue}, which actually checks and
   * unchecks the box.
   * 
   * @param value
   *          the value transmitted to the server
   */
  public void setFormValue(final String value) {
    inputElem.setAttribute("value", value);
  }

  @Override
  public void setHTML(final SafeHtml html, final Direction dir) {
    directionalTextHelper.setTextOrHtml(html.asString(), dir, true);
  }

  @Override
  public void setHTML(final String html) {
    directionalTextHelper.setTextOrHtml(html, true);
  }

  @Override
  public void setName(final String name) {
    inputElem.setName(name);
  }

  @Override
  public void setTabIndex(final int index) {
    // Need to guard against call to setTabIndex before inputElem is
    // initialized. This happens because FocusWidget's (a superclass of
    // CheckBox) setElement method calls setTabIndex before inputElem is
    // initialized. See CheckBox's protected constructor for more information.
    if (inputElem != null) {
      inputElem.setTabIndex(index);
    }
  }

  @Override
  public void setText(final String text) {
    directionalTextHelper.setTextOrHtml(text, false);
  }

  @Override
  public void setText(final String text, final Direction dir) {
    directionalTextHelper.setTextOrHtml(text, dir, false);
  }

  /**
   * Checks or unchecks the check box.
   * <p>
   * Note that this <em>does not</em> set the value property of the checkbox
   * input element wrapped by this widget. For access to that property, see
   * {@link #setFormValue(String)}
   * 
   * @param value
   *          true to check, false to uncheck; null value implies false
   */
  @Override
  public void setValue(final Boolean value) {
    setValue(value, false);
  }

  /**
   * Checks or unchecks the check box, firing {@link ValueChangeEvent} if
   * appropriate.
   * <p>
   * Note that this <em>does not</em> set the value property of the checkbox
   * input element wrapped by this widget. For access to that property, see
   * {@link #setFormValue(String)}
   * 
   * @param value
   *          true to check, false to uncheck; null value implies false
   * @param fireEvents
   *          If true, and value has changed, fire a {@link ValueChangeEvent}
   */
  @Override
  public void setValue(final Boolean value, final boolean fireEvents) {

    Boolean newValue = value == null ? Boolean.FALSE : value;

    toggle.setValue(newValue);

    Boolean oldValue = getValue();
    inputElem.setChecked(newValue);
    inputElem.setDefaultChecked(newValue);

    if (newValue.equals(oldValue)) {
      return;
    }
    if (fireEvents) {
      ValueChangeEvent.fire(this, newValue);
    }
  }

  @Override
  public void setWordWrap(final boolean wrap) {
    getElement().getStyle()
        .setWhiteSpace(wrap ? WhiteSpace.NORMAL : WhiteSpace.NOWRAP);
  }

  @Override
  public void upgrade() {
    toggle.upgrade();
  }

  @Override
  public boolean isUpgraded() {
    return toggle.isUpgraded();
  }

  /**
   * 
   */
  protected void ensureDomEventHandlers() {

    addDomHandler(new ChangeHandler() {

      @Override
      public void onChange(final ChangeEvent event) {
        ValueChangeEvent.fire(CheckboxBase.this, getValue());
      }
    }, ChangeEvent.getType());
  }

  /**
   * <b>Affected Elements:</b>
   * <ul>
   * <li>-label = label next to checkbox.</li>
   * </ul>
   * 
   * @see UIObject#onEnsureDebugId(String)
   */
  @Override
  protected void onEnsureDebugId(final String baseID) {
    super.onEnsureDebugId(baseID);
    ensureDebugId(labelElem, baseID, "label");
    ensureDebugId(inputElem, baseID, "input");
    containerElem.setHtmlFor(inputElem.getId());
  }

  /**
   * This method is called when a widget is attached to the browser's document.
   * onAttach needs special handling for the CheckBox case. Must still call
   * {@link Widget#onAttach()} to preserve the <code>onAttach</code> contract.
   */
  @Override
  protected void onLoad() {
    DOM.setEventListener(inputElem, this);

    upgrade();
  }

  /**
   * This method is called when a widget is detached from the browser's
   * document. Overridden because of IE bug that throws away checked state and
   * in order to clear the event listener off of the <code>inputElem</code>.
   */
  @Override
  protected void onUnload() {
    // Clear out the inputElem's event listener (breaking the circular
    // reference between it and the widget).
    DOM.setEventListener(inputElem, null);
    setValue(getValue());
  }

  /**
   * Replace the current input element with a new one. Preserves all state
   * except for the name property, for nasty reasons related to radio button
   * grouping. (See implementation of {@link RadioButton#setName}.)
   * 
   * @param elem
   *          the new input element
   */
  protected void replaceInputElement(final Element elem) {
    replaceInputElement(DOM.asOld(elem));
  }

  /**
   * @deprecated Call and use {@link CheckboxBase#replaceInputElement(Element)}
   *             instead.
   * 
   * @param elem
   *          the new element that will replace the current element
   */
  @Deprecated
  protected void replaceInputElement(
      final com.google.gwt.user.client.Element elem) {
    InputElement newInputElem = InputElement.as(elem);
    // Collect information we need to set
    int tabIndex = getTabIndex();
    boolean checked = getValue();
    boolean enabled = isEnabled();
    String formValue = getFormValue();
    String uid = inputElem.getId();
    String accessKey = inputElem.getAccessKey();
    int sunkEvents = Event.getEventsSunk(inputElem);

    // Clear out the old input element
    DOM.setEventListener(inputElem, null);

    getElement().replaceChild(newInputElem, inputElem);

    // Sink events on the new element
    Event.sinkEvents(elem, Event.getEventsSunk(inputElem));
    Event.sinkEvents(inputElem, 0);
    inputElem = newInputElem;

    // Setup the new element
    Event.sinkEvents(inputElem, sunkEvents);
    inputElem.setId(uid);
    if (!"".equals(accessKey)) {
      inputElem.setAccessKey(accessKey);
    }
    setTabIndex(tabIndex);
    setValue(checked);
    setEnabled(enabled);
    setFormValue(formValue);

    // Set the event listener
    if (isAttached()) {
      DOM.setEventListener(inputElem, this);
    }
  }

  /**
   * 
   * @return retrieve the flavor switch manager
   */
  protected ToggleStyleOperator<T> getToggle() {
    return toggle;
  }

  /**
   * @return the top level container element
   */
  protected LabelElement getContainer() {
    return containerElem;
  }

  /**
   * @return the toggle input element
   */
  protected InputElement getInput() {
    return inputElem;
  }

  /**
   * @return the label element
   */
  protected SpanElement getLabel() {
    return labelElem;
  }

  /**
   * Support for bidirectional strings.
   */
  private final DirectionalTextHelper directionalTextHelper;

  /**
   * the top level container element.
   */
  private LabelElement containerElem;

  /**
   * the input element.
   */
  private InputElement inputElem;

  /**
   * the label element to be displayed next to the input.
   */
  private SpanElement labelElem;

  /**
   * Stores a boolean value editor.
   */
  private LeafValueEditor<Boolean> editor;

  /**
   * Set to <code>true</code> when the change handler is initialized.
   */
  private boolean valueChangeHandlerInitialized;

  /**
   * Responsible for the material layer on top of the check box.
   */
  private ToggleStyleOperator<T> toggle;
}
