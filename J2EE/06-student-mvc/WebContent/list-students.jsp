<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<br>
		<h1>Student List</h1>
		<!-- Search student -->
		<form action="StudentController" method="get">
			<div class="input-group mb-3">
				<select class="form-control" id="searchParameter"
					name="searchParameter">
					<option value="id">ID</option>
					<option value="firstName">First Name</option>
					<option value="lastName">Last Name</option>
					<option value="email">Email</option>
				</select> <input type="text" class="form-control" id="searchValue"
					placeholder="Search" name="searchValue">
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit">Search</button>
				</div>
			</div>
			<input type="hidden" name="action" value="search">
		</form>

		<table class="table table-striped table-hover">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="student" items="${allStud}">
				<c:url var="updateLink" value="StudentController">
					<c:param name="action" value="update" />
					<c:param name="id" value="${student.id}" />
				</c:url>
				<tr>
					<td>${student.id}</td>
					<td>${student.first_name}</td>
					<td>${student.last_name}</td>
					<td>${student.email}</td>
					<td><a href="${updateLink}" class="btn btn-warning">Update</a>
						<a href="StudentController?action=delete&id=${student.id}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

		<a href="add-student.jsp" class="btn btn-primary">Add Student</a>
	</div>
</body>
</html>
