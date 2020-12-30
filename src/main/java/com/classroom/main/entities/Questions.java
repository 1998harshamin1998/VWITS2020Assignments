package com.classroom.main.entities;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@Column(name="qid")
	private int qid;
	
	@Column(name="question")
	private String question;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "qid")
	private List<Answers> Answers;
	
	public Questions() {
		
	}

	

	public Questions(String question, List<Answers> answers) {
		super();
		this.question = question;
		Answers = answers;
	}



	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answers> getAnswers() {
		return Answers;
	}

	public void setAnswers(List<Answers> answers) {
		Answers = answers;
	}

	@Override
	public String toString() {
		return "Questions [qid=" + qid + ", question=" + question + ", Answers=" + Answers + "]";
	}
	
	
}
