package com.lti.ui;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.model.Employee;
import com.lti.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Employee employee = context.getBean("employee2", Employee.class);
		//Employee employee = (Employee) context.getBean("employee");  another way of writing the above line
		
		EmployeeService  service = context.getBean("service", EmployeeService.class);
		boolean result = service.addEmployee(employee);
		if(result){
			System.out.println("Employee added successfully in in- memory database");
		}
		else{
			System.out.println("Employee not added");
		}
		List<Employee> list = service.findAllEmployees();
		System.out.println(list);

	}

}
