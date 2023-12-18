package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.BookDAO;
import com.entity.Book;

@WebServlet("/deletebook")
public class DeleteBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bookId=Integer.parseInt(req.getParameter("bookId"));
		
		BookDAO dao=new BookDAO(DBConnect.getConn());
		boolean f=dao.deleteBook(bookId);
		HttpSession session=req.getSession();
		
		
		if(f) {
			
			session.setAttribute("SuccMsg", "book details delete successfully....");
			resp.sendRedirect("index.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("index.jsp");
			//System.out.println("Somthing wrong in server....");
		}
	}

}
