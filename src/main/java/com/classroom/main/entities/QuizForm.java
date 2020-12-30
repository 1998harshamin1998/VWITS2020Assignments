package com.classroom.main.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "saved_quiz")
public class QuizForm {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "quizid")
    private int quizId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
	private Users user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qid")
	private Questions questions;
		
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aid")
	private Answers answer;

	public QuizForm() {
		super();
	}

	public QuizForm(Users user, Questions questions, Answers answer) {
		super();
		this.user = user;
		this.questions = questions;
		this.answer = answer;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public Answers getAnswer() {
		return answer;
	}

	public void setAnswer(Answers answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QuizForm [quizId=" + quizId + ", user=" + user + ", questions=" + questions + ", answer=" + answer
				+ "]";
	}
	
	
	
}
