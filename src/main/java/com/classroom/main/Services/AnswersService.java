package com.classroom.main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.main.DAO.AnswersDAO;
import com.classroom.main.entities.Answers;

@Service
public class AnswersService {

	@Autowired
	AnswersDAO answersDAO;

	@Transactional
	public List<Answers> fetchAllAnswers(){
		return answersDAO.fetchAllAnswers();
	}
	
	@Transactional
	public Answers fetchOneAnswers(int aid) {
		return answersDAO.fetchOneAnswers(aid);
	}
	
	@Transactional
	public void addAnswers(Answers answer){
		answersDAO.addAnswers(answer);
	}
	
	@Transactional
	public void deleteAnswer(int aid) {
		answersDAO.deleteAnswer(aid);
		
	}
	
	@Transactional
	public void updateAnswer(int aid) {
		answersDAO.updateAnswer(aid);
		
	}
}
