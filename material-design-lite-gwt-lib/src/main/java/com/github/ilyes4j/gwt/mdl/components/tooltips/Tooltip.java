package com.github.ilyes4j.gwt.mdl.components.tooltips;

import static com.github.ilyes4j.gwt.mdl.components.tooltips.TooltipPosition.BOTTOM;
import static com.github.ilyes4j.gwt.mdl.components.tooltips.TooltipStyle.DEFAULT;

import com.github.ilyes4j.gwt.mdl.components.ComponentHandler;
import com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A material design tooltip.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class Tooltip extends FlowPanel
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

    setStyleName(MDL_TOOLTIP);
    setText(text);

    style = new TooltipStyleSwitcher();
    style.setTarget(getElement());
    style.setValue(paramStyle);

    position = new TooltipPositionSwitcher();
    position.setTarget(getElement());
    position.setValue(paramPosition);

    setTarget(widget);

    // setup listeners
    enableHanders();

    // make the tooltip enabled by default
    enabled = true;
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
    getElement().setInnerHTML(text);
  }

  @Override
  public final void onMouseOut(final MouseOutEvent event) {
    hide();
  }

  @Override
  public final void onMouseOver(final MouseOverEvent event) {
    if (enabled) {
      show();
    }
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
   * Control whether the tooltip should be displayed. If the input value is
   * <code>true</code>, the tooltip will show up next time the mouse is over the
   * target element. If the tooltip is showing then it will be hidden
   * immediately.
   * 
   * @param inputEnabled
   *          controls whether the tooltip will show up when the mouse is over
   *          the target
   */
  public void setEnabled(final boolean inputEnabled) {

    // apply the requested state
    enabled = inputEnabled;

    if (!enabled && isAttached()) {
      hide();
    }
  }

  /**
   * The tooltip needs to know when to show up and when to hide. By attaching
   * event handlers on the tooltip target, it is possible to track the mouse
   * position and therefore decide when to show and hide the tooltip.
   */
  private void enableHanders() {
    target.addDomHandler(this, MouseOverEvent.getType());
    target.addDomHandler(this, MouseOutEvent.getType());
    target.addDomHandler(this, MouseDownEvent.getType());
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

    ComponentHandler.upgradeElement(getElement());
  }

  /**
   * attach the panel to its parent.
   */
  public void show() {
    RootPanel.get().add(this);
  }

  /**
   * remove the panel from its parent.
   */
  public void hide() {
    removeFromParent();
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
