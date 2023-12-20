package com.entity;

public class User {
	
	private int userId;
	private String userFName;
	private String userLName;
	private String userEmailId;
	private String course;
	private String userPassword;
	private String type;
	private String role;
	
	
	
	public User() {
		super();
	}

	public User(String userFName, String userLName, String userEmailId, String course,
			String userPassword,String type,String role) {
		super();
		this.userFName = userFName;
		this.userLName = userLName;
		this.userEmailId = userEmailId;
		this.course = course;
		this.userPassword = userPassword;
		this.type = type;
		this.role = role;
		
	}

	public User(int userId, String userFName, String userLName, String userEmailId, String course,
			String userPassword,String type,String role) {
		super();
		this.userId = userId;
		this.userFName = userFName;
		this.userLName = userLName;
		this.userEmailId = userEmailId;
		this.course = course;
		this.userPassword = userPassword;
		this.type = type;
		this.role = role;
	}
	
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public String getuserFName() {
		return userFName;
	}
	public void setuserFName(String userFName) {
		this.userFName = userFName;
	}
	public String getuserLName() {
		return userLName;
	}
	public void setuserLName(String userLName) {
		this.userLName = userLName;
	}
	public String getuserEmailId() {
		return userEmailId;
	}
	public void setuserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getuserPassword() {
		return userPassword;
	}
	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFName=" + userFName + ", userLName=" + userLName + ", userEmailId="
				+ userEmailId + ", course=" + course + ", userPassword=" + userPassword + ", type=" + type + ", role="
				+ role + "]";
	}

}
