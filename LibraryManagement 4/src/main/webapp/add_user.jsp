<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
<%@include file="all_css.jsp" %>
</head>
<body class="bg-light">

		<%@include file="navbar.jsp" %>
		
		<div class="container p-4">
		<div class="row">
		<div class="col-md-6 offset-md-3">
		<div class="card">
		<div class="card-body">
		<p class="fs-3 text-center">Add User</p>
		
		<c:if test="${not empty succMsg }">
		<p class="text-center text-success">${succMsg }</p>
		<c:remove var="succMsg"/>
		</c:if>
		
		<c:if test="${not empty errorMsg }">
		<p class="text-center text-success">${errorMsg }</p>
		<c:remove var="errorMsg"/>
		
		</c:if>
		
		<form action="userServlet" method="post">
		
			  <div class="mb-3">
			    <label class="form-label">User Id</label>
			    <input type="text" name="userId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User First Name</label>
			    <input type="text" name="userFName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User Last Name</label>
			    <input type="text" name="userLName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User Email Id</label>
			    <input type="text" name="userEmailId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User Course</label>
			    <input type="text" name="course" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">User Type</label>
			     <select class="form-select" name="type" aria-label="Default select example">
				  <option value="student" selected>Student</option>
				  <option value="faculty" >Faculty</option>
				  <option value="attendant" >Attendant</option>
				  
				</select>
			  </div>
			  
			   <div class="mb-3">
			    <label class="form-label">User Role</label>
			     <select class="form-select" name="role" aria-label="Default select example">
				  <option value="user" selected>User</option>
				  <option value="admin">Admin</option>
				  
				</select>
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Enter Password</label>
			    <input type="text" name="userPassword" class="form-control">
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