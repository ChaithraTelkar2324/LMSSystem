package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.entity.Login;


public class LoginDAO {

	private Connection conn;

	public LoginDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean loginuser(Login login) {
		boolean f=false;
		try {
			
			String sql ="select 1 from users where userEmailId=? and userPassword=? and type=? and role=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, login.getEmail());
			ps.setString(2, login.getPass());
			ps.setString(3, "attendant");
			ps.setString(4, "admin");
			
		   ResultSet result = ps.executeQuery();
			

			
			if(result.next()) {
				f=true;
			}else {
				f=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
}
