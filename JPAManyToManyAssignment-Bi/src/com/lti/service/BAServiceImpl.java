package com.lti.service;

import java.util.List;

import com.lti.dao.BADao;
import com.lti.dao.BADaoImpl;
import com.lti.model.Book;


public class BAServiceImpl implements BAService {
	
	private BADao badao;
	public BAServiceImpl() {
		badao = new BADaoImpl();
	}



	@Override
	public List<Book> findAllBook() {
		return badao.readAllBook();
	}

	@Override
	public List<Book> findBookByAuthorName(String name) {
		return badao.readBookByAuthorName(name);
	}

	@Override
	public List<Book> findBookByPrice(double max, double min) {
		List<Book> list = badao.readBookByPrice(max, min);
		return list;
		
	}

	/*@Override
	public List<Book> findAuthorByBookId(long isbn) {
		List<Book> list = badao.readAuthorByBookId(isbn);
		return list;
	}*/

}
