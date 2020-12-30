package com.classroom.main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.main.DAO.UsersDAO;
import com.classroom.main.entities.Users;

@Service
public class UsersService {

	@Autowired
	private UsersDAO usersDAO;
	
	@Transactional
	public List<Users> fetchAllUsers(){
		return usersDAO.fetchAllUsers();
		
	}
	
	@Transactional
	public Users fetchOneUser(String userid) {
		return usersDAO.fetchOneUser(userid);
	}
	
	@Transactional
	public void addUsers(Users user){
		
		usersDAO.addUsers(user);
		
	}
	
	@Transactional
	public void deleteUser(String userid) {
		usersDAO.deleteUser(userid);
		
	}
	
	@Transactional
	public Users Login(String username, String password) {
		return usersDAO.Login(username, password);
	}
	
	@Transactional
	public void updateUser(Users user) {
		usersDAO.updateUser(user);
	}
	
}
