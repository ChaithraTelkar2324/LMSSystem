
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
<%@include file="navbarlogin.jsp" %>



<div class="container row justify-content-md-center p-3">


<c:if test="${not empty succMsg }">
		<p class="text-center text-sucess">${succMsg }</p>
		<c:remove var="succMsg"/>
		</c:if>
		
		<c:if test="${not empty errorMsg }">
		<p class="text-center text-danger">${errorMsg }</p>
		<c:remove var="errorMsg"/>
		
		</c:if>	
		
		<div class="card col-lg-4">
		<div class="card-body">
		<form action="loginServlet" method="post" >
		 <div class="mb-3">
			    <label class="form-label">Email</label>
			    <input type="text" name="email" class="form-control">
			  </div>
			  
			  <div class="mb-3">
			    <label class="form-label">Password</label>
			    <input type="text" name="pass" class="form-control">
			  </div>
			  
		
		<button type="submit" class="btn btn-primary col-md-12">Login</button>

</div>
</form>
</div>
</body>
</html>
