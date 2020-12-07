<%@ page import="com.examination.models.Users" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam</title>


<link rel="stylesheet" href="bootstrap-4.5.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<style type="text/css">
	body{
	background-color: #E6E6E6;
	}
	.question-card{
		margin: 10px;
		padding:20px;
		background-color:white;
		border-radius:5px;
	}
</style>

</head>
<body>
	<%	session = request.getSession();
	Users user = (Users) session.getAttribute("user");
	if (session != null && user != null) {
		
		if(user.getRole().equalsIgnoreCase("teacher")) {
			response.sendRedirect("teacher.jsp");
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
        		<form action="" method="post">
					<button type="submit" class="btn btn-link nav-link" name="startExam" id="btn-start-exam">Attempt Exam</button>
				</form>
            </li>
          
           
          </ul>
             
              <form action="" method="post" class="form-inline mt-2 mt-md-0 ml-auto">
				<button type="submit" class="btn btn-danger my-2 my-sm-0" name="btn-logOut">Log Out</button>
			</form>
           
        </div>
      </nav>
    </header>
		
	
		<%
			if(request.getParameter("startExam") != null){%>
			<custom:dispExam/>
			<script>
			$(document).ready(function(){
				$('#btn-start-exam').attr("disabled", true);
				
			});
			</script>	
		<%}
		%>
		
		<%
		if(request.getParameter("btn-logOut") != null){
			session.invalidate();
			response.sendRedirect("index.jsp");
			
		}
		%>
	
	<%}}else{
		response.sendRedirect("authenticate.jsp");
	}	
	%>
	<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</body>
</html>