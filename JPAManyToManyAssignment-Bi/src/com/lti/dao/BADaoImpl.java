package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lti.model.Author;
import com.lti.model.Book;
import com.lti.utils.JpaUtils;

public class BADaoImpl implements BADao {
	private EntityManager entityManager;

	public BADaoImpl() {
		entityManager= JpaUtils.geEntityManager();
		init();
	}
	
	public void init(){
	/*	long isbn;
		String title;
		double price;
*/

		Book book1 = new Book();
		book1.setIsbn(123546879);
		book1.setTitle("Harry Potter");
		book1.setPrice(155.65);
		
		Book book2 = new Book();
		book2.setIsbn(321654879);
		book2.setTitle("Ice and Fire");
		book2.setPrice(215.75);
		
		Book book3 = new Book();
		book3.setIsbn(87954623);
		book3.setTitle("Times");
		book3.setPrice(125.65);
		
		
		
		Author author1 = new Author();
		author1.setId(101);
		author1.setName("Raju");
		
		Author author2 = new Author();
		author2.setId(102);
		author2.setName("LAlu");
		
		author1.addBook(book1);
		author1.addBook(book2);
		
		author2.addBook(book2);
		author1.addBook(book3);
		
		entityManager.getTransaction().begin();
		entityManager.persist(author1);
		entityManager.persist(author2);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public List<Book> readAllBook() {
		TypedQuery<Book> tquery = entityManager.createQuery("Select b From Book b ", Book.class);
		List<Book> list = tquery.getResultList();
		return list;
	}

	@Override
	public List<Book> readBookByAuthorName(String name) {
		String query = "Select b from Book b Inner Join b.authors a where a.name=:name";
		TypedQuery<Book> tquery = entityManager.createQuery(query, Book.class);
		tquery.setParameter("name", name);		
		return tquery.getResultList();
	}

	@Override
	public List<Book> readBookByPrice(double max, double min) {
		String query = "Select b from Book b where price Between "+min+" And "+max+"";
		TypedQuery<Book> tquery = entityManager.createQuery(query, Book.class);
		List<Book> list = tquery.getResultList();
		return list;
	}

/*	@Override
	public List<Book> readAuthorByBookId(long isbn) {
		String query = "Select ab from AuthorBook ab where ab.isbn= '"+isbn+"'";
		TypedQuery<Book> tquery = entityManager.createQuery(query, Book.class);
		List<Book> list =  tquery.getResultList();		
		return list;
	}*/
	
	public void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	public void commitTransaction(){
		entityManager.getTransaction().commit();
	}
	
	public void rollbackTransaction(){
		entityManager.getTransaction().begin();
	}
	
	

}
