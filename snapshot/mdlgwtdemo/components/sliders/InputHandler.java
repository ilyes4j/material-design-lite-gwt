package com.github.ilyes4j.gwt.mdl.components.sliders;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for {@link InputEvent} events.
 */
public interface InputHandler extends EventHandler {

  /**
   * Called when an input event is fired.
   * 
   * @param event
   *          the {@link InputEvent} that was fired
   */
  void onInput(InputEvent event);
}
