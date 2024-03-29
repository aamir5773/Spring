package com.lti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lti.model.Users;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate template = null;
	
	
	
	public UserDaoImpl(JdbcTemplate template) {
		this.template = template;
		
	}
	
	private static final String SELECT_USER_RECORD = "Select * From Users";
	
	private static final String INSERT_USER_RECORD = "Insert into Users(username, password, firstname, lastname, mobilenumber) values(?, ?, ?, ?, ?)";
	
	private static final String UPDATE_USER_RECORD = "Update Users Set  password=?, firstname=?, lastname=?, mobilenumber=? where username = ?";
	
	private static final String DELETE_USER_RECORD = "Delete From Users where username=?";
	
	private static final String CHECK_LOGIN = "Select * from Users Where username=? And password=?";
	
	public UserDaoImpl(){
		
	}
	
	public int readLogin(String username, String password){
		List<Users> list = template.query(CHECK_LOGIN, new Object[]{ username, password}, new UserRowMapper());
		return  list!=null?list.size():0;
		
	}
	public List<Users> readAllUsers(){
		List<Users> list = getTemplate().query(SELECT_USER_RECORD, new UserRowMapper());
		return null;
		
	}
	public int deleteUser(String username){
		int result = getTemplate().update(DELETE_USER_RECORD, username);
		return result;
	
	}
	public int createUser(Users user){
		int result = getTemplate().update(INSERT_USER_RECORD, user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getMobilenumber());
		return result;
		
	}
	public int updateUser(Users user) {
		int result = getTemplate().update(UPDATE_USER_RECORD,  user.getPassword(), user.getFirstname(), user.getLastname(), user.getMobilenumber(), user.getUsername());
		return result ;
		
	}
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}


	
	
	
	
	
	
	


