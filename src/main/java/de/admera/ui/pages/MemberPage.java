package de.admera.ui.pages;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.admera.ui.MainView;

@Route(value ="member", layout = MainView.class)
@Secured("ROLE_User")
public class MemberPage extends VerticalLayout {


	private static final long serialVersionUID = 5673635384347399160L;

	public MemberPage() {
		Label title = new Label();
		
		title.setTitle("Member");
		title.setText("Member view");
		
		add(title);
	}

}
