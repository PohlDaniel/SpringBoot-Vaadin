package de.admera.ui.pages;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


import de.admera.ui.MainView;

@Route(value ="home", layout = MainView.class)
@Secured("ROLE_User")
public class HomePage extends VerticalLayout {

	private static final long serialVersionUID = 4661658199338660421L;

	public HomePage() {
    	
    
    	
    	add(new H2("Home"), new H5("Home view"));
    }

   
  

}
