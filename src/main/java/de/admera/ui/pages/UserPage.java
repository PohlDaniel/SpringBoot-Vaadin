package de.admera.ui.pages;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import de.admera.entity.Employee;
import de.admera.service.EmployeeService;
import de.admera.ui.MessageBean;
import de.admera.ui.MainView;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;

@Route(value ="user", layout = MainView.class)
@Secured("ROLE_User")
public class UserPage extends VerticalLayout {

	
	private static final long serialVersionUID = 506876206613035288L;
	
	private EmployeeService employeeService;

    private Grid<Employee> gridEmployee = new Grid<Employee>(Employee.class);
    private TextField filterText = new TextField();
	
    public UserPage(@Autowired MessageBean bean, @Autowired EmployeeService employseeService) {
        Button button = new Button("Click me",
                e -> Notification.show(bean.getMessage()));
        add(button);


        Element logoutLink = ElementFactory.createAnchor("/login", "Logout");
        logoutLink.addEventListener("click", e -> {

			SecurityContextHolder.clearContext();
			UI.getCurrent().getSession().close();
			 		
		});
        getElement().appendChild(logoutLink);
        
    	this.employeeService = employseeService;
    	
        filterText.setPlaceholder("Filter by First Name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateEmployees());

        Button addCustomerBtn = new Button("Add new");

        HorizontalLayout toolbar = new HorizontalLayout(filterText,
                addCustomerBtn);

        gridEmployee.setColumns("firstName", "lastName", "email");
        
        HorizontalLayout employees = new HorizontalLayout(gridEmployee);
        employees.setSizeFull();
        gridEmployee.setSizeFull();
        
        
        add(toolbar, employees);
        setSizeFull();

        updateEmployees();       
    }
    
    public void updateEmployees() {
    	
    	gridEmployee.setItems(employeeService.findAll());
    }

}
