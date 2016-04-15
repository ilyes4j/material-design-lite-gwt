package com.github.ilyes4j.gwt.mdl.components.tooltips;

import static com.github.ilyes4j.gwt.mdl.components.ComponentHandler.upgradeElement;
import static com.github.ilyes4j.gwt.mdl.components.tooltips.TooltipPosition.BOTTOM;
import static com.github.ilyes4j.gwt.mdl.components.tooltips.TooltipStyle.DEFAULT;

import com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * A material design tooltip.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class Tooltip extends PopupPanel
    implements MouseOverHandler, MouseOutHandler, MouseDownHandler {

  /**
   * Setup a tooltip instance with all options to be indicated.
   * 
   * @param widget
   *          the target element for which the tooltip is displayed
   * 
   * @param text
   *          the content of the tooltip
   * 
   * @param paramPosition
   *          the anchoring option of the tooltip
   * 
   * @param paramStyle
   *          the font size of the tooltip
   */
  public Tooltip(final Widget widget, final String text,
      final TooltipPosition paramPosition, final TooltipStyle paramStyle) {
    super(false);

    setStyleName(MDL_TOOLTIP);
    setText(text);

    style = new TooltipStyleSwitcher();
    style.setTarget(getElement());
    style.setValue(paramStyle);

    position = new TooltipPositionSwitcher();
    position.setTarget(getElement());
    position.setValue(paramPosition);

    addStyleName(position.toString());

    setTarget(widget);

    // set the tooltip as enabled by default
    setEnabledRaw(true);
  }

  /**
   * Setup a tooltip instance with a standard font size.
   * 
   * @param widget
   *          the target element for which the tooltip is displayed
   * 
   * @param text
   *          the content of the tooltip
   * 
   * @param paramPosition
   *          the anchoring option of the tooltip
   */
  public Tooltip(final Widget widget, final String text,
      final TooltipPosition paramPosition) {
    this(widget, text, paramPosition, DEFAULT);
  }

  /**
   * Setup a tooltip instance below its target and with a standard font size.
   * 
   * @param widget
   *          the target element for which the tooltip is displayed
   * 
   * @param text
   *          the content of the tooltip
   */
  public Tooltip(final Widget widget, final String text) {
    this(widget, text, BOTTOM);
  }

  /**
   * Set the text to be displayed inside the tooltip.
   * 
   * @param text
   *          the text to be displayed inside the tooltip
   */
  public void setText(final String text) {
    setWidget(new HTML(text));
  }

  @Override
  public final void onMouseOut(final MouseOutEvent event) {
    hide();
  }

  @Override
  public final void onMouseOver(final MouseOverEvent event) {
    show();
  }

  @Override
  public final void onMouseDown(final MouseDownEvent event) {
    if (hideOnClick) {
      hide();
    }
  }

  /**
   * 
   * @return whether the tooltip needs to be hidden when the mouse is pushed
   */
  public boolean isHideOnClick() {
    return hideOnClick;
  }

  /**
   * 
   * @param paramHideOnClick
   *          determines if the tooltip needs to be hidden when the mouse is
   *          pushed
   */
  public void setHideOnClick(final boolean paramHideOnClick) {
    this.hideOnClick = paramHideOnClick;
  }

  /**
   * Determines if the tooltip is active or not. If enabled, the tooltip will
   * show up next time the mouse is over the target element.
   * 
   * @param inputEnabled
   *          determine if the tooltip will show up when the mouse is over the
   *          target
   */
  public void setEnabled(final boolean inputEnabled) {

    // don't do anything if the state to be set is identical to the previous
    // state
    if (enabled == inputEnabled) {
      return;
    }

    // safely flip the enabled state
    setEnabledRaw(inputEnabled);
  }

  /**
   * Utility method used to set the enabled state regardless of the previous
   * state, used internally by {@link Tooltip#setEnabled(boolean)} and at the
   * initialization stage.
   * 
   * @param inputEnabled
   *          determine if the tooltip will show up when the mouse is over the
   *          target
   */
  private void setEnabledRaw(final boolean inputEnabled) {

    // apply the requested state
    enabled = inputEnabled;

    // if the requested state is positive activate listeners, otherwise remove
    // them
    if (enabled) {
      enableHanders();
    } else {
      disableHanders();
    }
  }

  /**
   * The tooltip needs to know when to show up and when to hide. By attaching
   * event handlers on the tooltip target, it is possible to track the mouse
   * position and therefore decide when to show and hide the tooltip.
   */
  private void enableHanders() {
    mouseOverReg = target.addDomHandler(this, MouseOverEvent.getType());
    mouseOutReg = target.addDomHandler(this, MouseOutEvent.getType());
    mouseDownReg = target.addDomHandler(this, MouseDownEvent.getType());
  }

  /**
   * Disable the event listeners.
   */
  private void disableHanders() {
    mouseOverReg.removeHandler();
    mouseOutReg.removeHandler();
    mouseDownReg.removeHandler();
  }

  /**
   * Set the target of the tooltip.
   * 
   * @param paramTarget
   *          the target of the tooltip
   */
  public void setTarget(final Widget paramTarget) {

    if (paramTarget == null) {
      return;
    }

    target = paramTarget;
    Element targetElem = target.getElement();

    if (targetElem == null) {
      return;
    }

    MdlGwtUtils.insureId(targetElem);

    MdlGwtUtils.setFor(getElement(), targetElem.getId());
  }

  @Override
  public void onLoad() {
    super.onLoad();

    upgradeElement(getElement());
  }

  /**
   * Empty class name proof style adding method.
   * 
   * @param styleName
   *          the class name to be added on the component
   */
  public void addStyleName(final String styleName) {
    if (styleName == null || styleName.isEmpty()) {
      return;
    }
    super.addStyleName(styleName);
  }

  /**
   * Will the tooltip fire on the next mouse over ?
   */
  private boolean enabled = true;

  /**
   * Does the tooltip needs to be hidden if the mouse is pushed ?
   */
  private boolean hideOnClick;

  /**
   * The target element on which the tooltip is applied.
   */
  private Widget target;

  /**
   * A registration for the mouse over handler.
   */
  private HandlerRegistration mouseOverReg;

  /**
   * A registration for the mouse out handler.
   */
  private HandlerRegistration mouseOutReg;

  /**
   * A registration for the mouse down handler.
   */
  private HandlerRegistration mouseDownReg;

  /**
   * CSS class switcher for the tooltip style.
   */
  private TooltipStyleSwitcher style;

  /**
   * CSS class switcher for the tooltip anchoring.
   */
  private TooltipPositionSwitcher position;

  /**
   * The main css class for material tooltips.
   */
  private static final String MDL_TOOLTIP = "mdl-tooltip";
}
