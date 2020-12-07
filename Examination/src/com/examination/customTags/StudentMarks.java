package com.examination.customTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.examination.controller.MarksCrud;
import com.examination.models.StudMarks;

public class StudentMarks extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		List<StudMarks> marksList = MarksCrud.getStudMarksList();
		int count = 1;
		
		for(StudMarks marks: marksList) {
			String ht = "<tr><td class='srno'>" + count++ + "</td>" + "<td>" + marks.getStudName() +"</td><td>" + marks.getMarks() + "</td></tr>";
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
