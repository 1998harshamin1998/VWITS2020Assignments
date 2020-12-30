package com.classroom.main.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.classroom.main.entities.Users;

@Repository
public class UsersDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Users> fetchAllUsers(){
		Session session = entityManager.unwrap(Session.class);
		Query<Users> query = session.createQuery("from Users", Users.class);
		List<Users> list = query.getResultList();
		return list;
		
	}
	
	public Users fetchOneUser(String userid) {
		Session session = entityManager.unwrap(Session.class);
		Users user = session.get(Users.class, userid);
		
		return user;
	}
	
	public void addUsers(Users user){
		Session session = entityManager.unwrap(Session.class);
		session.save(user);	
	}
	
	public void deleteUser(String userid) {
		Session session = entityManager.unwrap(Session.class);
		Users user = session.get(Users.class, userid);
		session.delete(user);
		
	}
	
	public Users Login(String username, String password) {
		Session session = entityManager.unwrap(Session.class);
		Query<Users> query = session.createQuery("from Users where username = :username and password = :password", Users.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Users> list = query.getResultList();
		if(list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}
	
	public void updateUser(Users user) {
		Session session = entityManager.unwrap(Session.class);
		session.update(user);
	}
}
