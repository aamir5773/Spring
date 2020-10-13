package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.lti.dao.EmployeeDao;
import com.lti.model.Employee;

public class EmployeeServiceImpl implements EmployeeService, InitializingBean,DisposableBean {

	private EmployeeDao dao;

	public EmployeeServiceImpl() {
		System.out.println("Employee object is created");
		}
	
	public boolean addEmployee(Employee employee) {
		return dao.createEmployee(employee);
	}
	public EmployeeDao getDao() {
		return dao;
	}
	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Employee> findAllEmployees() {
		return dao.readAllEmployees();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroyed");	
	}
	

}