package com.classroom.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.classroom.main.Services.AnswersService;
import com.classroom.main.Services.MarksService;
import com.classroom.main.Services.QuestionsService;
import com.classroom.main.Services.QuizFormService;
import com.classroom.main.Services.UsersService;
import com.classroom.main.entities.Answers;
import com.classroom.main.entities.Marks;
import com.classroom.main.entities.Questions;
import com.classroom.main.entities.QuizForm;
import com.classroom.main.entities.Users;


@Controller
public class ClassroomController {
	
	@Autowired
	QuestionsService questionsService; 
	@Autowired
	MarksService marksService;
	@Autowired
	UsersService usersService;
	@Autowired
	AnswersService answersService;
	
	@Autowired
	QuizFormService quizFormService;
	
	@PostMapping("/login")
	public ModelAndView logIn(@RequestParam("txtUsername") String username, @RequestParam("txtPassword") String password, HttpServletRequest request) {
		Users user = usersService.Login(username, password);
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user );
			if(user.getRole().equalsIgnoreCase("teacher")) {
				return new ModelAndView("redirect:/teacher");
			}else if(user.getRole().equalsIgnoreCase("student")) {
				return new ModelAndView("redirect:/student");
			}
		}else {
			ModelAndView model = new ModelAndView();
			model.setViewName("index");
			model.addObject("msg", "Invalid Credentials!");
			return model;
		}
		
		return new ModelAndView("redirect:/");
		
	}
	
	@PostMapping("/register")
	public ModelAndView register(@RequestParam("txtName") String name, @RequestParam("txtUsername") String username, @RequestParam("txtPassword") String password, @RequestParam("drpRole") String role) {
		
		if(!role.equals("select")) {
			Users user = new Users(name, username, password, role);
			usersService.addUsers(user);
			ModelAndView model = new ModelAndView();
			model.addObject("rmsg", "Registration Successful, please login!");
			model.setViewName("index");
			return model;
//			if() {
//				ModelAndView model = new ModelAndView();
//				model.addObject("rmsg", "Registration Successful, please login!");
//				model.setViewName("index");
//				return model;
//				
//			}else {
//				ModelAndView model = new ModelAndView();
//				model.addObject("ermsg", "Registration Failed");
//				model.setViewName("index");
//				return model;
//			
//			}
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/updateQuestion")
	public ModelAndView updateQuestion(HttpServletRequest request) {
		
		List<Answers> answerList = new ArrayList<Answers>();
		for(int i=0; i<4; i++) {
			Answers answer = new Answers();
			String content = request.getParameter("txtOption"+ (i+1));
			answer.setContent(content);
			answer.setCorrect(content.equalsIgnoreCase(request.getParameter("txtCorrectAnswer").strip()));
			answerList.add(answer);	
		}
		
		Questions question = new Questions();
		question.setQid(Integer.parseInt(request.getParameter("txtQid")));
		question.setQuestion(request.getParameter("txtQuestion"));
		question.setAnswers(answerList);
		
		questionsService.updateQuestion(question);
		
		return new ModelAndView("redirect:/teacher");
		
	
		
		
	}
	
	@PostMapping("insertQuestion")
	public ModelAndView insertQuestion(HttpServletRequest request){
	
		if(request.getParameter("btn-insert-question-submit") != null) {
			List<Answers> answerList = new ArrayList<Answers>();
			for(int i=0; i<4; i++) {
				Answers answer = new Answers();
				String content = request.getParameter("txtOption"+ (i+1)).toString();
				answer.setContent(content);
				answer.setCorrect(content.equalsIgnoreCase(request.getParameter("txtCorrectAnswer").toString().strip()));
				answerList.add(answer);	
			}
			
			Questions question = new Questions();
			//question.setQid(Integer.parseInt(request.getParameter("txtQid")));
			question.setQuestion(request.getParameter("txtQuestion"));
			question.setAnswers(answerList);
			questionsService.addQuestion(question);
			return new ModelAndView("redirect:/teacher");
		}else {
			return new ModelAndView("redirect:/teacher");
		}
		
		
	}
	
	
	
	
	
	@GetMapping("/exam/{id}")
	public ModelAndView startExam(@PathVariable("id") String quesNumber) {
		ModelAndView model = new ModelAndView();
		
		List<Questions> list = questionsService.fetchAllQuestions();
		System.out.println(list);
		model.addObject("question", list.get(Integer.parseInt(quesNumber) - 1));
		model.addObject("questionNumber", Integer.parseInt(quesNumber));
		model.setViewName("exam");
		return model;
	}
	
	@PostMapping("/exam/quizHandler")
	public ModelAndView quizHandler(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		int qid = Integer.parseInt(request.getParameter("txtQid"));
		int aid = Integer.parseInt(request.getParameter(qid + "option"));
		int questionNumber = Integer.parseInt(request.getParameter("txtQuestionNumber"));
		QuizForm quiz = new QuizForm();
		quiz.setUser(user);
		quiz.setQuestions(questionsService.fetchOneQuestion(qid));
		quiz.setAnswer(answersService.fetchOneAnswers(aid));
		if (quizFormService.getByUserIDQid(user.getUserid(), qid) != null) {
			int quizId = quizFormService.getByUserIDQid(user.getUserid(), qid).getQuizId();
			quiz.setQuizId(quizId);
			quizFormService.updateQuiz(quiz);
		}else {
			quizFormService.addNewQuiz(quiz);
		}
		
		ModelAndView model = new ModelAndView("redirect:/exam/" + (questionNumber + 1));
		return model;
		
		
	}
	
	@PostMapping("/submitExam")
	public ModelAndView submitExam(HttpServletRequest request) {
		int marks = 0;
		List<Questions> questionsList = questionsService.fetchAllQuestions();
		for(Questions question : questionsList ) {
			int qid = question.getQid();
			int aid = Integer.parseInt(request.getParameter(qid+"option"));
			
			if (answersService.fetchOneAnswers(aid).isCorrect()) {
				marks++;
			}
		}
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		String userid = user.getUserid();
		if(marksService.getMarks(userid) != null) {
			marksService.updateMarks(new Marks(marks, user));
		}else {
			marksService.addMarks(new Marks(marks, user));
		}
		
		return new ModelAndView("redirect:/student");
	}
	
	@GetMapping("/teacher")
	public ModelAndView teacher() {
		ModelAndView model = new ModelAndView();
		model.setViewName("teacher");
		return model;
	}
	
	@GetMapping("/uitest")
	public ModelAndView uiTest() {
		ModelAndView model = new ModelAndView();
		model.setViewName("uitest");
		return model;
	}
	
	@GetMapping("/dispQuestions")
	public ModelAndView teacherDisplayQuestions() {
		ModelAndView model = new ModelAndView();
		List<Questions> list = questionsService.fetchAllQuestions();
		model.addObject("questions", list);
		model.addObject("dispQuestions", "display");
		model.setViewName("teacher");
		return model;
	}
	
	@GetMapping("/dispMarkList")
	public ModelAndView DisplayMarks() {
		ModelAndView model = new ModelAndView();
		List<Marks> list = marksService.getMarkList();
		model.addObject("markList", list);
		model.addObject("dispMarkList", "display");
		model.setViewName("teacher");
		return model;
	}
	
	@GetMapping("/student")
	public ModelAndView student() {
		ModelAndView model = new ModelAndView();
		model.setViewName("student");
		return model;
	}
	
	
	
	
	@GetMapping("/logOut")
	public ModelAndView logOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/updateProfile")
	public ModelAndView updateProfile(HttpServletRequest request) {
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
				
				usersService.updateUser(user);
				session.setAttribute("user", user );
				session.setAttribute("msg", "Update Successful!");
				if(user.getRole().equalsIgnoreCase("teacher")) {
					return new ModelAndView("redirect:/teacher");
				}else {
					return new ModelAndView("redirect:/student");
				}
				
			}else {
				return new ModelAndView("redirect:/");
			}
		}else {
			return new ModelAndView("redirect:/");
		}
	
	}
	
	
}
