package com.examination.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examination.controller.UsersCrud;
import com.examination.models.Users;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session != null) {
			Users user = (Users) session.getAttribute("user");
			if(user != null) {
				String newUsername = request.getParameter("txtNewUsername");
				String newPassword = request.getParameter("txtNewPassword");
				if(newUsername.isEmpty() && !newPassword.isEmpty()) {
					user.setPassword(newPassword);
					
				}else if(!newUsername.isEmpty() && newPassword.isEmpty()) {
					user.setUsername(newUsername);
				}else if(!newUsername.isEmpty() && !newPassword.isEmpty()) {
					user.setPassword(newPassword);
					user.setUsername(newUsername);
				}
				
				UsersCrud.updateUser(user);
				session.setAttribute("user", user );
				session.setAttribute("msg", "Update Successful!");
				response.sendRedirect("student.jsp");
			}else {
				response.sendRedirect("index.jsp");
			}
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}
}
