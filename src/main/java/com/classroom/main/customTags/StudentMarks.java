package com.classroom.main.customTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.classroom.main.entities.Marks;



public class StudentMarks extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Marks> marksList;
	
	

	public List<Marks> getMarksList() {
		return marksList;
	}



	public void setMarksList(List<Marks> marksList) {
		this.marksList = marksList;
	}



	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		try {
			out.println("<section>" + 
					"		<div style='margin-top:10px;' class='container marks-container'>" + 
					"			<h3>" + 
					"				Marks Sheet" + 
					"			</h3>" + 
					"			<table>" + 
					"				<tr>" + 
					"				<th class='srno'>Sr no.</th>" + 
					"				<th>Name</th>" + 
					"				<th>Marks</th>" + 
					"				</tr>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 1;
		
		for(Marks marks: marksList) {
			String ht = "<tr><td class='srno'>" + count++ + "</td>" + "<td>" + marks.getUser().getName() +"</td><td>" + marks.getMarks() + "</td></tr>";
			try {
				out.println(ht);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			out.println("</table>" + 
					"		</div>" + 
					"	</section>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
