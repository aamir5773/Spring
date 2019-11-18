package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author implements Serializable {
	@Id
	@Column(name="authorid")
	private int author_id;
	@Column(name="firstName")
	private String firstname;
	@Column(name="middleName")
	private String middlename;
	@Column(name="lastName")
	private String lastname;
	@Column(name="phoneNo")
	private int phone_no;
	
	
	public Author() {
	}


	public Author(int author_id, String firstname, String middlename, String lastname, int phone_no) {
		super();
		this.author_id = author_id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.phone_no = phone_no;
	}


	public int getAuthor_id() {
		return author_id;
	}


	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getMiddlename() {
		return middlename;
	}


	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}


	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", firstname=" + firstname + ", middlename=" + middlename
				+ ", lastname=" + lastname + ", phone_no=" + phone_no + "]";
	}
	
	
	
	

}
