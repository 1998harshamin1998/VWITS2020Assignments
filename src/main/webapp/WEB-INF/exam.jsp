<%@ page import="com.classroom.main.entities.Users" %>
<%@page import="com.classroom.main.entities.Questions"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-4.5.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

<script> 

function timer(){
	
	var hour = 2
	var minute = 0;
	var sec = 0;
	
	setInterval(function() {

		var out = "";
		if (hour < 10){
			out += "0"+hour;
		}else{
			out += hour;
		}	

		out += " : ";
		if (minute < 10){
			out += "0"+minute;
		}else{
			out += minute;
		}	

		out += " : ";
		if (sec < 10){
			out += "0"+sec;
		}else{
			out += sec;
		}	
		document.getElementById("timer").innerHTML = out;
		sec--;
		if (sec == 0 && minute == 0 && hour == 0){
			alert("Time up");
		}else if (sec <= 0){
			if (minute == 00){
				hour--;
				minute = 59;
				sec = 59;
			}else{
				minute--;
				sec = 59;
			}
		}
	}, 1000);
	
}        
</script> 
</head>
<body onload="timer()">

	<%	session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (session != null && user != null) {
			
			if(user.getRole().equalsIgnoreCase("teacher")) {	
				response.sendRedirect("teacher");
			}else {
	%>
	
	<header>
      <!-- Fixed navbar -->
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">Examinations</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">           
              <div style="margin-right:50px; color:white;" class="ml-auto" id="timer" ></div>
           
        </div>
      </nav>
    </header>
    
    <main role="main" class="container">    
    	<section class="mt-2">
    		
    	
    		
			  <custom:dispExam question='<%=(Questions) request.getAttribute("question") %>' questionNumber='<%=(Integer) request.getAttribute("questionNumber") %>'/>
    		
    	
    		
    	</section>
    	
    	
		
    
    </main>
    
    <%}}else{
		response.sendRedirect("index");
	}
		%>
    
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script> 
</body>
</html>