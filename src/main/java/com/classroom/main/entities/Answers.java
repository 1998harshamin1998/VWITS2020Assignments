package com.classroom.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Answers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "aid")
    private int aid;
	
	@Column(name = "content")
    private String content;
	
	@Column(name = "correct")
    private Boolean correct;
	
	public Answers() {
		
	}

	public Answers(String content, Boolean correct) {
		super();
		this.content = content;
		this.correct = correct;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}

	public Boolean isCorrect() {
		return this.correct;
	}

	@Override
	public String toString() {
		return "Answers [aid=" + aid + ", content=" + content + ", correct=" + correct + "]";
	}
	
	
	
	
	
	

	
	
	
}
