package com.examination.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examination.controller.QuestionsCrud;
import com.examination.models.Questions;
import com.examination.models.Users;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session != null) {
			Users user = (Users) session.getAttribute("user");
			if(user.getRole().equalsIgnoreCase("teacher")) {
				if(request.getParameter("btn-insert-submit") !=null) {
					Questions question = new Questions(Integer.parseInt(request.getParameter("txtQid")),
							request.getParameter("txtQuestion"),
							request.getParameter("txtOption1"),
							request.getParameter("txtOption2"),
							request.getParameter("txtOption3"),
							request.getParameter("txtOption4"),
							request.getParameter("txtCorrectAnswer"));
					QuestionsCrud.insertQuestion(question);
					response.sendRedirect("teacher.jsp");
				}else if(request.getParameter("btn-update-submit") !=null) {
					Questions question = new Questions(Integer.parseInt(request.getParameter("txtQid")),
							request.getParameter("txtQuestion"),
							request.getParameter("txtOption1"),
							request.getParameter("txtOption2"),
							request.getParameter("txtOption3"),
							request.getParameter("txtOption4"),
							request.getParameter("txtCorrectAnswer"));
					QuestionsCrud.updateQuestion(question);
					response.sendRedirect("teacher.jsp");
				}
			}else {
				response.sendRedirect("student.jsp");
			}
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
