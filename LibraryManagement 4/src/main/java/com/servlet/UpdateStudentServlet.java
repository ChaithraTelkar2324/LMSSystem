package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.entity.Student;
import com.dao.StudentDAO;

@WebServlet("/updatestudent")
public class UpdateStudentServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		String studentFName = req.getParameter("studentFName");
		String studentLName = req.getParameter("studentLName");
		String studentEmailId = req.getParameter("studentEmailId");
		String course = req.getParameter("course");
		String studentPassword = req.getParameter("studentPassword");
		
		Student student = new Student(studentId,studentFName,studentLName,studentEmailId,course, studentPassword);
		
		System.out.println(student);
		
		
		StudentDAO dao=new StudentDAO(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		boolean f=dao.updateStudent(student);
		if(f) {
			
			session.setAttribute("SuccMsg", "book details submit successfully....");
			resp.sendRedirect("view_student.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("view_student.jsp");
			System.out.println("Somthing wrong in server....");
		}
	}

}
