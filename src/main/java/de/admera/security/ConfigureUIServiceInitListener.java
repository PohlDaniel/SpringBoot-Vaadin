package de.admera.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

import de.admera.ui.LoginView;
import de.admera.ui.pages.UserPage;

import org.springframework.stereotype.Component;


@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

	private static final long serialVersionUID = 2094506333136936459L;

	@Override
	public void serviceInit(ServiceInitEvent event) {
		event.getSource().addUIInitListener(uiEvent -> {
			final UI ui = uiEvent.getUI();
			ui.addBeforeEnterListener(this::beforeEnter);
		});
	}

	/**
	 * Reroutes the user if (s)he is not authorized to access the view.
	 *
	 * @param event
	 *            before navigation event with event details
	 */
	private void beforeEnter(BeforeEnterEvent event) {
	
		if (!SecurityUtils.isAccessGranted(event.getNavigationTarget())) {
			
			if(SecurityUtils.isUserLoggedIn()) {			
				//event.rerouteTo(UserPage.class);
				event.forwardTo(UserPage.class);
			}else {
				//event.rerouteTo(LoginView.class);
				event.forwardTo(LoginView.class);
			}
		} 
	}
}