<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
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
/* Add your CSS styles here */
body {
	font-family: Arial, sans-serif;
}

.container {
	margin: 40px;
}

.form-container {
	border: 1px solid #ccc;
	padding: 20px;
	border-radius: 5px;
}

.form-container input[type="text"], .form-container input[type="password"]
	{
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 5px;
}

.form-container button {
	background-color: #333;
	color: white;
	padding: 10px 20px;
	border: none;
	cursor: pointer;
}

.btn-submit {
	background-color: #333; /* Background color */
	color: white; /* Text color */
	padding: 10px 20px; /* Padding */
	border: none; /* Remove the default button border */
	cursor: pointer;
}

.btn-submit:hover {
	background-color: #555; /* Change the background color on hover */
}
.button-container a {
	display: inline-block;
	padding: 10px 20px;
	background-color: #007BFF;
	/* Change to your desired background color */
	color: #fff; /* Text color */
	text-decoration: none;
	border: 1px solid #007BFF; /* Border color */
	border-radius: 5px;
}

</style>
</head>
<body>
	<div class="container">
		<h1>Edit Profile</h1>
		<form action="AdminController" method="get">
			<!-- Changed method to POST -->
			<div class="mb-3">
				<label for="firstname" class="form-label">First Name</label> <input
					value="${user.fname}" type="text" class="form-control" id="fname"
					placeholder="Enter your firstname" name="fname">
			</div>
			<div class="mb-3">
				<label for="lastname" class="form-label">Last Name</label> <input
					value="${user.lname}" type="text" class="form-control" id="lname"
					placeholder="Enter your lastname" name="lname">
			</div>
			<div class="mb-3">
				<label for="username"class "form-label">Username</label> <input
					value="${user.username}" type="username" class="form-control"
					id="username" placeholder="Enter your Username" name="username">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> <input
					value="${user.password}" type="password" class="form-control"
					id="password" placeholder="Enter your Password" name="password">
			</div>
			<!-- Corrected parameter name to user_id -->
			<input type="hidden" name="action" value="Edit-save"> <input
				type="hidden" name="user_id" value="${user.user_id}">
			<button class="btn btn-submit btn-block">Submit</button>
		</form>
		<br> <br>
		<div class="button-container">
			<a href="javascript:void(0);" onclick="goBack();">Back </a>
		</div>

		<script>
			function goBack() {
				window.history.back();
			}
		</script>
	</div>
</body>
</html>
