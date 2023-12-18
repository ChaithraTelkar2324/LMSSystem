<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
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
			  int bookId=Integer.parseInt(request.getParameter("bookId"));
			  BookDAO dao = new BookDAO(DBConnect.getConn());
			  Book b=dao.getBookById(bookId);
			  %>
		
		<form action="updatebook" method="post">
		
			  <div class="mb-3">
			    <label class="form-label">Book Id</label>
			    <input type="text" value="<%=b.getBookId()%>" name="bookId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Book Name</label>
			    <input type="text" value="<%=b.getBookName()%>"  name="bookName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Book Author</label>
			    <input type="text" value="<%=b.getBookAuthor()%>"  name="bookAuthor" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Description</label>
			    <input type="text" value="<%=b.getDescription()%>"  name="description" class="form-control">
			  </div>
			  
			  <input type="hidden" name="bookId" value="<%=b.getBookId()%>" >
			  
			  <button type="submit" class="btn btn-primary col-md-12">Update</button>
			</form>
		
		</div>
		</div>
		</div>
		</div>
		</div>
	
</body>
</html>