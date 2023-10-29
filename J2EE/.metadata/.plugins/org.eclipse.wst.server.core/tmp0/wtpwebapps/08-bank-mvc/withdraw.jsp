<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Withdraw</title>
<style>
/* Define your CSS styles here */
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	text-align: center;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	margin-top: 20px;
}

label, input {
	display: block;
	margin: 10px 0;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	background-color: #007BFF;
	color: white;
	border: none;
	border-radius: 5px;
	padding: 10px 20px;
	cursor: pointer;
	font-size: 16px;
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
		<h1>Withdraw from Account</h1>
		<form action="TransactionController" method="get">
			<input type="hidden" name="action" value="withdraw">
			 <input type="hidden" name="accountNo" value="${param.accountNo}">
			  <label for="amount">Amount to Withdraw:</label>
			   <input type="text" name="amount" id="amount" required> <input type="submit" value="Withdraw">
		</form>
	</div>
	<br>
	<br>
	<div class="button-container">
		<a href="AccountsTransaction.jsp">Back </a>
		<!-- <a href="javascript:void(0);" onclick="goBack();">Back </a> -->
	</div>
	<!-- 
	<script>
		function goBack() {
			window.history.back();
		}
	</script>
	
	 -->
</body>
</html>