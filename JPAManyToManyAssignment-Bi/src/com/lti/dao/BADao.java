package com.lti.dao;

import java.util.List;

import com.lti.model.Book;

public interface BADao {
	
	public List<Book> readAllBook();
	public List<Book> readBookByAuthorName(String name);
	public List<Book> readBookByPrice(double max, double min);
	/*public List<Book> readAuthorByBookId(long isbn);*/


}
