package de.admera.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.admera.entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

	List<Employee> findAll();

}
