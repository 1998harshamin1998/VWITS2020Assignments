<%@ page import="com.classroom.main.entities.Users" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Portal</title>

<link rel="stylesheet" href="bootstrap-4.5.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">

</head>
<body>
	
	<header>
      <!-- Fixed navbar -->
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="student">Examinations</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item"> 
              <!-- Button trigger modal -->
				<button type="button" class="nav-link btn btn-link" data-toggle="modal" data-target="#startExamModal">
				  Attempt Exam
				</button>
            </li>
          
            
            
             <li class="nav-item">
             	 <!-- Button trigger modal -->
				<button type="button" class="nav-link btn btn-link" data-toggle="modal" data-target="#profleModal">
				  Profile
				</button>
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
		<div class="modal fade" id="startExamModal" tabindex="-1" role="dialog" aria-labelledby="startExamModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="startExamModalLabel">Begin Exam</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
			
			        <div class="container">
			        	<h5>Instructions</h5><hr>
						<ol>
							<li> The duration of the test is 2 hours.</li>
							<li> You can go between the questions throughout the test. </li>
							<li> Once the time is over, Test will Automatically get submitted. </li>
							<li> Answers cannot be changed once the test has been submitted </li>
							<li> If by some technical issue you are logged out, Don't panic. Log In again. Test will resume from the same point and timer </li>
							<li> All The Best!</li>
						</ol>        	
			        </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <a href="exam" class="btn btn-secondary">Start Exam</a>
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
    	
    </main>


	<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</body>
</html>