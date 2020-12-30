package com.classroom.main.customTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.classroom.main.entities.Answers;
import com.classroom.main.entities.Questions;



public class DisplayExam extends TagSupport {
	/**
	 * 
	 */
	
	
	
	private static final long serialVersionUID = 1L;
	
	private Questions question;
	private int questionNumber;
	
	
	
	
	public int getQuestionNumber() {
		return questionNumber;
	}


	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}


	public Questions getQuestion() {
		return question;
	}


	public void setQuestion(Questions question) {
		this.question = question;
	}
	
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		
		String stringQuestion = "";
		
		stringQuestion += "<form action='quizHandler' method='post'><div class='' role='tabpanel' id='question" + question.getQid() + "'>"
				+ "                     <input type='hidden' value='" + question.getQid() + "' name='txtQid'>"
				+ "                     <input type='hidden' value='" + questionNumber + "' name='txtQuestionNumber'>"
				+ "			            <div class='container'>"
				+ "			            	<div class='row'>"
				+ "			            		<div class='col-sm'>"
				+ "			            			<h3>" + questionNumber + ") " + question.getQuestion() + "</h3>"
				+ "			            			<p>Question content comes here</p>"
				+ "			            		</div>"
				+ "			            		<div class='col-sm'>"
				+ "			            			<h3>Options</h3>"
				+ "			            			<ul>";
		
		for(Answers answer: question.getAnswers()) {
			stringQuestion += "<li><input type='radio' name='" + question.getQid() + "option' value='" + answer.getAid() + "'>" + answer.getContent() + "</li>";
			
		}
		
		stringQuestion += "			               </ul>"
				+ "			            		</div>"
				+ "                             <button type='submit' name='btn-exam-submit' class='btn btn-primary'>Next</button></div></form>"
				+ "			            	</div>"
				+ "			            </div>"
				+ "			        </div></form>";
		
		try {
			out.println(stringQuestion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.doStartTag();
	
	
	}
	


//	@Override
//	public int doStartTag() throws JspException {
//		// TODO Auto-generated method stub
//		JspWriter out = pageContext.getOut();
//		try {
//			out.println("<div>");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
//		int count = 1;
//		String links = "<ul class='nav nav-tabs' role='tablist'>";
//		String stringQuestions = "<form action='submitExam' method='post'><div class='tab-content'>";
//		for(Questions question: questions) {
//			if(count == 1) {
//				links += "<li class='nav-item' role='presentation'>"
//						+ "<a href='#question" + question.getQid() + "' class='nav-link active' data-toggle='tab' id='question-tab" + question.getQid() + "' role='tab' aria-controls='question" + question.getQid() + "' aria-selected='true'>" + count + "</a>"
//						+ "</li>";
//			}else {
//				links += "<li class='nav-item' role='presentation'>"
//						+ "<a href='#question" + question.getQid() + "' class='nav-link' data-toggle='tab' id='question-tab" + question.getQid() + "' role='tab' aria-controls='question" + question.getQid() + "' aria-selected='false'>" + count + "</a>"
//						+ "</li>";
//			}
//			
//			if(count==1) {
//				stringQuestions += "<div class='tab-pane fade show active' role='tabpanel' id='question" + question.getQid() + "'>"
//						+ "			            <div class='container'>"
//						+ "			            	<div class='row'>"
//						+ "			            		<div class='col-sm'>"
//						+ "			            			<h3>" + count + ") " + question.getQuestion() + "</h3>"
//						+ "			            			<p>Question content comes here</p>"
//						+ "			            		</div>"
//						+ "			            		<div class='col-sm'>"
//						+ "			            			<h3>Options</h3>"
//						+ "			            			<ul>";
//			}else {
//				
//				stringQuestions += "<div class='tab-pane fade' role='tabpanel' id='question" + question.getQid() + "'>"
//						+ "			            <div class='container'>"
//						+ "			            	<div class='row'>"
//						+ "			            		<div class='col-sm'>"
//						+ "			            			<h3>" + count + ") " + question.getQuestion() + "</h3>"
//						+ "			            			<p>Question content comes here</p>"
//						+ "			            		</div>"
//						+ "			            		<div class='col-sm'>"
//						+ "			            			<h3>Options</h3>"
//						+ "			            			<ul>";
//			}
//			
//			
//			
//			
//			for(Answers answer: question.getAnswers()) {
//				stringQuestions += "<li><input type='radio' name='" + question.getQid() + "option' value='" + answer.getAid() + "'>" + answer.getContent() + "</li>";
//				
//			}
//			stringQuestions += "			          </ul>"
//					+ "			            		</div>"
//					+ "			            	</div>"
//					+ "			            </div>"
//					+ "			        </div>";
//			count++;
//		}
//		
//		stringQuestions += "<button type='submit' name='btn-exam-submit' class='btn btn-primary'>Submit</button></div></form>";
//		links += "</ul>";
//		String finalOutString = links + stringQuestions + "</div>";
//		
//		try {
//			out.println(finalOutString);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return super.doStartTag();
//	}
}
