package com.examination.customTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.examination.controller.QuestionsCrud;
import com.examination.models.Questions;

public class DisplayAllQuestions extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		try {
			out.println("<h2 style='margin-top:10px;'>List Of Questions</h2><Section>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Questions> questions = QuestionsCrud.getAllQuestion();
		for(Questions question: questions) {
			String ht = "<div class='question-card'>" + 
					"		<p><small>" + question.getQid() + "</small> </p>" + 
					"		<h4>" + question.getQuestion() + "</h4>" + 
					"		<ul>" + 
					"			<li>"+ question.getOption1() + "</li>" + 
					"			<li>"+ question.getOption2() + "</li>" + 
					"			<li>"+ question.getOption3() + "</li>" + 
					"			<li>"+ question.getOption4() + "</li>" + 
					"		</ul>" + 
					"		<p><b>ANS: </b>"+ question.getCorrect_answer() + "</p><br>" + 
					"	</div>";
			
			try {
				out.println(ht);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out.println("</Section>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	
}
