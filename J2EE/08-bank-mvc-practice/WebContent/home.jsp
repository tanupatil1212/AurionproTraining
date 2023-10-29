<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Banking Application</title>
<style>
body {
	text-align: center;
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.container {
	margin: 100px auto;
	max-width: 300px;
	background: #fff;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin: 10px 0;
	text-align: left;
}

label {
	display: block;
}

select, input {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
}

select {
	margin-top: 5px;
}

button {
	width: 100%;
	background: #007BFF;
	color: #fff;
	border: none;
	padding: 10px;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
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
		<h2>Banking Application</h2>
		<form action="AdminController" method="post">
			<div class="form-group">
				<label for="userType">Select User Type:</label> <select
					id="userType" name="userType">
					<option value="user">User</option>
					<option value="admin">Admin</option>
				</select>
			</div>
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div class="form-group">
				<!-- Hidden input to store the selected user type -->
				<input type="hidden" id="userTypeInput" name="action" value="user">
				<button type="submit">Login</button>
			</div>
		</form>
		<script>
			// JavaScript to update the userTypeInput based on user selection
			document
					.getElementById("userType")
					.addEventListener(
							"change",
							function() {
								// Get the selected value from the dropdown
								var selectedValue = this.value;
								// Set the userTypeInput value to the selected value
								document.getElementById("userTypeInput").value = selectedValue;
							});
		</script>
	</div>
</body>
</html>
