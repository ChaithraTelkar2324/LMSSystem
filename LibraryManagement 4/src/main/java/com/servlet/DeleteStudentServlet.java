package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.StudentDAO;

@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		
		StudentDAO dao=new StudentDAO(DBConnect.getConn());
		boolean f=dao.deleteStudent(studentId);
		HttpSession session=req.getSession();
		
		
		if(f) {
			
			session.setAttribute("SuccMsg", "book details delete successfully....");
			resp.sendRedirect("view_student.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("view_student.jsp");
			//System.out.println("Somthing wrong in server....");
		}
	}

}
