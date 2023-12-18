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

@WebServlet("/updatebook")
public class UpdateBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		String bookName = req.getParameter("bookName");
		String bookAuthor = req.getParameter("bookAuthor");
		String description = req.getParameter("description");
		
		Book book = new Book(bookId,bookName,bookAuthor,description);
		
		System.out.println(book);
		
		BookDAO dao=new BookDAO(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		boolean f=dao.updateBook(book);
		if(f) {
			
			session.setAttribute("SuccMsg", "book details submit successfully....");
			resp.sendRedirect("index.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("index.jsp");
			System.out.println("Somthing wrong in server....");
		}
	}
	
	

}
