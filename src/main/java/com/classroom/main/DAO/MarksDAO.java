package com.classroom.main.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.classroom.main.entities.Marks;

@Repository
public class MarksDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Marks> getMarkList(){
		Session session = entityManager.unwrap(Session.class);
		Query<Marks> query = session.createQuery("from Marks", Marks.class);
		List<Marks> list = query.getResultList();
		return list;
	}
	
	public Marks getMarks(String userid) {
		Session session = entityManager.unwrap(Session.class);
		Query<Marks> query = session.createQuery("from Marks where userid=:userid", Marks.class);
		query.setParameter("userid", userid);
		List<Marks> list = query.getResultList();
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}
	
	public void addMarks(Marks mark) {
		Session session = entityManager.unwrap(Session.class);
		session.save(mark);	
	}
	
	public void updateMarks(Marks mark) {
		Session session = entityManager.unwrap(Session.class);
		
		session.update(mark);
	}
	
	public void deleteMarks(Marks mark) {
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(mark);
	}
}
