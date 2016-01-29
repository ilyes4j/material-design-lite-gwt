package org.zerowarning.gwt.mdl.exts.components.menu;

import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonRipple.RIPPLE;

import org.zerowarning.gwt.mdl.components.buttons.Button;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SelectBox extends Composite {

	public SelectBox() {

		FlowPanel panel = new FlowPanel();
		panel.setStylePrimaryName("gwt-mdl-selectbox-container");

		btn = createRaised(BTN_NO_COLOR, RIPPLE, "SelectBox");
		panel.add(btn);
		btn.addDomHandler(new ButtonClickHandler(), ClickEvent.getType());

		menu = new FlowPanel();
		menu.setStylePrimaryName("mdl-menu__container");

		outline = new FlowPanel();
		outline.setStylePrimaryName("mdl-menu__outline");
		menu.add(outline);

		content = new Label("Under construction");
		content.setStyleName("selectbox-menu_content");
		menu.add(content);

		initWidget(panel);
	}

	private class ButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			isClickSelf = true;
			RootPanel.get(null).add(menu);
			menu.addStyleName("is-visible");
			outline.setWidth(content.getOffsetWidth() + "px");
			outline.setHeight(content.getOffsetHeight() + "px");

			StringBuilder sb = new StringBuilder();
			sb.append("left: ");
			sb.append(btn.getAbsoluteLeft());
			sb.append("px; ");
			sb.append("top: ");
			sb.append(btn.getAbsoluteTop());
			sb.append("px;");
			menu.getElement().setAttribute("style", sb.toString());

			RootPanel.get(null).addDomHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					if (!isClickSelf && menu.isAttached()) {
						int index = RootPanel.get().getWidgetIndex(menu);
						RootPanel.get().remove(index);
					}

					isClickSelf = false;
				}
			}, ClickEvent.getType());
		}
	}

	private Button btn;

	private FlowPanel menu;

	private FlowPanel outline;

	private boolean isClickSelf;

	private Label content;
}
