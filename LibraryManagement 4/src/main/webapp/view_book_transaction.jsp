<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.BooksTransactionsDAO"%>
<%@page import="com.entity.BooksTransaction"%>
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
		<p class="text-center fs-1 ">All Books Transaction</p>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Book Id</th>
			      <th scope="col">User Id</th>
			      <th scope="col">No Of Copies</th>
			      <th scope="col">AssignedDate</th>
			      <th scope="col">DeadlineDate</th>
			      <th scope="col">ReturnDate</th>
			      <th scope="col">Fine</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			  <% 
			  
			  BooksTransactionsDAO dao = new BooksTransactionsDAO(DBConnect.getConn());
			  List<BooksTransaction> list = dao.getAllBookTransaction();
			  for(BooksTransaction b : list){
			  %>
			  
			  
			    <tr>
			      <th scope="row"><%=b.getBook() %></th>
			      <td><%=b.getuser() %></td>
				  <td><%=b.getUnit() %></td>
			      <td><%=b.getAssigneddate() %></td>
			      <td><%=b.getDeadlinedate() %></td>
			      <td><%=b.getReturndate() %></td>
			      <td><%=b.getFine() %></td>
			      <td><a href="edit_book_transaction.jsp?id=<%=b.getId()%>" class="btn btn-sm btn-primary">Edit</a>
			      
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

