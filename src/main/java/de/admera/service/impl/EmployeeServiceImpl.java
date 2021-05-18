package de.admera.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.admera.repository.EmployeeRepository;
import de.admera.entity.Employee;
import de.admera.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		 
		return this.employeeRepository.findAll();
	}
}
