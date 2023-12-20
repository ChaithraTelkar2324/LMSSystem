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

/**
 * Servlet implementation class BookTransactionServlet
 */

@WebServlet("/booktransactionServlet")
public class BookTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTransactionServlet() {
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

		int user = Integer.parseInt(req.getParameter("user"));
		int book = Integer.parseInt(req.getParameter("book"));
		int fine = 0;
		int unit = Integer.parseInt(req.getParameter("unit"));
		String assigneddate = req.getParameter("assigneddate");
		String deadlinedate = req.getParameter("deadlinedate");
		String returndate = req.getParameter("returndate") == null ? "''" : req.getParameter("returndate") ;
		
		
		
		
		
		System.out.print("req.getParameter(\"returndate\")" + req.getParameter("returndate"));
		System.out.print("returndate" + returndate);
		
		
		BooksTransaction booktransaction = new BooksTransaction(user,book,unit,assigneddate,deadlinedate,returndate,fine);
		
		System.out.println(book);
		
		BooksTransactionsDAO dao=new BooksTransactionsDAO(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		
		boolean f = dao.addBookTransaction(booktransaction,book,unit);
		
		if(f) {
			
			session.setAttribute("SuccMsg", "book transaction details submit successfully....");
			resp.sendRedirect("add_book_transaction.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong in server....");
			resp.sendRedirect("add_book_transaction.jsp");
			System.out.println("Somthing wrong in server....");
		}
		
	}

}
