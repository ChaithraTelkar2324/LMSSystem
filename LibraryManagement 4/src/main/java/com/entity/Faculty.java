package com.entity;

public class Faculty {
	
	private int facultyId;
	private String facultyFName;
	private String facultyLName;
	private String facultyEmailId;
	private String facultyPassword;
	
	
	public Faculty() {
		super();
	}
	public Faculty(String facultyFName, String facultyLName, String facultyEmailId, String facultyPassword) {
		super();
		this.facultyFName = facultyFName;
		this.facultyLName = facultyLName;
		this.facultyEmailId = facultyEmailId;
		this.facultyPassword = facultyPassword;
	}
	public Faculty(int facultyId, String facultyFName, String facultyLName, String facultyEmailId,
			String facultyPassword) {
		super();
		this.facultyId = facultyId;
		this.facultyFName = facultyFName;
		this.facultyLName = facultyLName;
		this.facultyEmailId = facultyEmailId;
		this.facultyPassword = facultyPassword;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyFName() {
		return facultyFName;
	}
	public void setFacultyFName(String facultyFName) {
		this.facultyFName = facultyFName;
	}
	public String getFacultyLName() {
		return facultyLName;
	}
	public void setFacultyLName(String facultyLName) {
		this.facultyLName = facultyLName;
	}
	public String getFacultyEmailId() {
		return facultyEmailId;
	}
	public void setFacultyEmailId(String facultyEmailId) {
		this.facultyEmailId = facultyEmailId;
	}
	public String getFacultyPassword() {
		return facultyPassword;
	}
	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyFName=" + facultyFName + ", facultyLName=" + facultyLName
				+ ", facultyEmailId=" + facultyEmailId + ", facultyPassword=" + facultyPassword + "]";
	}
	
	

}
