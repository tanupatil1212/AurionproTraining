<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>
<style>
/* Define your CSS styles here */
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.container {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
}

.dashboard-container {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.dashboard-heading {
	font-size: 24px;
	color: #333;
}

.button-container {
	margin-top: 20px;
	display: flex;
	justify-content: space-between;
}

.button-container button {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.button-container button:hover {
	background-color: #0056b3;
}

.registration-form {
	margin-top: 20px;
	padding: 20px;
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 5px;
}

.registration-form h2 {
	font-size: 20px;
	color: #333;
}

.registration-form input {
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.registration-form button {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.registration-form button:hover {
	background-color: #0056b3;
}

.logout-button {
	margin-top: 20px;
}

.logout-button button {
	padding: 10px 20px;
	background-color: #e74c3c;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.logout-button button:hover {
	background-color: #c04132;
}
</style>
</head>
<body>
	<div class="container">
		<div class="dashboard-container">
			<h1 class="dashboard-heading">Welcome to the Admin Dashboard</h1>
			<div class="button-container">
				<!-- Buttons for viewing users and transactions -->
				<form action="AdminController" method="get">
					<button type="submit" name="action" value="viewUsers">View
						Users</button>
					<button type="submit" name="action" value="showTransaction">View
						Transactions</button>
				</form>
			</div>
			<div class="registration-form">
				<h2>Create User Account</h2>
				<form action="AdminController" method="post"
					onsubmit="return validateForm()">
					<input type="text" name="fname" placeholder="First Name" required><br>
					<input type="text" name="lname" placeholder="Last Name" required><br>
					<input type="text" name="username" placeholder="Username" required><br>
					<!-- <input type="text" name="email" id="email"
						placeholder="Email (Gmail)" required> --><br> <input
						type="password" name="password" id="password"
						placeholder="Password" required><br>
					<button type="submit" name="action" value="createUser">Create
						User</button>
				</form>

	<!-- 			<script>
					function validateForm() {
						var emailInput = document.getElementById("email").value;
						var passwordInput = document.getElementById("password").value;
						var emailPattern = /^[A-Za-z0-9._%+-]+@gmail.com$/; // Gmail pattern
						var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/; // Password pattern (at least 8 characters with a mix of upper and lower case letters and digits)

						if (!emailPattern.test(emailInput)) {
							alert("Please enter a valid Gmail address.");
							return false;
						}

						if (!passwordPattern.test(passwordInput)) {
							alert("Password must be at least 8 characters long and contain a mix of upper and lower case letters and digits.");
							return false;
						}

						return true; // Form will be submitted if both validations pass
					}
				</script>
 -->
			</div>
		</div>
	</div>
	<!-- Include your logout form -->
	<form action="AdminController" method="post" class="logout-button">
		<button type="submit" name="action" value="logout">Logout</button>
	</form>
</body>
</html>
