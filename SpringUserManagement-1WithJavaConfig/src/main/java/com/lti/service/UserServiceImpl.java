package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.model.Users;

@Service("service")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao = null;
	public UserServiceImpl(){
		
	}
	
	public UserServiceImpl(UserDao Dao){
		this.dao = dao;
	}
	
	
	
	public boolean checkLogin(String username, String password){
		int result = getDao().readLogin(username, password);
		if(result ==1)
			return true;
		else
			return false;
	}
	public List<Users> findAllUsers(){
		return getDao().readAllUsers();
	}
	public boolean removeUser(String username){
		int result = getDao().deleteUser(username);
		if(result ==1)
			return true;
		else
			return false;
	}
	public boolean addUser(Users user){
		int result = getDao().createUser(user);
		if(result ==1)
			return true;
		else
			return false;
	}
	public boolean updateUser(Users user) {
		int result = getDao().updateUser(user);
		if(result ==1)
			return true;
		else
			return false;
	}
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
}






