package com.lti.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book implements Serializable {
	@Id
	private long isbn;
	private String title;
	private double price;
	
	@ManyToMany(mappedBy="books")
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		
	}

	public Book(long isbn, String title, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	
	public void addAuthor(Author author){
		authors.add(author);
		
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + "]";
	}

}
