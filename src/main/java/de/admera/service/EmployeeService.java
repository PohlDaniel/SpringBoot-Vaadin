package de.admera.service;

import java.util.List;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.admera.entity.Employee;

@UIScope
@SpringComponent
public interface EmployeeService {

    List<Employee> findAll();	 

}
