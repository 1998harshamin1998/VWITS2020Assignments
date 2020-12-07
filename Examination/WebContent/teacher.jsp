<%@ page import="com.examination.models.Users" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Portal</title>



<link rel="stylesheet" href="bootstrap-4.5.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">

</head>
<body>
	<%	
		session = request.getSession();
		Users user = (Users) session.getAttribute("user");	
		if(session != null && user != null){
		
			if(user.getRole().equalsIgnoreCase("teacher")) {
				
	%>
	
	
		
		
	  <header>
      <!-- Fixed navbar -->
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="index.jsp">Examinations</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item"> 
              <form action="" method="post" >
				<button type="submit" class="nav-link btn btn-link" name="btn-display-questions">Show All Questions</button>
			</form>
            </li>
            <li class="nav-item">
              <form action="" method="post" >
				<button type="submit" class=" nav-link btn btn-link" name="btn-display-student-marks">Show Student Marks</button>
			</form>
            </li>
            <li class="nav-item">
              <button class="nav-link btn btn-link"   id="btn-insert-questions">Insert</button>
            </li>
            <li class="nav-item">
              <button class="nav-link btn btn-link"   id="btn-update-questions">Update</button>
            </li>
            
             <li class="nav-item">
              <button type="button" class="btn btn-link nav-link" name="btn-profile-show" id= "btn-profile-show">Profile</button>
            </li>
          </ul>
             
              <form action="" method="post" class="form-inline mt-2 mt-md-0 ml-auto">
				<button type="submit" class="btn btn-danger my-2 my-sm-0" name="btn-logOut">Log Out</button>
			</form>
           
        </div>
      </nav>
    </header>
	
	 <!-- Begin page content -->
    <main role="main" class="container">
    	<h2 class="mt-5">Welcome Professor <%= user.getName().toUpperCase() %></h2>
      	<section id="update-insert-form">
		<div class="update-insert-form-container">
			<button class="btn btn-secondary" id="close-form" style="float:right; margin-right:5px;">X</button><br>
			<h3 id="insert-form-heading">Insert Form:</h3><br>
			<h3 id="update-form-heading">Update Form:</h3><br>
			<form action="teacherServlet" method="post">
				
	            <div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtQid" placeholder="QuestionID:" aria-label="QuestionID">
	            </div>
	            <div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtQuestion" placeholder="Question:" aria-label="Question">
	            </div>
	            <div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtOption1" placeholder="Option 1:" aria-label="Option1">
	            </div>
	            <div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtOption2" placeholder="Option 2:" aria-label="Option2">
	            </div>
	            <div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtOption3" placeholder="Option 3:" aria-label="Option3">
	            </div>
	            <div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtOption4" placeholder="Option 4:" aria-label="Option4">
	            </div>
	            <div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtCorrectAnswer" placeholder="Correct Answer:" aria-label="Correct Answer">
	            </div>		
				<button class="btn btn-success" type="submit" id="btn-insert-submit" name="btn-insert-submit">Submit Question</button>
				<button class="btn btn-primary" type="submit" id="btn-update-submit" name="btn-update-submit">Update Question</button>
				</form>
			</div>
	</section>
    </main>
		
	
	
	<% if(session.getAttribute("msg") != null){ %>
			
		<div class="container profile-container" id="profile-container" style="display:block;">
			<h3> Profile Settings</h3>
			<form action="profileServlet" method="post">
			<p><%= session.getAttribute("msg") %></p>
	<%}else{ %>	
		<div class="container profile-container" id="profile-container">
			<h3> Profile Settings</h3>
			<form action="profileServlet" method="post">
		<%} %>
				<div class="form-group">
	            	<label for="txtName">Name:</label>
	            	<input class="form-control mr-sm-2" type="text" id="txtName" name="txtName" readonly="readonly" value='<%=user.getName() %>' aria-label="Name">
	            </div>
	            <div class="form-group">
	            	<label for="txtUsername">Username:</label>
	            	<input class="form-control mr-sm-2" type="text" id="txtUsername" readonly="readonly" name="txtUsername" value='<%=user.getUsername() %>'  aria-label="Username">
	            </div>
	            <div class="form-group">
	            	<label for="txtNewUsername">NewUsername:</label>
	            	<input class="form-control mr-sm-2" type="text" id="txtNewUsername" name="txtNewUsername" placeholder="New Username:" aria-label="New Username">
	            </div>
				<div class="form-group">
					<label for="txtPassword">Password:</label>
	            	<input class="form-control mr-sm-2" type="password" id="txtPassword" readonly="readonly" name="txtPassword" placeholder="Password:" value='<%=user.getPassword() %>' aria-label="Password	">
	            </div>
				<div class="form-group">
					<label for="txtNewPassword">New Password:</label>
				<input class="form-control mr-sm-2" type="password" id="txtNewPassword"name="txtNewPassword" placeholder="New Password:" aria-label="New Password	">
				</div>
			 	<div class="form-group">
	            	<label for="txtRole">Role:</label>
	            	<input class="form-control mr-sm-2" type="text" id="txtRole" name="txtRole" readonly="readonly" value='<%=user.getRole().toUpperCase() %>' aria-label="Role">
	            </div>
				
				<button type="submit" name="btn-profile-submit" id="btn-profile-submit" class="btn btn-success">Save</button>
				<button type="button" name="btn-profile-hide" id="btn-profile-hide" class="btn btn-danger">Cancel</button>
			</form>
	</div>
	
	
		<%
		if(request.getParameter("btn-display-questions") != null){
		%>	
			<custom:dispQuestions/>
		<%}else if(request.getParameter("btn-display-student-marks") != null){%>
			<custom:dispStudentMarks/>
		<%}else if(request.getParameter("btn-logOut") != null){
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
			%>
		
	
	<%}else{
		response.sendRedirect("student.jsp");
	}%>
	
<%} else {
	response.sendRedirect("index.jsp");
}
	%>

	<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	
</body>
</html>