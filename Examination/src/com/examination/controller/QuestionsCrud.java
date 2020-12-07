package com.examination.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examination.database.MyDBConnection;
import com.examination.models.Questions;

public class QuestionsCrud {
	
	public static Boolean insertQuestion(Questions question) {
		MyDBConnection conn = new MyDBConnection();
		Boolean flag = false;
		PreparedStatement st = conn.getPreparedStatement("insert into questions values(?,?,?,?,?,?,?)");
		try {
			st.setInt(1, question.getQid());
			st.setString(2, question.getQuestion());
			st.setString(3, question.getOption1());
			st.setString(4, question.getOption2());
			st.setString(5, question.getOption3());
			st.setString(6, question.getOption4());
			st.setString(7, question.getCorrect_answer());
			st.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.closeConnection();
		}
		
		return flag;
	}
	
	public static Boolean updateQuestion(Questions question) {
		MyDBConnection conn = new MyDBConnection();
		Boolean flag = false;
		PreparedStatement st = conn.getPreparedStatement("update questions set question=?, option1=?, option2=?, option3=?, option4=?, correct_answer=? where qid=?");
		try {
			st.setInt(7, question.getQid());
			st.setString(1, question.getQuestion());
			st.setString(2, question.getOption1());
			st.setString(3, question.getOption2());
			st.setString(4, question.getOption3());
			st.setString(5, question.getOption4());
			st.setString(6, question.getCorrect_answer());
			st.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.closeConnection();
		}
		
		return flag;
	}
	
	public static Questions getQuestionByID(int qid) {
		
		Questions question = new Questions();
		MyDBConnection conn = new MyDBConnection();
		PreparedStatement st = conn.getPreparedStatement("select * from questions where qid = ?");
		try {
			st.setInt(1, qid);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				question.setQid(rs.getInt("qid"));
				question.setQuestion(rs.getString("question"));
				question.setOption1(rs.getString("option1"));
				question.setOption2(rs.getString("option2"));
				question.setOption3(rs.getString("option3"));
				question.setOption4(rs.getString("option4"));
				question.setCorrect_answer(rs.getString("correct_answer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.closeConnection();
		}
	
		return question;
	}
	
public static List<Questions> getAllQuestion() {
		List<Questions> questions= new ArrayList<Questions>();
		
		MyDBConnection conn = new MyDBConnection();
		PreparedStatement st = conn.getPreparedStatement("select * from questions");
		try {
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Questions question = new Questions();
				question.setQid(rs.getInt("qid"));
				question.setQuestion(rs.getString("question"));
				question.setOption1(rs.getString("option1"));
				question.setOption2(rs.getString("option2"));
				question.setOption3(rs.getString("option3"));
				question.setOption4(rs.getString("option4"));
				question.setCorrect_answer(rs.getString("correct_answer"));
				questions.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.closeConnection();
		}
	
		return questions;
	}
	
	
}
