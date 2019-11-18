package com.lti.dao;

import java.util.List;

import com.lti.model.Student;

public interface StudentDao {
	public int createStudent(Student student);
	public Student readStudentByRollNumber(int rollNumber);
	public List<Student> readAllStudents();
	public Student updateStudent(Student student);
	public int deleteStudent(int rollNumber);
 	public List<Student> readStudentByScore(double min, double max);
 	public List<Student> raedStudentByName(String name);
	public void beginTransaction();
	public void commitTransaction();
	public void rollbackTransaction();
	
}
