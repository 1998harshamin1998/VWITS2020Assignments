package com.classroom.main.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.classroom.main.entities.Questions;

@Repository
public class QuestionsDAO {


	@PersistenceContext
	EntityManager entityManager;
	
	public List<Questions> fetchAllQuestions(){
		Session session = entityManager.unwrap(Session.class);
		Query<Questions> query = session.createQuery("from Questions", Questions.class);
		List<Questions> list = query.getResultList();
		return list;
	}
	
	
	
	public Questions fetchOneQuestion(int qid) {
		Session session = entityManager.unwrap(Session.class);
		Questions question = session.get(Questions.class, qid);
		
		return question;
	}
	
	public void addQuestion(Questions question){
		Session session = entityManager.unwrap(Session.class);
		session.save(question);	
	}
	
	public void deleteQuestion(String qid) {
		Session session = entityManager.unwrap(Session.class);
		Questions question = session.get(Questions.class, qid);
		session.delete(question);
		
	}
	
	public void updateQuestion(Questions question) {
		Session session = entityManager.unwrap(Session.class);
		session.update(question);
		
	}
	
}
