package com.classroom.main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.main.DAO.QuestionsDAO;
import com.classroom.main.entities.Questions;

@Service
public class QuestionsService {

	@Autowired
	QuestionsDAO questionsDAO;

	@Transactional
	public List<Questions> fetchAllQuestions(){
		
		return questionsDAO.fetchAllQuestions();
	}
	
	@Transactional
	public Questions fetchOneQuestion(int qid) {
		
		
		return questionsDAO.fetchOneQuestion(qid);
	}
	
	@Transactional
	public void addQuestion(Questions question){
		questionsDAO.addQuestion(question);
	}
	
	@Transactional
	public void deleteQuestion(String qid) {
		questionsDAO.deleteQuestion(qid);
		
	}
	
	@Transactional
	public void updateQuestion(Questions question) {
		questionsDAO.updateQuestion(question);
		
	}
	
	
}
