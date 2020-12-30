<%@page import="com.classroom.main.entities.Answers"%>
<%@page import="com.classroom.main.entities.Questions"%>
<%@ page import="com.classroom.main.entities.Users" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Portal</title>



<link rel="stylesheet" href="bootstrap-4.5.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<style>
	.overlay{
		position: fixed;
		display: none;
		width: 100%;
		height: 100%;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		background-color: rgba(0,0,0,0.5);
		z-index: 2;
		cursor: pointer;
	}
	
	.overlay-elements{
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50%);
		-ms-transform: translate(-50%,-50%);
	}
</style>
</head>
<body>

	
	<%	
		session = request.getSession();
		Users user = (Users) session.getAttribute("user");	
		if(session != null && user != null){
		
			if(user.getRole().equalsIgnoreCase("student")) {
				response.sendRedirect("student");
			}else{
				if(request.getAttribute("question") != null){
					Questions question = (Questions) request.getAttribute("question");
			%>
			
				<div class="overlay" id="update-question-form-overlay">
				<div class="overlay-elements">
					<form action="updateQuestion" method="post">
						<button class="btn btn-secondary" id="close-update-question-form-overlay" style="float:right; margin-right:5px;">X</button><br>
					</form>
					
					<h3 id="update-form-heading">Update Form:</h3><br>
					<form action="updateQuestion" method="post">
						<div class="form-group">
			            	<input class="form-control mr-sm-2" type="hidden" readonly="readonly" value="<%=question.getQid()%>" name="txtQid" placeholder="QuestionID:" aria-label="QuestionID">
			            </div>
			            <div class="form-group">
			            	<input class="form-control mr-sm-2" type="text" name="txtQuestion" value="<%=question.getQuestion()%>" placeholder="Question:" aria-label="Question">
			            </div>
			            <div class="form-group">
			            	<input class="form-control mr-sm-2" type="text" name="txtOption1" value="<%=question.getAnswers().get(0).getContent()%>" placeholder="Option 1:" aria-label="Option1">
			            </div>
			            <div class="form-group">
			            	<input class="form-control mr-sm-2" type="text" name="txtOption2" value="<%=question.getAnswers().get(1).getContent()%>" placeholder="Option 2:" aria-label="Option2">
			            </div>
			            <div class="form-group">
			            	<input class="form-control mr-sm-2" type="text" name="txtOption3" value="<%=question.getAnswers().get(2).getContent()%>" placeholder="Option 3:" aria-label="Option3">
			            </div>
			            <div class="form-group">
			            	<input class="form-control mr-sm-2" type="text" name="txtOption4" value="<%=question.getAnswers().get(3).getContent()%>" placeholder="Option 4:" aria-label="Option4">
			            </div>
			            <div class="form-group">
			            <% for(Answers answer: question.getAnswers()){
			            		if(answer.isCorrect()){
			            			%>
			            			<input class="form-control mr-sm-2" type="text" name="txtCorrectAnswer" value="<%=answer.getContent()%>" placeholder="Correct Answer:" aria-label="Correct Answer">
			            			
			            			<%
			            		}
			            	}	
			            %>
			            
			            	
			            </div>		
						<button class="btn btn-primary" type="submit" id="btn-update-question-submit" name="btn-update-question-submit">Update Question</button>
					</form>
	
					</div>
				</div>
			
			<%
				}
			}
		}
	%>
	
	
		
	<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	
	
	
	
</body>
</html>