package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextField;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for filtering typed characters. */
public class TextfieldKeyPressDemo implements EntryPoint {

  /** When the keyboard is pressed filter undesired keys. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("keypressContainer");

    String label = "Only 0s and 1s are accepted";
    final TextField txtfld = new TextField(label);
    txtfld.setFloat(Float.FLOAT);
    root.add(txtfld);

    txtfld.addKeyPressHandler(new KeyPressHandler() {

      @Override
      public void onKeyPress(final KeyPressEvent event) {

        if (event.getSource() == txtfld) {

          final int zero = 48;
          final int one = 49;
          int value = event.getCharCode();

          if (value != zero && value != one) {
            txtfld.cancelKey();
          }
        }
      }
    });
  }
}
