package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Account;

public class AccDaoImpl {

	public void deposit(long accountNumber, double transactionAmount){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
	
		}
		
	
	}
	

