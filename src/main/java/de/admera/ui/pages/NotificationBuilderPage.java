package de.admera.ui.pages;

import org.springframework.security.access.annotation.Secured;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import de.admera.ui.MainView;
import de.admera.ui.hybridmenu.components.Notification;
import de.admera.ui.hybridmenu.components.NotificationCenter;
import de.admera.ui.hybridmenu.data.enums.NotificationPosition;

@Route(value ="notificationBuilder", layout = MainView.class)
@Secured("ROLE_User")
public class NotificationBuilderPage extends VerticalLayout {

	private static final long serialVersionUID = -6489745066461500804L;

	public NotificationBuilderPage() {
		add(new H2("Notification Builder"), new H5("Here you can click a notification together"));
		
		HorizontalLayout outputPosition = new HorizontalLayout(new Button("Top", e -> VaadinSession.getCurrent().getAttribute(NotificationCenter.class).setNotificationPosition(NotificationPosition.TOP)), new Button("Bottom", e -> VaadinSession.getCurrent().getAttribute(NotificationCenter.class).setNotificationPosition(NotificationPosition.BOTTOM)));
		
		TextField caption = new TextField("Title");
		TextArea content = new TextArea("Content");
		
		ComboBox<VaadinIcon> icon = new ComboBox<VaadinIcon>("Icon");
		
		icon.setItemLabelGenerator((i) -> i.name());
		icon.setItems(VaadinIcon.values());
		
		Label displayTimeLabel = new Label("Display time (ms)");
		//PaperSliderC displayTime = new PaperSliderC(1000, 10000, 5000);
		
		//displayTimeLabel.getElement().appendChild(displayTime.getElement());
		
		Checkbox closeable = new Checkbox("Closeable");
		Checkbox autoRemove = new Checkbox("Autoremove");
		Checkbox makeAsReaded = new Checkbox("Make as readed");
		Checkbox showDescriptionOnPopup = new Checkbox("Show description on popup");
		
		showDescriptionOnPopup.setValue(true);
		
		Label autoRemoveTimeLabel = new Label("Autoremove display offset delay (ms)");
		//PaperSliderC autoRemoveTime = new PaperSliderC(0, 5000, 0);
		
		//autoRemoveTimeLabel.getElement().appendChild(autoRemoveTime.getElement());
		
		Button execute = new Button("Execute", VaadinIcon.CODE.create());
		
		//execute.setDisableOnClick(true);
		execute.addClickListener(e -> {
			NotificationCenter notificationCenter = VaadinSession.getCurrent().getAttribute(NotificationCenter.class);
			if (notificationCenter.queueSize() < 10) {
				Notification notification = Notification.get()
						.withTitle(caption.getValue())
						.withContent(content.getValue())
						.withIcon(icon.getValue());
				
				if (closeable.getValue()) {
					notification.withCloseable();
				}
				
				if (makeAsReaded.getValue()) {
					notification.makeAsReaded();
				}
				
				
				
				notificationCenter.add(notification, showDescriptionOnPopup.getValue());
			}
		});
		
		add(outputPosition, caption, content, icon, displayTimeLabel, closeable, makeAsReaded, autoRemove, showDescriptionOnPopup, autoRemoveTimeLabel, execute);
    }

   
  

}