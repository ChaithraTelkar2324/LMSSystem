<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.BookDAO"%>
<%@page import="com.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Book Transaction</title>
<%@include file="all_css.jsp" %>
</head>
<body class="bg-light">

		<%@include file="navbar.jsp" %>
		
		<div class="container p-4">
		<div class="row">
		<div class="col-md-6 offset-md-3">
		<div class="card">
		<div class="card-body">
		<p class="fs-3 text-center">Assign Book</p>
		
		<c:if test="${not empty succMsg }">
		<p class="text-center text-success">${succMsg }</p>
		<c:remove var="succMsg"/>
		</c:if>
		
		<c:if test="${not empty errorMsg }">
		<p class="text-center text-success">${errorMsg }</p>
		<c:remove var="errorMsg"/>
		
		</c:if>
		
		 <%
		    UserDAO dao = new UserDAO(DBConnect.getConn());
			List<User> s = dao.getAlluser();
				
			BookDAO dao1 = new BookDAO(DBConnect.getConn());
			List<Book> b = dao1.getAllBook();
	    %>
					
		
		<form action="booktransactionServlet" method="post">
		
			  <div class="mb-3">
			    <label class="form-label">Select Book</label>
			    <div class="mb-3">
			    <select class="form-select" aria-label="Default select example" name="book">
			   		 <%
				    for(Book b1 : b){
				    %>	
				       <option value="<%= b1.getBookId() %>"><%= b1.getBookName() %></option>
				    <%
				    }
				    %>
			    </select>
			   
			   
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Select User</label>
			     <div class="mb-3">
			     <select class="form-select" aria-label="Default select example" name="user">
			    <%
			    for(User u : s){
			    %>	
			       <option value="<%= u.getuserId() %>"><%= u.getuserFName() %></option>
			    <%
			    }
			    %>
			    
			    </select>
			   
			  </div>
			    <!-- <input type="text" name="student" class="form-control"> -->
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Assign Date</label>
			    <input type="date" name="assigneddate" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">DeadLine Date</label>
			    <input type="date" name="deadlinedate" class="form-control">
			  </div>
			  
			   <div class="mb-3">
			    <label class="form-label">No Of Copies</label>
			    <input type="number" value=1 readonly name="unit" class="form-control">
			  </div>
			  
			  
			  <button type="submit" class="btn btn-primary col-md-12">Submit</button>
</form>
		
		</div>
		</div>
		</div>
		</div>
		</div>
	
</body>
</html>