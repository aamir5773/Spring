package com.lti.ui;

import java.util.Scanner;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main2 {
	
	private static StudentService service = null;
	static{
		service = new StudentServiceImpl();
	}

	public static void main(String[] args) {
		
		int rollno;
		String studentName;
		double avgscore;
		
		Student student = null;
		System.out.println("What would you like to perform"
				+ "1. Add"
				+ "2. Read"
				+ "3. Update"
				+ "4. Delete");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		Object entityManager;
		switch (choice) {
		
		case 1 :
			System.out.println("Enter RollNo, Student Name and Average Score");
			rollno = sc.nextInt();
			studentName= sc.next();
			avgscore = sc.nextDouble();
			
			student = new Student(rollno, studentName, avgscore);
			 boolean result = service.addStudent(student);
			if(result){
				System.out.println("Student is added");
			}
			break;
			
		case 2 :
			System.out.println("Ente the roll number");
			rollno = sc.nextInt();
			Student student2 = service.findStudentByRollNumber(rollno);
			System.out.println(student2);
			break;
			
		case 3:
			System.out.println("Ente the roll number for which u want to perform update");
			rollno = sc.nextInt();
			student2 = service.findStudentByRollNumber(rollno);
			System.out.println("Enter the Name and Score to be updated");
			studentName = sc.next();
			avgscore= sc.nextDouble();
			student = new Student(rollno, studentName, avgscore);
			student = service.modifyStudent(student);
			System.out.println(student);
			break;
			
		case 4:
			System.out.println("Ente the roll number for which u want to perform delete");
			rollno = sc.nextInt();
			student2 = service.findStudentByRollNumber(rollno);
			boolean result2 = service.removeStudent(rollno);
			
			if(result2){
				System.out.println("Student Deleted");
			}
			break;
		}
		
		

	}

}
