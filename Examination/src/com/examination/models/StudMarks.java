package com.examination.models;

public class StudMarks extends Marks {
	private String studName;
	
	public StudMarks(String sid, int marks, String studName) {
		super(sid, marks);
		this.studName = studName;
		// TODO Auto-generated constructor stub
	}


	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	
}
