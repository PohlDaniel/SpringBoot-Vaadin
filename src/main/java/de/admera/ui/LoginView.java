package de.admera.ui;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.admera.ui.components.PasswordFieldC;

@Route(value = LoginView.ROUTE)
@PageTitle("Login")
//${basedir}/src/main/webapp/frontend/css
//will be imported as a <custom-style> tag
@StyleSheet("css/login.css")

//${basedir}/frontend/css
//First approach for importing <dom-module>
//@CssImport(value = "./css/SharedStyle.css")
@CssImport(value = "./css/login-field.css", themeFor = "vaadin-text-field")

//${basedir}/frontend/themes
//Second approach for importing <dom-module>
@JsModule("./themes/login-button-theme.js")

//${basedir}/src/main/webapp/frontend/styles
//dom-module styles for debug mode
/**@HtmlImport("styles/loginStyles.html")*/
public class LoginView extends HorizontalLayout{

	private static final long serialVersionUID = 1429920278151876232L;
	
	public static final String ROUTE = "login";
	
	@Autowired
	public LoginView(AuthenticationManager authenticationManager) {
		
		super();
		UI.getCurrent().getElement().setAttribute("theme", "");
		FormLayout loginForm = loginForm(authenticationManager);
		loginForm.setWidth("250px");
		loginForm.addClassName("login-form");
		
	    // widgets
        this.add(loginForm);

        // arrange
        this.setSizeFull();

        this.setVerticalComponentAlignment(Alignment.CENTER, loginForm);
        this.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER); // Put content in the middle horizontally.
        
        //background
        this.addClassName("login-background");
	}

	
	private FormLayout loginForm(AuthenticationManager authenticationManager) {
		
		FormLayout form = new FormLayout();

	    TextField username = new TextField();
	    username.setLabel("Username");
	    username.setPlaceholder("username");
	    username.setValue("user");
	    
	    username.addClassName("static-prop");
	    username.addClassName("after");
	    username.addClassName("on-mouse-over");
	    username.addClassName("on-mouse-over-nfocused");
	    
	    username.addFocusListener( e-> {username.addClassName("on-focus");
	    							
	    								username.removeClassName("on-mouse-over");	    								
	    								});
	    
	    username.addBlurListener(e-> {username.removeClassName("on-focus");
	    							  username.addClassName("on-mouse-over");	    							  
	    							  });
	 

	    Button loginButton = new Button("Log in");
	    loginButton.addClassName("login-button");
	    
	    Button adminButton = new Button("Admin");
	    adminButton.addClassName("login-button");
	    
	   
        
	    PasswordFieldC passwordFieldC = new PasswordFieldC("user");
	    
	    
	    form.add(username, passwordFieldC, loginButton, adminButton);

	    loginButton.addClickListener(e -> {
				try {
					// try to authenticate with given credentials, should always return !null or throw an {@link AuthenticationException}
					final Authentication authentication = authenticationManager
							.authenticate(new UsernamePasswordAuthenticationToken(username.getValue(), passwordFieldC.getValue()));

					// if authentication was successful we will update the security context and redirect to the page requested first
					if(authentication != null ) {
		
						SecurityContextHolder.getContext().setAuthentication(authentication);
		
						
						Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
						String redirectUrl = "login";
						
						if(authorities.contains(new SimpleGrantedAuthority("ROLE_Admin"))){
							
							redirectUrl = "admin";
							
						}else if(authorities.contains(new SimpleGrantedAuthority("ROLE_User"))) {
							
							redirectUrl = "user";
							
						}
						UI.getCurrent().navigate(redirectUrl);
					}

				} catch (AuthenticationException ex) {
					
					// show default error message
					// Note: You should not expose any detailed information here like "username is known but password is wrong"
					// as it weakens security.
					Notification.show("Log in failed");
				}
			});
	    
	    
	    adminButton.addClickListener(e -> {
			try {
				// try to authenticate with given credentials, should always return !null or throw an {@link AuthenticationException}
				final Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken("admin", "admin"));

				// if authentication was successful we will update the security context and redirect to the page requested first
				if(authentication != null ) {
	
					SecurityContextHolder.getContext().setAuthentication(authentication);
	
					
					Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
					String redirectUrl = "login";
					
					if(authorities.contains(new SimpleGrantedAuthority("ROLE_Admin"))){
						
						redirectUrl = "admin";
						
					}else if(authorities.contains(new SimpleGrantedAuthority("ROLE_User"))) {
						
						redirectUrl = "user";
						
					}
					//UI.getCurrent().getPage().reload();
					UI.getCurrent().navigate(redirectUrl);
				}

			} catch (AuthenticationException ex) {
				
				// show default error message
				// Note: You should not expose any detailed information here like "username is known but password is wrong"
				// as it weakens security.
				Notification.show("Log in failed");
			}
		});
    
	    
	    return form;
	}
	
}


