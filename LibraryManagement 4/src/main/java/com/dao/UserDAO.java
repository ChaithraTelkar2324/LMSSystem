package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;



public class UserDAO {
	
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean adduser(User user) {
		boolean f=false;
		try {
			
			String sql ="insert into users(userId, userFName, userLName, userEmailId, course, userPassword,type,role) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getuserId());
			ps.setString(2, user.getuserFName());
			ps.setString(3, user.getuserLName());
			ps.setString(4,  user.getuserEmailId());
			ps.setString(5, user.getCourse());
			ps.setString(6, user.getuserPassword());
			ps.setString(7, user.getType());
			ps.setString(8, user.getRole());
			
			int i=ps.executeUpdate();
			
			
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
		public List<User> getAlluser(){
			List<User> list = new ArrayList<User>();
			User s = null;
			try {
				
				String sql="select * from users";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					s= new User();
					s.setuserId(rs.getInt(1));
					s.setuserFName(rs.getString(2));
					s.setuserLName(rs.getString(3));
					s.setuserEmailId(rs.getString(4));
					s.setCourse(rs.getString(5));
					s.setuserPassword(rs.getString(6));
					s.setType(rs.getString(7));
					s.setRole(rs.getString(8));
					list.add(s);
					
					
				}
			}catch(Exception e) {
				
			}
			
			return list;
			
		}
			
		public User getuserById(int userId) {
			User s=null;
			
			try {
				
				String sql="select * from users where userId=?";
				PreparedStatement ps =conn.prepareStatement(sql);
				ps.setInt(1, userId);
				ResultSet rs=ps.executeQuery();
				
				System.out.print("detail fetch" + rs);
				while(rs.next()) {
					
					s= new User();
					s.setuserId(rs.getInt(1));
					s.setuserFName(rs.getString(2));
					s.setuserLName(rs.getString(3));
					s.setuserEmailId(rs.getString(4));
					s.setCourse(rs.getString(5));
					s.setuserPassword(rs.getString(6));
					s.setType(rs.getString(7));
					s.setRole(rs.getString(8));
					
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			return s;
			
		}
	
	
	
		public boolean updateuser(User user) {
			boolean f=false;
			try {
				
				String sql ="update users set userFName=?, userLName=?, userEmailId=?, course=?, userPassword=?, type=?, role=? where userId=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, user.getuserFName());
				ps.setString(2,  user.getuserLName());
				ps.setString(3, user.getuserEmailId());
				ps.setString(4, user.getCourse());
				ps.setString(5, user.getuserPassword());
				ps.setString(6, user.getType());
				ps.setString(7, user.getRole());
				ps.setInt(8, user.getuserId());
				
		
				
				int i=ps.executeUpdate();
				if(i==1) {
					f=true;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
	
	
	public boolean deleteuser(int userId) {
		
		boolean f=false;
		try {
			
			String sql ="delete from users where userId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
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
