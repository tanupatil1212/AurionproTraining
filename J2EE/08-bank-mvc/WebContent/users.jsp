<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>List of Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style>
/* Style for buttons */
.button {
	display: inline-block;
	padding: 10px 20px;
	background-color: #007BFF;
	color: #fff; /* Text color */
	text-decoration: none;
	border: 1px solid #007BFF; /* Border color */
	border-radius: 5px;
	margin-right: 10px; /* Adjust as needed */
}
</style>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<form action="AdminController" method="get">
			<div class="input-group mb-3">
				<input type="text" class="form-control"
					placeholder="Search by First Name" name="searchValue"> <select
					class="btn btn-info dropdown-toggle" name="searchParameter">
					<option value="id">User Id</option>
					<option value="firstName">First Name</option>
					<option value="lastName">Last Name</option>
					<option value="username">Username</option>
				</select>
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit">Search</button>
				</div>
			</div>
			<input type="hidden" name="action" value="search">
		</form>

		<h1>List of Users</h1>
		<table class="table table-bordered table-striped">
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Password</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.user_id}</td>
					<td>${user.fname}</td>
					<td>${user.lname}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>
						<!-- <a href="EditProfile.jsp?user_id=${user.user_id}" class="btn btn-primary">Edit Profile</a> -->
						<form action="AdminController" method="get">
							<input type="hidden" name="user_id" value="${user.user_id}">
							<input type="hidden" name="action" value="Edit">
							<button type="submit" class="btn btn-primary">Edit
								Profile</button>
						</form>
						
						 <a href="CreateAccount.jsp?user_id=${user.user_id}"
						class="btn btn-success">Create Account</a>
						
						
						<form action="AdminController" method="get">
							<input type="hidden" name="user_id" value="${user.user_id}">
							<input type="hidden" name="action" value="showUserAccounts">
							<button type="submit" class="btn btn-info">Show Accounts</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
