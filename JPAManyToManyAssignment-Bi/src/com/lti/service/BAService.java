package com.lti.service;

import java.util.List;

import com.lti.model.Book;

public interface BAService  {
	
	public List<Book> findAllBook();
	public List<Book> findBookByAuthorName(String name);
	public List<Book> findBookByPrice(double max, double min);
	/*public List<Book> findAuthorByBookId(long isbn);*/

}
