package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;
import com.lti.model.Address;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		Student student = new Student(46, "Aamir", 60.50);
		Address address = new Address("Mumbai","MH", "400102");
		student.setAddress(address);
		
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		//entityManager.persist(address);
		entityManager.getTransaction().commit();
		
		Student student2 =  entityManager.find(Student.class, student.getStudentId());
		System.out.println(student2);
		System.out.println(student2.getAddress());
	}

}
