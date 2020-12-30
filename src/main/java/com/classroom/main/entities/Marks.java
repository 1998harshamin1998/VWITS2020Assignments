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

@Entity
public class Marks {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "mid")
    private int mid;
	
	@Column(name = "marks")
    private int marks;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
	private Users user;
	
	public Marks () {
		
	}

	public Marks(int marks, Users user) {
		super();
		this.marks = marks;
		this.user = user;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Marks [mid=" + mid + ", marks=" + marks + ", user=" + user + "]";
	}
	
	
	
	
}
