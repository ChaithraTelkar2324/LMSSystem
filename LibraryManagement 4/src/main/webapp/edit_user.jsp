<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<%@include file="all_css.jsp" %>
</head>
<body class="bg-light">

		<%@include file="navbar.jsp" %>
		
		<div class="container p-4">
		<div class="row">
		<div class="col-md-6 offset-md-3">
		<div class="card">
		<div class="card-body">
		<p class="fs-3 text-center">Edit User</p>
		
			<%
					int userId=Integer.parseInt(request.getParameter("userId"));
									UserDAO dao = new UserDAO(DBConnect.getConn());
									User s =dao.getuserById(userId);
					%>
		
		<form action="updateuser" method="post">
		
			  <div class="mb-3">
			    <label class="form-label">User Id</label>
			    <input readonly type="text" value="<%=s.getuserId()%>" name="userId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User First Name</label>
			    <input type="text" value="<%=s.getuserFName()%>"  name="userFName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User Last Name</label>
			    <input type="text" value="<%=s.getuserLName()%>"  name="userLName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User EmailId</label>
			    <input type="text" value="<%=s.getuserEmailId()%>"  name="userEmailId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User Course</label>
			    <input type="text" value="<%=s.getCourse()%>"  name="course" class="form-control">
			  </div>
			  
			   <div class="mb-3">
			    <label class="form-label">User Type</label>
			     <select class="form-select"  name="type" aria-label="Default select example">
				  <option value="user" <%= s.getType().equals("user") ? "selected" : "" %> >User</option>
				  <option value="faculty" <%= s.getType().equals("faculty") ? "selected" : "" %>>Faculty</option>
				   <option value="attendant" <%= s.getType().equals("attendant") ? "selected" : "" %>  >Attendant</option>
				</select>
			  </div>
			  
			   <div class="mb-3">
			    <label class="form-label">User Role</label>
			     <select class="form-select" name="role" aria-label="Default select example">
				  <option value="user" <%= s.getRole().equals("user") ? "selected" : "" %>>User</option>
				  <option value="admin" <%= s.getRole().equals("admin") ? "selected" : "" %>>Admin</option>
				  
				</select>
			  </div>
			  
			
			  
			  <div class="mb-3">
			    <label class="form-label">User Password</label>
			    <input type="text" value="<%=s.getuserPassword()%>"  name="userPassword" class="form-control">
			  </div>
			  
			  
			  <input type="hidden" name="userId" value="<%=s.getuserId()%>" >
			  
			  <button type="submit" class="btn btn-primary col-md-12">Update</button>
			</form>
		
		</div>
		</div>
		</div>
		</div>
		</div>
	
</body>
</html>