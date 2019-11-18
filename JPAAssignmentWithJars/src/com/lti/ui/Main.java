package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;


public class Main {

	public static void main(String[] args) {
		
		Author author = new Author(2, "Aamir", "F", "Dhanani", 321654987);
		//JPA Api
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(author);
		entityManager.getTransaction().commit();
		System.out.println("Author Object Saved");
		
		
		
				//Find
				Author author2 = entityManager.find(Author.class, author.getAuthor_id());
				System.out.println(author2);
				
				
				//Update
				author2.setFirstname("NameUpdated");
				System.out.println("After Update Author Object");
				entityManager.getTransaction().begin();
				entityManager.merge(author2);
				entityManager.getTransaction().commit();
				author2 = entityManager.find(Author.class, author.getAuthor_id());
				System.out.println(author2);
				
				//Remove
				System.out.println("After remove author object");
				entityManager.getTransaction().begin();
				entityManager.remove(author2);
				entityManager.getTransaction().commit();
				author2= entityManager.find(Author.class, author.getAuthor_id());
				System.out.println(author2);	
				
	}

}
