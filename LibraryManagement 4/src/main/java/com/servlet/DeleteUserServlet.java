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

@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		boolean f=dao.deleteuser(userId);
		HttpSession session=req.getSession();
		
		
		if(f) {
			
			session.setAttribute("SuccMsg", "user delete successfully....");
			resp.sendRedirect("view_user.jsp");
			//System.out.println("user details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("view_user.jsp");
			//System.out.println("Something wrong in server....");
		}
	}

}
