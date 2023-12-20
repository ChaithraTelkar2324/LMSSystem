package com.entity;

public class BooksTransaction {
	private int id;
	private int user;
	private int book;
	private int unit;
	private String assigneddate;
	private String deadlinedate;
	private String returndate;
	private int fine;
	
	
	public BooksTransaction() {
		super();
	}
	

	public BooksTransaction(int user, int book, int unit, String assigneddate, String deadlinedate, String returndate,
			 int fine) {
		super();
		this.user = user;
		this.book = book;
		this.unit = unit;
		this.assigneddate = assigneddate;
		this.deadlinedate = deadlinedate;
	    this.returndate = returndate;
		this.fine = fine;
	}
	
	
	public BooksTransaction(int id, int user, int book, int unit, String assigneddate, String deadlinedate, String returndate,
			 int fine) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
		this.unit = unit;
		this.assigneddate = assigneddate;
		this.deadlinedate = deadlinedate;
		this.returndate = returndate;
		this.fine = fine;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuser() {
		return user;
	}
	public void setuser(int user) {
		this.user = user;
	}
	public int getBook() {
		return book;
	}
	public void setBook(int book) {
		this.book = book;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public String getAssigneddate() {
		return assigneddate;
	}
	public void setAssigneddate(String assigneddate) {
		this.assigneddate = assigneddate;
	}
	public String getDeadlinedate() {
		return deadlinedate;
	}
	public void setDeadlinedate(String deadlinedate) {
		this.deadlinedate = deadlinedate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}


	@Override
	public String toString() {
		return "BooksTransaction [id=" + id + ", user=" + user + ", book=" + book + ", unit=" + unit + ", assigneddate="
				+ assigneddate + ", deadlinedate=" + deadlinedate + ", returndate=" + returndate + ", fine=" + fine
				+ "]";
	}


	
	
	
	
}
