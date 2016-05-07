package com.github.ilyes4j.gwt.mdl.components.sliders;

import com.google.gwt.event.dom.client.DomEvent;

/**
 * Represents a native input event.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class InputEvent extends DomEvent<InputHandler> {

  /**
   * The input event name.
   */
  private static final String INPUT = "input";

  /**
   * Event type for input events. Represents the meta-data associated with this
   * event.
   */
  private static final Type<InputHandler> TYPE = new Type<InputHandler>(INPUT,
      new InputEvent());

  /**
   * Gets the event type associated with input events.
   * 
   * @return the handler type
   */
  public static Type<InputHandler> getType() {
    return TYPE;
  }

  /**
   * Protected constructor, use
   * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
   * to fire input events.
   */
  protected InputEvent() {
  }

  @Override
  public final Type<InputHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(final InputHandler handler) {
    handler.onInput(this);
  }

}
