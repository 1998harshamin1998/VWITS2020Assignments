package com.classroom.main.customTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.classroom.main.entities.Answers;
import com.classroom.main.entities.Questions;


public class DisplayAllQuestions extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Questions> questions;
	
	
	
	
	public List<Questions> getQuestions() {
		return questions;
	}




	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		try {
			out.println("<h2 style='margin-top:10px;'>List Of Questions</h2>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Questions question: questions) {
			String correctAnswer = "";
			String ht = "<div class='question-card'>" + "<!-- Button trigger modal -->"
					+ "				<button type='button' style='float:right;' class=' btn btn-primary' data-toggle='modal' data-target='#updateQuestionModal" + question.getQid() + "'>"
					+ "				  Update"
					+ "				</button>" +
					"		<h4>" + question.getQuestion() + "</h4>" + 
					"		<ul>";
		
			for(Answers answer : question.getAnswers()) {
				if(answer.isCorrect()) {
					correctAnswer = answer.getContent();
					ht += "<li style='color:green;'>" + answer.getContent() + "</li>";
					
				}else {
					ht += "<li>" + answer.getContent() + "</li>";
				}
						
			}
			
			ht += "</ul>";
			
			ht += "<!-- Modal -->"
					+ "		<div class='modal fade' id='updateQuestionModal" + question.getQid() + "' tabindex='-1' role='dialog' aria-labelledby='updateQuestionModelLabel" + question.getQid() + "' aria-hidden='true'>"
					+ "		  <div class='modal-dialog' role='document'>"
					+ "		    <div class='modal-content'>"
					+ "		      <div class='modal-header'>"
					+ "		        <h5 class='modal-title' id='updateQuestionModalLabel" + question.getQid() + "'>Update Question Form</h5>"
					+ "		        <button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
					+ "		          <span aria-hidden='true'>&times;</span>"
					+ "		        </button>"
					+ "		      </div>"
					+ "		      <div class='modal-body'>"
					+ "			        <form action='updateQuestion' method='post'>"
					+ "					<div class='form-group'>"
					+ "		            	<input class='form-control mr-sm-2' type='text' name='txtQid' placeholder='QuestionID:' value='" + question.getQid() + "' aria-label='QuestionID'>"
					+ "		            </div>"
					+ "		            <div class='form-group'>"
					+ "		            	<input class='form-control mr-sm-2' type='text' name='txtQuestion' placeholder='Question:' value='" + question.getQuestion() + "' aria-label='Question'>"
					+ "		            </div>"
					+ "		            <div class='form-group'>"
					+ "		            	<input class='form-control mr-sm-2' type='text' name='txtOption1' placeholder='Option 1:' value='" + question.getAnswers().get(0).getContent() + "' aria-label='Option1'>"
					+ "		            </div>"
					+ "		            <div class='form-group'>"
					+ "		            	<input class='form-control mr-sm-2' type='text' name='txtOption2' placeholder='Option 2:' value='" + question.getAnswers().get(1).getContent() + "' aria-label='Option2'>"
					+ "		            </div>"
					+ "		            <div class='form-group'>"
					+ "		            	<input class='form-control mr-sm-2' type='text' name='txtOption3' placeholder='Option 3:' value='" + question.getAnswers().get(2).getContent() + "' aria-label='Option3'>"
					+ "		            </div>"
					+ "		            <div class='form-group'>"
					+ "		            	<input class='form-control mr-sm-2' type='text' name='txtOption4' placeholder='Option 4:' value='" + question.getAnswers().get(3).getContent() + "' aria-label='Option4'>"
					+ "		            </div>"
					+ "		            <div class='form-group'>"
					+ "		            	<input class='form-control mr-sm-2' type='text' name='txtCorrectAnswer' placeholder='Correct Answer:'  value='" + correctAnswer + "' aria-label='Correct Answer'>"
					+ "		            </div>		"
					+ "					<button class='btn btn-primary' type='submit' id='btn-insert-question-submit' name='btn-insert-question-submit'>Update Question</button>"
					+ "				</form>"
					+ "		      </div>"
					+ "		      <div class='modal-footer'>"
					+ "		        <button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"
					+ "		      </div>"
					+ "		    </div>"
					+ "		  </div>"
					+ "		</div></div>";
			
			try {
				out.println(ht);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return super.doStartTag();
	}
	
}
