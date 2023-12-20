package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.BooksTransactionsDAO;
import com.entity.BooksTransaction;


@WebServlet("/updatebooktransaction")
public class UpdateBookTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		System.out.print("Test");
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.print("id" + id);
		int user = Integer.parseInt(req.getParameter("user"));
		int book = Integer.parseInt(req.getParameter("book"));
		int unit = Integer.parseInt(req.getParameter("unit"));
		String assigneddate = req.getParameter("assigneddate");
		String deadlinedate = req.getParameter("deadlinedate");
		String returndate = req.getParameter("returndate");
		int fine = Integer.parseInt(req.getParameter("fine"));
		
		

//		System.out.print("book" + book);
//		System.out.print("student" + student);
//		System.out.print("unit" + unit);
//		System.out.print("assigneddate" + assigneddate);
//		System.out.print("deadlinedate" + deadlinedate);
//		System.out.print("returndate" + returndate);
//		System.out.print("unit" + unit);
//		System.out.print("fine" + fine);
		
		
		
		BooksTransaction booktransaction = new BooksTransaction(id,user,book,unit,assigneddate,deadlinedate,returndate,fine);
		
//		System.out.println(book);
		
		BooksTransactionsDAO dao = new BooksTransactionsDAO(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		boolean f=dao.updateBookTransaction(booktransaction,book,unit);
		if(f) {
			
			session.setAttribute("SuccMsg", "book transacti details submit successfully....");
			resp.sendRedirect("view_book_transaction.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server 111....");
			resp.sendRedirect("view_book_transaction.jsp");
			System.out.println("Somthing wrong in server 111....");
		}
	}

}
