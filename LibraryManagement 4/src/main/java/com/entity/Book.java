package com.entity;

public class Book {
	
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String description;
	private int unit;
	
	
	public Book() {
		super();
	}
	public Book(String bookName, String bookAuthor, String description,int unit) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.description = description;
		this.unit = unit;
	}
	public Book(int bookId, String bookName, String bookAuthor, String description, int unit) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.description = description;
		this.unit = unit;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", description="
				+ description + ", unit=" + unit + "]";
	}
	
	
	

}
