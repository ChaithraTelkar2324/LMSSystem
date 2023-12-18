package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book;

public class BookDAO {
	
	private Connection conn;

	public BookDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addBook(Book book) {
		boolean f=false;
		try {
			
			String sql ="insert into books(bookId, bookName, bookAuthor, description) values (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setString(3,  book.getBookAuthor());
			ps.setString(4, book.getDescription());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
		public List<Book> getAllBook(){
			List<Book> list = new ArrayList<Book>();
			Book b = null;
			try {
				
				String sql="select * from books";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					b= new Book();
					b.setBookId(rs.getInt(1));
					b.setBookName(rs.getString(2));
					b.setBookAuthor(rs.getString(3));
					b.setDescription(rs.getString(4));
					list.add(b);
					
					
				}
			}catch(Exception e) {
				
			}
			
			return list;
			
		}
			
		public Book getBookById(int bookId) {
			Book b=null;
			
			try {
				
				String sql="select * from books where bookId=?";
				PreparedStatement ps =conn.prepareStatement(sql);
				ps.setInt(1, bookId);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					b= new Book();
					b.setBookId(rs.getInt(1));
					b.setBookName(rs.getString(2));
					b.setBookAuthor(rs.getString(3));
					b.setDescription(rs.getString(4));
					
					
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			return b;
			
		}
	
	
	
		public boolean updateBook(Book book) {
			boolean f=false;
			try {
				
				String sql ="update books set bookName=?, bookAuthor=?, description=? where bookId=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				
				ps.setString(1, book.getBookName());
				ps.setString(2,  book.getBookAuthor());
				ps.setString(3, book.getDescription());
				ps.setInt(4, book.getBookId());
				
				int i=ps.executeUpdate();
				if(i==1) {
					f=true;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
	
	
	public boolean deleteBook(int bookId) {
		
		boolean f=false;
		try {
			
			String sql ="delete from books where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, bookId);
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	
	

}
