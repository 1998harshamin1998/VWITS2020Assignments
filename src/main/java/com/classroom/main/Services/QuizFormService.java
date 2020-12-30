package com.classroom.main.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.main.DAO.QuizFormDAO;
import com.classroom.main.entities.QuizForm;

@Service
public class QuizFormService {
	
	@Autowired
	private QuizFormDAO quizFormDAO;
	
	@Transactional
	public List<QuizForm> getQuizForm(String userid) {
		return quizFormDAO.getQuizForm(userid);
	}
	
	@Transactional
	public void updateQuiz(QuizForm quiz) {
		quizFormDAO.updateQuiz(quiz);
		
	}
	
	@Transactional
	public void addNewQuiz(QuizForm quiz){
		quizFormDAO.addNewQuiz(quiz);
	}
	
	@Transactional
	public void deleteQuiz(int quizId){
		quizFormDAO.deleteQuiz(quizId);
	}
	
	@Transactional
	public QuizForm getByUserIDQid(String userid, int qid) {
		return quizFormDAO.getByUserIDQid(userid, qid);
	
	}
}
