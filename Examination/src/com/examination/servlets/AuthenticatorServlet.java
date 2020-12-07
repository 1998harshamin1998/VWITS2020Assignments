package com.examination.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examination.controller.Authenticator;
import com.examination.models.Users;

/**
 * Servlet implementation class AuthenticatorServlet
 */
@WebServlet("/authenticatorServlet")
public class AuthenticatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticatorServlet() {
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
		
		if(request.getParameter("loginSubmit") != null) {
			Users user;
			user = Authenticator.login(request.getParameter("txtUsername"), request.getParameter("txtPassword"));
			if(user.getUserid() != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user );
//				response.sendRedirect("homeServlet");
				if(user.getRole().equalsIgnoreCase("teacher")) {
					response.sendRedirect("teacher.jsp");
				}else if(user.getRole().equalsIgnoreCase("student")) {
					response.sendRedirect("student.jsp");
				}
			}else {
				request.setAttribute("msg", "Invalid Credentials!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} else if(request.getParameter("regSubmit") != null) {
			String name = request.getParameter("txtName");
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			String role = request.getParameter("drpRole");
			if(!role.equals("select")) {
				Users user = new Users(name, username, password, role);
				if(Authenticator.registration(user)) {
					request.setAttribute("rmsg", "Registration Successful, please login!");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}else {
					request.setAttribute("ermsg", "Registration Failed");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			}
			
		}
	}

}
