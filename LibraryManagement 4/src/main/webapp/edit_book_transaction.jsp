<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.BooksTransactionsDAO"%>
<%@page import="com.entity.BooksTransaction"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.BookDAO"%>
<%@page import="com.entity.Book"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_css.jsp" %>
</head>
<body class="bg-light">

		<%@include file="navbar.jsp" %>
		
		<div class="container p-4">
		<div class="row">
		<div class="col-md-6 offset-md-3">
		<div class="card">
		<div class="card-body">
		<p class="fs-3 text-center">Edit Book</p>
		
			<% 
			 	int id= Integer.parseInt(request.getParameter("id"));
				BooksTransactionsDAO dao = new BooksTransactionsDAO(DBConnect.getConn());
				BooksTransaction b = dao.getBookTransactionById(id);
			
			    UserDAO dao1 = new UserDAO(DBConnect.getConn());
				List<User> s = dao1.getAlluser();
					
				BookDAO dao2 = new BookDAO(DBConnect.getConn());
				List<Book> b1 = dao2.getAllBook();
			  %>
			  
		
			  
			  <form action="updatebooktransaction" method="post">
		
		      <input hidden type="text" name="id" value="<%=b.getId()%>" class="form-control">
		      
		      <div class="mb-3">
			    <label class="form-label">Select Book</label>
			    
			    <select class="form-select"  aria-label="Default select example" name="book">
			   		<%
				    for(Book b2 : b1){
				    %>	
				       <option <%= b.getBook() == b2.getBookId() ? "selected" : "" %>  value="<%= b2.getBookId() %>"><%= b2.getBookName() %></option>
				    <%
				    }
				    %>
			    </select>
			    
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Select User</label>
			    <select class="form-select" aria-label="Default select example" name="user">
				    <%
				    for(User u : s){
				    %>	
				       <option <%= b.getuser() == u.getuserId() ? "selected" : "" %> value="<%=u.getuserId() %>"><%= u.getuserFName() %></option>
				    <%
				    }
				    %>
				    
			    </select>
			  </div>
			  
			  
			  
			  <div class="mb-3">
			    <label class="form-label">Assign Date</label>
			    <input readonly type="date" name="assigneddate" value="<%=b.getAssigneddate()%>" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">DeadLine Date</label>
			    <input readonly type="date" name="deadlinedate" value="<%=b.getDeadlinedate()%>" class="form-control">
			  </div>
			  
			   <div class="mb-3">
			    <label class="form-label">No Of Copies</label>
			    <input readonly type="number" min=1 max=100 name="unit" value="<%=b.getUnit()%>" class="form-control">
			  </div>
			  
			 <div class="mb-3">
			    <label class="form-label">Return Date</label>
			    <input   type="date" name="returndate" value="<%=b.getReturndate()%>"  class="form-control">
			  </div>
			  
			   <div class="mb-3">
			    <label class="form-label">Fine</label>
			    <input  type="number" min=1 name="fine" value="<%=b.getFine()%>"  class="form-control">
			  </div>
			  
			  
		
			 
			  <button type="submit" class="btn btn-primary col-md-12">Update</button>
			</form>
		
		
		
		</div>
		</div>
		</div>
		</div>
		</div>
	
</body>
</html>