package com.classroom.main.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classroom.main.DAO.MarksDAO;
import com.classroom.main.entities.Marks;

@Service
public class MarksService {
	
	@Autowired
	MarksDAO marksDAO;
	
	
	@Transactional
	public List<Marks> getMarkList(){
		return marksDAO.getMarkList();
	}
	
	@Transactional
	public Marks getMarks(String userid) {
		return marksDAO.getMarks(userid);
	}
	
	@Transactional
	public void addMarks(Marks mark) {
		marksDAO.addMarks(mark);
	}
	
	@Transactional
	public void updateMarks(Marks mark) {
		marksDAO.updateMarks(mark);
	}
	
	@Transactional
	public void deleteMarks(Marks mark) {
		marksDAO.deleteMarks(mark);
	}
}
