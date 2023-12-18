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
		
		<div class="container p-4">
		<div class="row">
		<div class="col-md-6 offset-md-3">
		<div class="card">
		<div class="card-body">
		<p class="fs-3 text-center">Register as Student</p>
		
		<c:if test="${not empty succMsg }">
		<p class="text-center text-success">${succMsg }</p>
		<c:remove var="succMsg"/>
		</c:if>
		
		<c:if test="${not empty errorMsg }">
		<p class="text-center text-success">${errorMsg }</p>
		<c:remove var="errorMsg"/>
		
		</c:if>
		
		<form action="studentServlet" method="post">
		
			  <div class="mb-3">
			    <label class="form-label">Student Id</label>
			    <input type="text" name="studentId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Student First Name</label>
			    <input type="text" name="studentFName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Student Last Name</label>
			    <input type="text" name="studentLName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Student Email Id</label>
			    <input type="text" name="studentEmailId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Course</label>
			    <input type="text" name="course" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Enter Password</label>
			    <input type="text" name="studentPassword" class="form-control">
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