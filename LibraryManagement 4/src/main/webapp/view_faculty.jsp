<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.FacultyDAO"%>
<%@page import="com.entity.Faculty"%>
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
		<p class="text-center fs-1 ">All Faculty</p>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Faculty Id</th>
			      <th scope="col">Faculty First Name</th>
			      <th scope="col">Faculty Last Author</th>
			      <th scope="col">Faculty EmailId</th>
			       <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			  <% 
			  
			  FacultyDAO dao = new FacultyDAO(DBConnect.getConn());
			  List<Faculty> list = dao.getAllFaculty();
			  for(Faculty f : list){
			  %>

			    <tr>
			      <th scope="row"><%=f.getFacultyId() %></th>
			      <td><%=f.getFacultyFName() %></td>
				  <td><%=f.getFacultyLName() %></td>
			      <td><%=f.getFacultyEmailId() %></td>
			      <td><a href="edit_faculty.jsp?facultyId=<%=f.getFacultyId()%>" class="btn btn-sm btn-primary">Edit</a>
			      <a href="deletefaculty?facultyId=<%=f.getFacultyId()%>" class="btn btn-sm btn-danger ms-1">Delete</a>
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