package com.examination.customTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.examination.controller.QuestionsCrud;
import com.examination.models.Questions;

public class DisplayExam extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		try {
			out.println("<h2 style='margin-top:10px;'>List Of Questions</h2><form action='resultServlet' method='post'>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Questions> questions = QuestionsCrud.getAllQuestion();
		int count = 1;
		for(Questions question: questions) {
			String ht = "<div class='question-card'>" +  
					"		<h4>" + count++ + ") " + question.getQuestion() + "</h4>" + 
					"		<ul>" + 
					"			<li><input type='radio' value='"+ question.getOption1() + "' name='" + question.getQid() + "option'>" + question.getOption1() + "</li>" + 
					"			<li><input type='radio' value='"+ question.getOption2() + "' name='" + question.getQid() + "option'>" + question.getOption2() + "</li>" + 
					"			<li><input type='radio' value='"+ question.getOption3() + "' name='" + question.getQid() + "option'>" + question.getOption3() + "</li>" + 
					"			<li><input type='radio' value='"+ question.getOption1() + "' name='" + question.getQid() + "option'>" + question.getOption4() + "</li>" + 
					"		</ul><br>" +  
					"	</div>";
			
			try {
				out.println(ht);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			out.println("<button type='submit' class='btn btn-primary'>Submit</button></form>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
