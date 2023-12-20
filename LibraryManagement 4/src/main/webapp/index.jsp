<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
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
<title>Insert title here</title>
  	<%@include file="all_css.jsp" %>
</head>
<body class="bg-light">

		<%@include file="navbar.jsp" %>
		
		

		<div class="container p-3">
		<div class="card">
		<div class="card-body">
		
		<c:if test="${not empty succMsg }">
		<p class="text-center text-success">${succMsg }</p>
		<c:remove var="succMsg"/>
		</c:if>
		
		<c:if test="${not empty errorMsg }">
		<p class="text-center text-success">${errorMsg }</p>
		<c:remove var="errorMsg"/>
		
		</c:if>	
		<p class="text-center fs-1 ">All Books</p>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Book Id</th>
			      <th scope="col">Book Name</th>
			      <th scope="col">Book Author</th>
			      <th scope="col">Description</th>
			      <th scope="col">No Of Copies</th>
			       <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			  <% 
			  
			  BookDAO dao = new BookDAO(DBConnect.getConn());
			  List<Book> list = dao.getAllBook();
			  for(Book b : list){
			  %>
			  
			  
			    <tr>
			      <th scope="row"><%=b.getBookId() %></th>
			      <td><%=b.getBookName() %></td>
				  <td><%=b.getBookAuthor() %></td>
			      <td><%=b.getDescription() %></td>
			      <td><%=b.getUnit() %></td>
			      <td><a href="edit_book.jsp?bookId=<%=b.getBookId()%>" class="btn btn-sm btn-primary">Edit</a>
			      <a href="deletebook?bookId=<%=b.getBookId()%>" class="btn btn-sm btn-danger ms-1">Delete</a>
			      </td>
			    </tr>
			    
			     <%
			  }
			  %>
				 
			  </tbody>
			</table>
		</div>
		</div>
		</div>


</body>
</html>

