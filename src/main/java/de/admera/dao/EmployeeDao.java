package de.admera.dao;

import java.util.List;

import de.admera.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();
}
