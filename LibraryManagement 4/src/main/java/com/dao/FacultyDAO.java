package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Faculty;

public class FacultyDAO {
	
	private Connection conn;

	public FacultyDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addFaculty(Faculty faculty) {
		boolean f=false;
		try {
			
			String sql ="insert into Faculty(facultyId, facultyFName, facultyLName, facultyEmailId, facultyPassword) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, faculty.getFacultyId());
			ps.setString(2, faculty.getFacultyFName());
			ps.setString(3, faculty.getFacultyLName());
			ps.setString(4,  faculty.getFacultyEmailId());
			ps.setString(5, faculty.getFacultyPassword());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
		public List<Faculty> getAllFaculty(){
			List<Faculty> list = new ArrayList<Faculty>();
			Faculty s = null;
			try {
				
				String sql="select * from Faculty";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					s= new Faculty();
					s.setFacultyId(rs.getInt(1));
					s.setFacultyFName(rs.getString(2));
					s.setFacultyLName(rs.getString(3));
					s.setFacultyEmailId(rs.getString(4));
					s.setFacultyPassword(rs.getString(5));
					list.add(s);
					
					
				}
			}catch(Exception e) {
				
			}
			
			return list;
			
		}
			
		public Faculty getFacultyById(int facultyId) {
			Faculty s=null;
			
			try {
				
				String sql="select * from Faculty where facultyId=?";
				PreparedStatement ps =conn.prepareStatement(sql);
				ps.setInt(1, facultyId);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					s= new Faculty();
					s.setFacultyId(rs.getInt(1));
					s.setFacultyFName(rs.getString(2));
					s.setFacultyLName(rs.getString(3));
					s.setFacultyEmailId(rs.getString(4));
					s.setFacultyPassword(rs.getString(5));
					
					
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			return s;
			
		}
	
	
		public boolean updateFaculty(Faculty faculty) {
			boolean f=false;
			try {
				
				String sql ="update Faculty set facultyFName=?, facultyLName=?, facultyEmailId=?, facultyPassword=? where facultyId=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, faculty.getFacultyFName());
				ps.setString(2,  faculty.getFacultyLName());
				ps.setString(3, faculty.getFacultyEmailId());
				ps.setString(4, faculty.getFacultyPassword());
				ps.setInt(5, faculty.getFacultyId());
				
				int i=ps.executeUpdate();
				if(i==1) {
					f=true;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
	
	
	public boolean deleteFaculty(int facultyId) {
		
		boolean f=false;
		try {
			
			String sql ="delete from Faculty where facultyId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, facultyId);
			
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
