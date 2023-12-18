<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.entity.Student"%>
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
		<p class="text-center fs-1 ">All Students</p>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Student Id</th>
			      <th scope="col">Student First Name</th>
			      <th scope="col">Student Last Author</th>
			      <th scope="col">Student EmailId</th>
			         <th scope="col">Course</th>
			       <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			  <% 
			  
			  StudentDAO dao = new StudentDAO(DBConnect.getConn());
			  List<Student> list = dao.getAllStudent();
			  for(Student s : list){
			  %>

			    <tr>
			      <th scope="row"><%=s.getStudentId() %></th>
			      <td><%=s.getStudentFName() %></td>
				  <td><%=s.getStudentLName() %></td>
			      <td><%=s.getStudentEmailId() %></td>
			       <td><%=s.getCourse() %></td>
			      <td><a href="edit_student.jsp?studentId=<%=s.getStudentId()%>" class="btn btn-sm btn-primary">Edit</a>
			      <a href="deletestudent?studentId=<%=s.getStudentId()%>" class="btn btn-sm btn-danger ms-1">Delete</a>
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