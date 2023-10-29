<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create Account</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
}

h1 {
	color: #333;
}

form {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 5px #888;
	max-width: 300px;
	margin: 0 auto;
}

label {
	display: block;
	margin-top: 10px;
}

select, input {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

button {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

button:hover {
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
	<h1>Create Account</h1>
	<form action="AdminController" method="get">
		<input type="hidden" name="user_id" value="${param.user_id}" /> <label
			for="accountType">Account Type:</label> <select id="accountType"
			name="accountType" required>
			<option value="Saving">Saving</option>
			<option value="Current">Current</option>
		</select><br> <label for="amount">Amount:</label> <input type="text"
			id="amount" name="amount" required><br>

		<button type="submit" name="action" value="createAccount">Create
			Account</button>
	</form>
	<form action="AdminController" method="post" class="logout-button">
		<button type="submit" name="action" value="logout">Logout</button>
	</form>
	<br>
	<br>
	<div class="button-container">
		<a href="javascript:void(0);" onclick="goBack();">Back </a>
	</div>

	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>
