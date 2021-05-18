package de.admera.ui.components;

import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * Model for the passwordTemplate.
 */
public interface PasswordFieldCModel extends TemplateModel {
    
    String getClassName();
    void setClassName(String classes);
    
    String getUserInput();
    void setUserInput(String input);
}

