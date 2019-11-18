package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.EmployeeDao;
import com.lti.model.Employee;
@Service("service")
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeDao dao;// = new EmployeeDaoImpl();
	
	@Override
	public boolean addEmployee(Employee employee) {
		int result = getDao().createEmployee(employee);
		if(result == 1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> list = getDao().readAllEmployees();
		return list;
	}
	@Override
	public boolean removeEmployee(int employeeId) {
		int result = getDao().deleteEmployee(employeeId);
		if(result == 1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public Employee modifyEmployee(Employee employee) {
		Employee employee2 = getDao().updateEmployee(employee);
		return employee2;
	}
	public EmployeeDao getDao() {
		return dao;
	}
	public void setDao(EmployeeDao dao) {
		System.out.println("setDao");
		this.dao = dao;
	}
}
