<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get All User</title>
  	<%@include file="all_css.jsp" %>
</head>
<body class="bg-light">

		<%@include file="navbar.jsp" %>
		
		<%
				Connection conn = DBConnect.getConn(); 
								out.print(conn);
				%>

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
		<p class="text-center fs-1 ">All users</p>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">User</th>
			      <th scope="col">User First Name</th>
			      <th scope="col">User Last Name</th>
			      <th scope="col">User EmailId</th>
			      <th scope="col">User Course</th>
			      <th scope="col">User Type</th>
			       <th scope="col">User Role</th>
			      <th scope="col">User Password</th>
			       <th scope="col">User Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			  <%
			  			  UserDAO dao = new UserDAO(DBConnect.getConn());
			  			  	  			  	  List<User> list = dao.getAlluser();
			  			  	  			  	  for(User s : list){
			  			  %>

			    <tr>
			      <th scope="row"><%=s.getuserId() %></th>
			      <td><%=s.getuserFName() %></td>
				  <td><%=s.getuserLName() %></td>
			      <td><%=s.getuserEmailId() %></td>
			       <td><%=s.getCourse() %></td>
			       <td><%=s.getType() %></td>
			       <td><%=s.getRole() %></td>
			       <td><%=s.getuserPassword() %></td>
			      <td><a href="edit_user.jsp?userId=<%=s.getuserId()%>" class="btn btn-sm btn-primary">Edit</a>
			      <a href="deleteuser?userId=<%=s.getuserId()%>" class="btn btn-sm btn-danger ms-1">Delete</a>
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