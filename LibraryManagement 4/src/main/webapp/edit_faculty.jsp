<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.FacultyDAO"%>
<%@page import="com.entity.Faculty"%>
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
		<p class="fs-3 text-center">Edit Student</p>
		
			<% 
			  int facultyId=Integer.parseInt(request.getParameter("facultyId"));
			FacultyDAO dao = new FacultyDAO(DBConnect.getConn());
			Faculty s=dao.getFacultyById(facultyId);
			  %>
		
		<form action="updatefaculty" method="post">
		
			  <div class="mb-3">
			    <label class="form-label">Faculty Id</label>
			    <input type="text" value="<%=s.getFacultyId()%>" name="facultyId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Faculty First Name</label>
			    <input type="text" value="<%=s.getFacultyFName()%>"  name="facultyFName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Faculty Last Name</label>
			    <input type="text" value="<%=s.getFacultyLName()%>"  name="facultyLName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Faculty EmailId</label>
			    <input type="text" value="<%=s.getFacultyEmailId()%>"  name="facultyEmailId" class="form-control">
			  </div>
			  
			  
			  <div class="mb-3">
			    <label class="form-label">Password</label>
			    <input type="text" value="<%=s.getFacultyPassword()%>"  name="facultyPassword" class="form-control">
			  </div>
			  
			  <input type="hidden" name="facultyId" value="<%=s.getFacultyId()%>" >
			  
			  <button type="submit" class="btn btn-primary col-md-12">Update</button>
			</form>
		
		</div>
		</div>
		</div>
		</div>
		</div>
	
</body>
</html>