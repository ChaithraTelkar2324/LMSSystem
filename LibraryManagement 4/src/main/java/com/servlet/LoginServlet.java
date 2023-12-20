package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.LoginDAO;
import com.entity.Login;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		
		Login user = new Login(email, pass);
		
		System.out.println(user);
		
		LoginDAO dao=new LoginDAO(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		
		boolean f = dao.loginuser(user);
		
		
		System.out.print("error :" + f);
		
		if(f) {
			
			session.setAttribute("SuccMsg", "user details submit successfully....");
			resp.sendRedirect("index.jsp");
			//System.out.println("book details submit successfully....");
			
		}else {
			session.setAttribute("errorMsg", "Invalid Credentails or  No Access to application....");
			resp.sendRedirect("loginprocess.jsp");
			System.out.println("Somthing wrong in server....");
		}
		
	}

}
