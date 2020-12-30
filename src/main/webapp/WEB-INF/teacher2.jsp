<%@page import="com.classroom.main.entities.Marks"%>
<%@page import="com.classroom.main.entities.Questions"%>
<%@page import="java.util.List"%>
<%@ page import="com.classroom.main.entities.Users" %>
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

	 <%	session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (session != null && user != null) {
			
			if(user.getRole().equalsIgnoreCase("student")) {	
				response.sendRedirect("student");
			}else {
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
             <a class="nav-link" href="dispQuestions">Display Questions</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="dispMarkList">Mark List</a>
            </li>
            <li class="nav-item">
            	<!-- Button trigger modal -->
				<button type="button" class="nav-link btn btn-link" data-toggle="modal" data-target="#insertQuestionModal">
				  Insert Question
				</button>
            </li>
            
            
             <li class="nav-item">
             	<!-- Button trigger modal -->
				<button type="button" class="nav-link btn btn-link" data-toggle="modal" data-target="#profleModal">
				  Profile
				</button>
             	
              <button type="button" class="btn btn-link nav-link" name="btn-profile-show" id= "btn-profile-show">Profile</button>
            </li>
          </ul>
             
              <form action="logOut" method="post" class="form-inline mt-2 mt-md-0 ml-auto">
				<button type="submit" class="btn btn-danger my-2 my-sm-0" name="btn-logOut">Log Out</button>
			</form>
           
        </div>
      </nav>
    </header>
	
	<!-- Begin page content -->
    <main role="main" class="container">
    	<!-- Modal -->
		<div class="modal fade" id="insertQuestionModal" tabindex="-1" role="dialog" aria-labelledby="insertQuestionModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="insertQuestionModalLabel">Insert Question Form</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
			        <form action="insertQuestion" id="insertQuestionForm" method="post">
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
					<button class="btn btn-primary" type="submit" id="btn-insert-question-submit" name="btn-insert-question-submit">Insert Question</button>
				</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="profileModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="profileModalLabel">Profile</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
			    <form action="updateProfile" id="updateProfileForm" method="post">
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
					<div class="modal-footer">
						<button type="submit" name="btn-profile-submit"  class="btn btn-success">Save</button>
						<button type="button" name="btn-profile-hide" data-dismiss="modal" class="btn btn-danger">Cancel</button>
					</div>	
				</form>
		      </div>
		    </div>
		  </div>
		</div>
		
		<%
		if(request.getAttribute("dispQuestions") != null){
		%>	
			<custom:dispQuestions questions='<%=(List<Questions>) request.getAttribute("questions") %>'/>
		<%}else if(request.getAttribute("dispMarkList") != null){ %>
    	<custom:dispMarkList marksList='<%=(List<Marks>) request.getAttribute("markList") %>'/>
    	<%} %>
    </main>
	
	<%}}else{
		response.sendRedirect("index");
	}
		%>
	
	
	<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</body>
</html>