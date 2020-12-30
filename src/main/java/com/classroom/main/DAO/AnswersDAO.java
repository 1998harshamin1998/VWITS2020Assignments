package com.classroom.main.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.classroom.main.entities.Answers;

@Repository
public class AnswersDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Answers> fetchAllAnswers(){
		Session session = entityManager.unwrap(Session.class);
		Query<Answers> query = session.createQuery("from Answers", Answers.class);
		List<Answers> list = query.getResultList();
		return list;
	}
	
	public Answers fetchOneAnswers(int aid) {
		Session session = entityManager.unwrap(Session.class);
		Answers answer = session.get(Answers.class, aid);
		
		return answer;
	}
	
	public void addAnswers(Answers answer){
		Session session = entityManager.unwrap(Session.class);
		session.save(answer);	
	}
	
	public void deleteAnswer(int aid) {
		Session session = entityManager.unwrap(Session.class);
		Answers answer = session.get(Answers.class, aid);
		session.delete(answer);
		
	}
	
	public void updateAnswer(int aid) {
		Session session = entityManager.unwrap(Session.class);
		Answers answer = session.get(Answers.class, aid);
		session.update(answer);
		
	}
}
