package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {

		Student student = new Student(6, "Sakshi", 73.5);
		//JPA Api
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		System.out.println("Student Object Saved");
		
		//Find
		Student student2 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student2);
		
		
		//Update
		student2.setAvgScore(65.5);
		System.out.println("After Update Student Object");
		entityManager.getTransaction().begin();
		entityManager.merge(student2);
		entityManager.getTransaction().commit();
		student2 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student2);
		
		//Remove
		System.out.println("After remove student object");
		entityManager.getTransaction().begin();
		entityManager.remove(student2);
		entityManager.getTransaction().commit();
		student2= entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student2);
		

		
	}

}
