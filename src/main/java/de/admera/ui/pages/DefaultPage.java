package de.admera.ui.pages;

import javax.servlet.http.HttpServletResponse;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.Location;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.router.ParentLayout;

import de.admera.ui.MainView;

@ParentLayout(MainView.class)
public class DefaultPage extends VerticalLayout implements HasErrorParameter<NotFoundException>{

	private static final long serialVersionUID = 4398962129866783944L;

	public DefaultPage() {
		Label title = new Label();
		
		title.setTitle("Welcome to Default Page");
		title.setText("To replace this page: UI.getCurrent().getNavigator().setErrorView(<your class>.class);");
		
		add(title);
	}

	@Override
	public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
		UI.getCurrent().getPage().getHistory().pushState(null, new Location(""));
		return HttpServletResponse.SC_NOT_FOUND;
	}
	
}
