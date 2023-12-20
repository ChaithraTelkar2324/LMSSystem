
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
		<p class="fs-3 text-center">Add Book</p>
		
		<c:if test="${not empty succMsg }">
		<p class="text-center text-success">${succMsg }</p>
		<c:remove var="succMsg"/>
		</c:if>
		
		<c:if test="${not empty errorMsg }">
		<p class="text-center text-success">${errorMsg }</p>
		<c:remove var="errorMsg"/>
		
		</c:if>
		
		<form action="bookServlet" method="post">
		
			  <div class="mb-3">
			    <label class="form-label">Book Id</label>
			    <input type="text" name="bookId" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Book Name</label>
			    <input type="text" name="bookName" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Book Author</label>
			    <input type="text" name="bookAuthor" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Description</label>
			    <input type="text" name="description" class="form-control">
			  </div>
			  
			   <div class="mb-3">
			    <label class="form-label">No Of Copies</label>
			    <input type="number" min=1 max=100 name="unit" class="form-control">
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