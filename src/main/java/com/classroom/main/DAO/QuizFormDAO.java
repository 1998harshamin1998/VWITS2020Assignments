package com.classroom.main.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.classroom.main.entities.QuizForm;


@Repository
public class QuizFormDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<QuizForm> getQuizForm(String userid) {
		Session session = entityManager.unwrap(Session.class);
		Query<QuizForm> query = session.createQuery("from QuizForm where userid=:userid", QuizForm.class);
		query.setParameter("userid", userid);
		List<QuizForm> list = query.getResultList();
		return list;
	}
	
	
	public void updateQuiz(QuizForm quiz) {
		Session session = entityManager.unwrap(Session.class);
		session.update(quiz);
		
	}
	
	public void addNewQuiz(QuizForm quiz){
		Session session = entityManager.unwrap(Session.class);
		session.save(quiz);
	}

	public void deleteQuiz(int quizId){
		Session session = entityManager.unwrap(Session.class);
		QuizForm quiz = session.get(QuizForm.class, quizId);
		session.delete(quiz);
	
	}
	
	public QuizForm getByUserIDQid(String userid, int qid) {
		Session session = entityManager.unwrap(Session.class);
		Query<QuizForm> query = session.createQuery("from QuizForm where userid=:userid and qid=:qid", QuizForm.class);
		query.setParameter("userid", userid);
		query.setParameter("qid", qid);
		List<QuizForm> list = query.getResultList();
		if(list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}
	
}
