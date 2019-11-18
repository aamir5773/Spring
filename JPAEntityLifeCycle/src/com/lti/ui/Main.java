package com.lti.ui;
import com.lti.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		//Transient Phase
		Student student = new Student();
		student.setStudentName("Sakshi");
		student.setAvgScore(91.75);
		
	    entityManager.getTransaction().begin();
		entityManager.persist(student);
		student.setAvgScore(75.00);
		entityManager.getTransaction().commit();
		System.out.println("Student is persisted in db");
		
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		System.out.println("Student is  removed from db");

			
	}

}
