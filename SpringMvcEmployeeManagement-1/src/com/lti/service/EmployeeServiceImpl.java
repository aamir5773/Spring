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
		dao.beginTrnasaction();
		int result = getDao().createEmployee(employee);
		if(result == 1){
			dao.commitTrnasaction();
			return true;
		}else{
			dao.rollbackTrnasaction();
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
		dao.beginTrnasaction();
		int result = getDao().deleteEmployee(employeeId);
		if(result == 1){
			dao.commitTrnasaction();
			return true;
		}else{
			dao.rollbackTrnasaction();
			return false;
		}
	}
	@Override
	public Employee modifyEmployee(Employee employee) {
		dao.beginTrnasaction();
		Employee employee2 = getDao().updateEmployee(employee);
		if(employee2 != null){
			dao.commitTrnasaction();
			return employee2;
		}else{
			dao.rollbackTrnasaction();
			return null;
		}
	}
	
	public EmployeeDao getDao() {
		return dao;
	}
	public void setDao(EmployeeDao dao) {
		System.out.println("setDao");
		this.dao = dao;
	}
}
