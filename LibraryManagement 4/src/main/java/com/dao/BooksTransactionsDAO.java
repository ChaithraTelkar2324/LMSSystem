package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BooksTransaction;

public class BooksTransactionsDAO {

	private Connection conn;

	public BooksTransactionsDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addBookTransaction(BooksTransaction booktransaction,int book,int unit) {
		boolean f=false;
		try {
			
			String sql ="insert into bookstransaction(user, book, unit, assigneddate, deadlinedate, fine) values (?, ?, ?, ?, ?, ?)";
			
			String sql1 ="update books set unit=unit-? where bookId=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			
			
			
			System.out.print("book" + book);
			System.out.print("unit" + unit);

			ps1.setInt(1, unit);
			ps1.setInt(2, book);
			
			int i1 = ps1.executeUpdate();
			
			ps.setInt(1, booktransaction.getuser());
			ps.setInt(2, booktransaction.getBook());
			ps.setInt(3, booktransaction.getUnit());
			ps.setString(4, booktransaction.getAssigneddate());
			ps.setString(5, booktransaction.getDeadlinedate());
			ps.setInt(6,  booktransaction.getFine());
			int i= ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
		public List<BooksTransaction> getAllBookTransaction(){
			List<BooksTransaction> list = new ArrayList<BooksTransaction>();
			BooksTransaction b = null;
			try {
				
				String sql="select * from bookstransaction";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				
			
				
				while(rs.next()) {
					
					b= new BooksTransaction();
					b.setId(rs.getInt(1));
					b.setuser(rs.getInt(2));
					b.setBook(rs.getInt(3));
					b.setUnit(rs.getInt(4));
					b.setAssigneddate(rs.getString(5));
					b.setDeadlinedate(rs.getString(6));
					b.setReturndate(rs.getString(7));
					b.setFine(rs.getInt(8));
					list.add(b);
					
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.print("error");
				
			}
			
			return list;
			
		}
			
		public BooksTransaction getBookTransactionById(int id) {
			BooksTransaction b = null;
			
//			System.out.print("id" + id);
			
			try {
				
				String sql="select * from bookstransaction where id=?";
				PreparedStatement ps =conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				

				while(rs.next()) {
					
					b = new BooksTransaction();
					b.setId(rs.getInt(1));
					b.setuser(rs.getInt(2));
					b.setBook(rs.getInt(3));
					b.setUnit(rs.getInt(4));
					b.setAssigneddate(rs.getString(5) != null ? rs.getString(5).substring(0,10) : "''");
					b.setDeadlinedate(rs.getString(6) != null ? rs.getString(6).substring(0,10) : "''");
					b.setReturndate(rs.getString(7) != null ? rs.getString(7).substring(0,10) : "''");
					b.setFine(rs.getInt(8));
					
					
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			System.out.print("error" + b);
			return b;
			
		}
	
	
	
		public boolean updateBookTransaction(BooksTransaction booktransaction,int book,int unit) {
			boolean f=false;
			try {
				
				String sql ="update bookstransaction set user=?, book=?, unit=?, assigneddate=?, deadlinedate=?, returndate=?, fine=? where id=?";
				String sql1 ="update books set unit=unit+? where bookId=? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				
				
				ps1.setInt(1, unit);
				ps1.setInt(2, book);
				
				int i1 = ps1.executeUpdate();
				System.out.print("i1" + i1);
				
				
				ps.setInt(1, booktransaction.getuser());
				ps.setInt(2, booktransaction.getBook());
				ps.setInt(3, 0);
				ps.setString(4, booktransaction.getAssigneddate());
				ps.setString(5, booktransaction.getDeadlinedate());
				ps.setString(6, booktransaction.getReturndate());
				ps.setInt(7,  booktransaction.getFine());
				ps.setInt(8,  booktransaction.getId());
				
				int i=ps.executeUpdate();
				if(i==1) {
					f=true;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
	
	
	public boolean deleteBookTransaction(int id) {
		
		boolean f=false;
		try {
			
			String sql ="delete from books where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
