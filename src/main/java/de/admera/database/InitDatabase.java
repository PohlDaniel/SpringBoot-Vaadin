package de.admera.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import de.admera.entity.Employee;
import de.admera.entity.builder.EmployeeBuilder;
import de.admera.repository.EmployeeRepository;

@Configuration
public class InitDatabase {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void init() {
		Employee employee1 = new EmployeeBuilder().firstName("Anna").lastName("Doe").email("test@test.de").build();
		Employee employee2 = new EmployeeBuilder().firstName("Paul").lastName("Schreiber").email("test@test.de").build();
		
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
	}
}
