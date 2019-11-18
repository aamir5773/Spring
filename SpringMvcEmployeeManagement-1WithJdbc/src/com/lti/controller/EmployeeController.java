package com.lti.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.model.Employee;
import com.lti.service.EmployeeService;
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private Employee employee;
	
	@RequestMapping("/")
	public String homePage(){
		return "Home";
	}
	@RequestMapping(path="addEmployeePage")
	public String addEmployeePage(){
		
		return "AddEmployee";
	}
	
	@RequestMapping(path="addEmployee.do", method=RequestMethod.POST)
	//@RequsetParam is equivalent to requset.getParameter
	public String addEmployee(@RequestParam("employeeName") String name, @RequestParam("employeeSalary") double salary){
		//Employee employee = new Employee(); ref created above
		employee.setEmployeeName(name);
		employee.setEmployeeSalary(salary);
		
		boolean result = service.addEmployee(employee);
		if(result){
			return "redirect:viewEmployee.do";
		}else{
			return "Error";
		}
	}
	
	@RequestMapping(path="viewEmployee.do", method=RequestMethod.GET)
	public String viewEmployee(Model model){
		List<Employee> list = service.findAllEmployees();
		model.addAttribute("employeeList", list);
		return "ViewEmployee";
	}
	
	
	
	@RequestMapping(path="deleteEmployee.do", method=RequestMethod.GET)
	public String deleteEmployee(@PathParam("employeeId") int employeeId){
		boolean result = service.removeEmployee(employeeId);
		if(result){
			return "redirect:viewEmployee.do";
		}
		return "Error";
	}
	@RequestMapping(path="updateEmployeePage", method=RequestMethod.GET)
	public String updateEmployeePage(){
		return "UpdateEmployee";
	}
	@RequestMapping(path="updateEmployee.do", method=RequestMethod.POST)
	public String updateEmployee(@RequestParam("employeeId") int id, @RequestParam("employeeName") String name, 
			@RequestParam("employeeSalary") double salary){
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		employee.setEmployeeSalary(salary);
		
		Employee result = service.modifyEmployee(employee);
		if(result != null){
			return "redirect:viewEmployee.do";
		}
		return "Error";
	}
	
/*	
//below is the code for Modify Employee
	
	public String modifyEmployeePage(){
		return "ModifyEmployee";
	}
	
	@RequestMapping(path="modifyEmployee.do", method=RequestMethod.POST)
	public String modifyEmployee(@RequestParam("employeeName") String name, @RequestParam("employeeSalary")double salary){
		employee.setEmployeeName(name);
		employee.setEmployeeSalary(salary);
		Employee result = service.modifyEmployee(employee);
		
		
		return "";
	}*/
	

}
