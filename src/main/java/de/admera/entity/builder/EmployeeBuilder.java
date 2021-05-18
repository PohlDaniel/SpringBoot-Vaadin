package de.admera.entity.builder;

import org.apache.commons.lang3.builder.Builder;

import de.admera.entity.Employee;

public class EmployeeBuilder implements Builder<Employee>{

	private Employee employee;
	
	public EmployeeBuilder() {
		this.employee = new Employee();
	}
	
	public EmployeeBuilder id(Long id) {
		this.employee.setId(id);
		return this;
	}
	
	public EmployeeBuilder firstName(String firstName) {
		this.employee.setFirstName(firstName);
		return this;
	}
	
	public EmployeeBuilder lastName(String lastName) {
		this.employee.setLastName(lastName);
		return this;
	}
	
	public EmployeeBuilder email(String email) {
		this.employee.setEmail(email);
		return this;
	}
	
	@Override
	public Employee build() {
	     return employee;
	}
}
