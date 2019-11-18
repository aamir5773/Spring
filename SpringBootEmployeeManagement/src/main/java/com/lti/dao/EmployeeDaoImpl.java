package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lti.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager entityManager;

	public EmployeeDaoImpl() {
		//entityManager = JpaUtils.getEntityManager(); Now the object will be created by Spring framework
	}

	
	public int createEmployee(Employee employee) {
		entityManager.persist(employee);
		return 1;
	}

	
	public List<Employee> readAllEmployees() {
		String jpql = "From Employee";
		TypedQuery<Employee> tquery = entityManager.createQuery(jpql, Employee.class);
		List<Employee> list = tquery.getResultList();
		return list;
	}

	
	public int deleteEmployee(int employeeId) {
		Query query = entityManager.createNamedQuery("DELETE_BY_EMPID");
		query.setParameter("eid", employeeId);
		int result = query.executeUpdate();
		return result;
	}

	
	public Employee updateEmployee(Employee employee) {
		return entityManager.merge(employee);
	}


	public Employee readEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

}
