package de.admera.ui.pages;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.admera.ui.MainView;

@Route(value ="settings", layout = MainView.class)
@Secured("ROLE_User")
public class SettingsPage extends VerticalLayout {

	private static final long serialVersionUID = 821082783346729262L;

	public SettingsPage() {
		Label title = new Label();
		
		title.setTitle("Settings");
		title.setText("Settings view");
		
		add(title);
	}

}
