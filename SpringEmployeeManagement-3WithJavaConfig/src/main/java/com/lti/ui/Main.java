package com.lti.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.config.AppConfig;
import com.lti.model.Employee;
import com.lti.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService service = context.getBean("service", EmployeeService.class); //service on rhs is same as annotaion name given by uss
		List<Employee> list = service.findAllEmployees();
		for(Employee emp : list){
			System.out.println(emp);
		}
	}
}
