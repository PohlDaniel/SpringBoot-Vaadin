package de.admera.ui.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.PasswordField;

@Tag("password-field")
@JsModule("./views/password-field.js")
public class PasswordFieldC extends PolymerTemplate<PasswordFieldCModel> {
  
	private static final long serialVersionUID = 4081747652892844669L;

	public PasswordFieldC() {
    	new PasswordField();
        setId("template"); 
    
        //set the class for the template
        /**getModel().setClassName("");*/      
    }
	
	public PasswordFieldC(String value) {
		new PasswordField();
        setId("template"); 
        getModel().setUserInput(value);
    }
	
    @EventHandler
    private void boldLabelServer() {    	
    	 getElement().callJsFunction("boldLabel");

    }
    
    public String getValue() {    	
    	 return getModel().getUserInput();
    }
}

