<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.entity.Student"%>
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
			  int studentId=Integer.parseInt(request.getParameter("studentId"));
			StudentDAO dao = new StudentDAO(DBConnect.getConn());
			Student s=dao.getStudentById(studentId);
			  %>
		
		<form action="updatestudent" method="post">
		
			  <div class="mb-3">
			    <label class="form-label">Student Id</label>
			    <input type="text" value="<%=s.getStudentId()%>" name="studentId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Book First Name</label>
			    <input type="text" value="<%=s.getStudentFName()%>"  name="studentFName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Student Last Name</label>
			    <input type="text" value="<%=s.getStudentLName()%>"  name="studentLName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Student EmailId</label>
			    <input type="text" value="<%=s.getStudentEmailId()%>"  name="studentEmailId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Course</label>
			    <input type="text" value="<%=s.getCourse()%>"  name="course" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Password</label>
			    <input type="text" value="<%=s.getStudentPassword()%>"  name="studentPassword" class="form-control">
			  </div>
			  
			  <input type="hidden" name="studentId" value="<%=s.getStudentId()%>" >
			  
			  <button type="submit" class="btn btn-primary col-md-12">Update</button>
			</form>
		
		</div>
		</div>
		</div>
		</div>
		</div>
	
</body>
</html>