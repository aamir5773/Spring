package com.lti.ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lti.config.AppConfig;
import com.lti.model.Users;
import com.lti.service.UserService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService service = context.getBean("service",UserService.class);// = new EmployeeService();
		Users user= context.getBean("user", Users.class); //= new employee()  We dont write it bcoz spring framework will make it 
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("What would you like to perform"
				+ "1. Find All Users "
				+ "2. Create User"
				+ "3. Update Usesr"
				+ "4. Delete User"
				+ "5.login into System");
		
		int choice = s.nextInt();
		
		switch (choice) {
		case 1:
			
			break;
		case 2:
			System.out.println("Enter Username");
			user.setUsername(s.next());
			
			
			System.out.println("Enter Password");
			user.setPassword(s.next());
			
			System.out.println("Enter Firstname");
			user.setFirstname(s.next());
			
			System.out.println("Enter Lastname");
			user.setLastname(s.next());
			
			System.out.println("Enter MobileNumber");
			user.setMobilenumber(s.next());
			service.addUser(user);
			System.out.println(user);
			System.out.println("User Added Successfully");
			break;
			
		case 3: 
			System.out.println("Enter Username for which you want to perform update functionality ");
			user.setUsername(s.next());
			
			
			System.out.println("Enter new Password");
			user.setPassword(s.next());
			
			System.out.println("Enter new Firstname");
			user.setFirstname(s.next());
			 
			System.out.println("Enter new Lastname");
			user.setLastname(s.next());
			
			System.out.println("Enter new MobileNumber");
			user.setMobilenumber(s.next());
			
			boolean result = service.updateUser(user);
			if(result){
				System.out.println(user);
				System.out.println("User Updated successfully");
			}else{
				System.out.println("Update Failed");
			}
			break;
			
		case 4 :
			
			System.out.println("Enter Username for which you want to perform delete functionality ");
			String username = s.next();
			
			boolean result1 = service.removeUser(username);
			if(result1){
				System.out.println("User Deleted");
			}else{
				System.out.println("Delete failed");
			}
			break;
			
		case 5:
		System.out.println("Enter Username & password");
		 username = s.next();
		String password = s.next();
			boolean result11 = service.checkLogin(username, password);
			if(result11){
				System.out.println("Login Successful");
			}
			else {
				System.out.println("login Unsucessful");
			}
			
		default:
			break;
		}
		
		
		
		
		
		
		
		
		
		
		/*System.out.println("Enter Username");
		user.setUsername(s.next());
		
		
		System.out.println("Enter Password");
		user.setPassword(s.next());
		
		System.out.println("Enter Firstname");
		user.setFirstname(s.next());
		
		System.out.println("Enter Lastname");
		user.setLastname(s.next());
		
		System.out.println("Enter MobileNumber");
		user.setMobilenumber(s.next());
		*/
		
		
		
		
	/*	
		boolean result = service.addEmployee(employee);
		if(result){
			List<Employee> list =  service.findAllEmployees();
			for(Employee emp : list){
				System.out.println(emp);
			}
		}else{
			System.out.println("Employee Data not saved");
		}*/
	}

}
