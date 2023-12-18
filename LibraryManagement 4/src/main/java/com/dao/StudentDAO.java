package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;



public class StudentDAO {
	
	private Connection conn;

	public StudentDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addStudent(Student student) {
		boolean f=false;
		try {
			
			String sql ="insert into students(studentId, studentFName, studentLName, studentEmailId, course, studentPassword) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, student.getStudentId());
			ps.setString(2, student.getStudentFName());
			ps.setString(3, student.getStudentLName());
			ps.setString(4,  student.getStudentEmailId());
			ps.setString(5, student.getCourse());
			ps.setString(6, student.getStudentPassword());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
		public List<Student> getAllStudent(){
			List<Student> list = new ArrayList<Student>();
			Student s = null;
			try {
				
				String sql="select * from students";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					s= new Student();
					s.setStudentId(rs.getInt(1));
					s.setStudentFName(rs.getString(2));
					s.setStudentLName(rs.getString(3));
					s.setStudentEmailId(rs.getString(4));
					s.setCourse(rs.getString(5));
					s.setStudentPassword(rs.getString(6));
					list.add(s);
					
					
				}
			}catch(Exception e) {
				
			}
			
			return list;
			
		}
			
		public Student getStudentById(int studentId) {
			Student s=null;
			
			try {
				
				String sql="select * from students where studentId=?";
				PreparedStatement ps =conn.prepareStatement(sql);
				ps.setInt(1, studentId);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					s= new Student();
					s.setStudentId(rs.getInt(1));
					s.setStudentFName(rs.getString(2));
					s.setStudentLName(rs.getString(3));
					s.setStudentEmailId(rs.getString(4));
					s.setCourse(rs.getString(5));
					s.setStudentPassword(rs.getString(6));	
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			return s;
			
		}
	
	
	
		public boolean updateStudent(Student student) {
			boolean f=false;
			try {
				
				String sql ="update students set studentFName=?, studentLName=?, studentEmailId=?, course=?, studentPassword=? where studentId=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, student.getStudentFName());
				ps.setString(2,  student.getStudentLName());
				ps.setString(3, student.getStudentEmailId());
				ps.setString(4, student.getCourse());
				ps.setString(5, student.getStudentPassword());
				ps.setInt(6, student.getStudentId());
				
				int i=ps.executeUpdate();
				if(i==1) {
					f=true;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
	
	
	public boolean deleteStudent(int studentId) {
		
		boolean f=false;
		try {
			
			String sql ="delete from students where studentId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, studentId);
			
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
