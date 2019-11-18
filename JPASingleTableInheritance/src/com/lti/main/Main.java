package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Saving;
import com.lti.model.Current;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		Saving s = new Saving(1000001, "Gayatri", 50000, 4.0);
		Current c = new Current(100000010, "LTI Ltd.", 900000, 50000);
		
		entityManager.getTransaction().begin();
		entityManager.persist(s);
		entityManager.persist(c);
		entityManager.getTransaction().commit();

	}

}
