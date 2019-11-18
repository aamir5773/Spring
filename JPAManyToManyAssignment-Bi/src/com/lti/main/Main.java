package com.lti.main;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;
import com.lti.model.Book;
import com.lti.service.BAService;
import com.lti.service.BAServiceImpl;


public class Main {
	
	private static BAService service = null;
	static{
		service = new BAServiceImpl();
	}

	public static void main(String[] args) {

		List<Book> book = null;
		
		
	
		System.out.println("What would you like to perform"
				+ "1. Find All Books"
				+ "2. Find Book by Price"
				+ "3. Find Book By Author Name");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch (choice){
		
		case 1 :
			book = service.findAllBook();
			System.out.println(book);
			break;
			
		case 2:
			book= service.findBookByPrice(200, 100);
			System.out.println(book);
			break;
			
		case 3 :
		 	book= service.findBookByAuthorName("Raju");
		 	System.out.println(book);
		 	break;
			
			
	
			
		}
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
			
	}

}
