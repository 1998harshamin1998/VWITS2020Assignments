package com.examination.models;

public class Marks {
	private String sid;
	private int marks;
	
	public Marks() {
		
	}
	
	public Marks(String sid, int marks) {
		super();
		this.sid = sid;
		this.marks = marks;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}
