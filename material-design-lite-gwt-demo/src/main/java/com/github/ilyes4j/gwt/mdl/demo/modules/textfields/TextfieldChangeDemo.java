package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextField;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for the textfield value change event. */
public class TextfieldChangeDemo implements EntryPoint {

  /** Update the label when the textfield content changes. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("changeContainer");
    String label = "Type some text then leave the textfield";
    final TextField txtfld = new TextField(label);
    txtfld.setFloat(Float.FLOAT);
    root.add(txtfld);

    final InlineLabel lbl = new InlineLabel();
    root.add(lbl);

    txtfld.addValueChangeHandler(new ValueChangeHandler<String>() {
      @Override
      public void onValueChange(final ValueChangeEvent<String> event) {
        if (event.getSource() == txtfld) {
          lbl.setText(txtfld.getText());
        }
      }
    });
  }
}
