package de.admera.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.admera.dao.EmployeeDao;
import de.admera.entity.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl implements  EmployeeDao{

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {		
		List<Employee> employees = null;

		String hql = "FROM Employee as e ORDER BY e.id";
		employees = (List<Employee>) entityManager.createQuery(hql).getResultList();

		return employees;
	}
}

