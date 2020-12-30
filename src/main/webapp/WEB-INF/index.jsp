<%@ page import="com.classroom.main.entities.Users" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VWITS Classroom</title>

<link rel="stylesheet" href="bootstrap-4.5.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
</head>
<body>
     
     
    <%	session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (session != null && user != null) {
			
			if(user.getRole().equalsIgnoreCase("teacher")) {	
				response.sendRedirect("teacher.jsp");
			}else {
				response.sendRedirect("student.jsp");
			}
		}else {%>
		
		<header>
	      <!-- Fixed navbar -->
	      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	        <a class="navbar-brand" href="index.jsp">Examinations</a>
	       	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
         	 <span class="navbar-toggler-icon"></span>
        	</button>
        	<div class="collapse navbar-collapse" id="navbarCollapse">
	        <div class="container ml-auto">
	        	<div class="ml-auto ">
	        		<form action="login" method="post" class="mt-2 mt-md-0 navbar-nav" >
			        	<div class="form-group nav-item mr-2">
			       	
			        		<input class="form-control mr-sm-2" type="text" name="txtUsername" id="txtUsername" placeholder="Username:" aria-label="Username">
			        		
			        	</div>
			            
			            <div class="form-group nav-item mr-2">
			            	<input class="form-control mr-sm-2" type="password" name="txtPassword" placeholder="Password:" aria-label="Password	">
			            </div>
			            
			            <button class="nav-item btn btn-outline-success  my-sm-0 mr-2" style="height:40px;" name="loginSubmit" type="submit">Log In</button>
	          		</form>
	          		<% if(request.getAttribute("msg") != null){ %>
							<p style="color:red;margin-top:-5px; margin-bottom:0px;"><small><%= request.getAttribute("msg") %></small></p>
							<%} %>
	        	</div><br>
	        	
	        </div>
	       </div>
	      </nav>
    	</header>
    	
    	<!-- Begin page content -->
     <main class="container mt-5">
     	<div class="container mt-5" style="margin-left:30px; float:right;max-width:450px;">
     		<h3>Register:</h3>
			<% if(request.getAttribute("rmsg") != null){ %>
			<p style="color:green"><%= request.getAttribute("rmsg") %></p>
			<%}else if(request.getAttribute("ermsg") != null){%>
				<p style="color:red"><%= request.getAttribute("ermsg") %></p>
			<%
			}	
			%>
			
			<form action="register" method="post">
				<div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtName" placeholder="Name:" aria-label="Name">
	            </div>
	            <div class="form-group">
	            	<input class="form-control mr-sm-2" type="text" name="txtUsername" placeholder="Username:" aria-label="Username">
	            </div>
				<div class="form-group">
	            	<input class="form-control mr-sm-2" type="password" name="txtPassword" placeholder="Password:" aria-label="Password	">
	            </div>
				<div class="form-group">
					<label for="drpRole">
				Role:<br>
				</label>
				<select class="form-control" name="drpRole" style="width:100%">
				    <option value="select" selected>--Select--</option>
				    <option value="teacher">Teacher</option>
				    <option value="student">Student</option>
				
			 	</select>
				</div>
			 	
				<button type ="submit" class="btn btn-success  my-sm-0 mr-2" style="display:block;width:100%;" name="regSubmit">Register</button>
			</form>
     	</div>
     
    
    </main>
	
		
	
	<%		
		}
	%>
    
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</body>
</html>