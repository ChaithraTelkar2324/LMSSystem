package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;


@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userFName = req.getParameter("userFName");
		String userLName = req.getParameter("userLName");
		String userEmailId = req.getParameter("userEmailId");
		String course = req.getParameter("course");
		String userPassword = req.getParameter("userPassword");
		String type = req.getParameter("type");
		String role = req.getParameter("role");
		
		User user = new User(userId, userFName, userLName, userEmailId, course, userPassword,type,role);
		
		System.out.println(user);
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		
		boolean f = dao.adduser(user);
		
		if(f) {
			
			session.setAttribute("SuccMsg", "user details submit successfully....");
			resp.sendRedirect("view_user.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("view_user.jsp");
			System.out.println("Somthing wrong in server....");
		}
		
		
	}
	
	

}
