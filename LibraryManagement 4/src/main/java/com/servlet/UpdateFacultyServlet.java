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
import com.entity.Faculty;

@WebServlet("/updatefaculty")
public class UpdateFacultyServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int facultyId = Integer.parseInt(req.getParameter("facultyId"));
		String facultyFName = req.getParameter("facultyFName");
		String facultyLName = req.getParameter("facultyLName");
		String facultyEmailId = req.getParameter("facultyEmailId");
		String facultyPassword = req.getParameter("facultyPassword");
		
		Faculty faculty = new Faculty(facultyId, facultyFName, facultyLName, facultyEmailId, facultyPassword);
		
		System.out.println(faculty);
		
		
		FacultyDAO dao=new FacultyDAO(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		boolean f=dao.updateFaculty(faculty);
		if(f) {
			
			session.setAttribute("SuccMsg", "faculty details submit successfully....");
			resp.sendRedirect("view_faculty.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("view_faculty.jsp");
			System.out.println("Somthing wrong in server....");
		}
	}

}
