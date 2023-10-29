<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update-Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Add Student</h1>
		<form action="StudentController" method="get">
			<div class="mb-3">
				<label for="firstname" class="form-label">First Name</label> <input
					value="${student.first_name}" type="text" class="form-control"
					id="name" placeholder="Enter your name" name="firstname">
			</div>
			<div class="mb-3">
				<label for="lastname" class="form-label">Last Name</label> <input
					value="${student.last_name}" type="text" class="form-control"
					id="name" placeholder="Enter your name" name="lastname">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					value="${student.email}" type="email" class="form-control"
					id="email" placeholder="Enter your email" name="email">
			</div>
			<input type="hidden" name="action" value="update-save"> <input
				type="hidden" name="id" value="${student.id}">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>