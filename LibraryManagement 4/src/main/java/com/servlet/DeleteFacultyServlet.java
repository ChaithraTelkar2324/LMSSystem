package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.FacultyDAO;

@WebServlet("/deletefaculty")
public class DeleteFacultyServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int facultyId=Integer.parseInt(req.getParameter("facultyId"));
		
		FacultyDAO dao=new FacultyDAO(DBConnect.getConn());
		boolean f=dao.deleteFaculty(facultyId);
		HttpSession session=req.getSession();
		
		
		if(f) {
			
			session.setAttribute("SuccMsg", "faculty details delete successfully....");
			resp.sendRedirect("view_faculty.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("view_faculty.jsp");
			//System.out.println("Somthing wrong in server....");
		}
	}


}
