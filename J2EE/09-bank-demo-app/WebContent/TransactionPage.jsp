<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Transaction Page</title>
<style>
/* Add your CSS styles here */
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	text-align: center;
}

h1 {
	margin-top: 20px;
}

form {
	background-color: #fff;
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

label, input, select {
	display: block;
	margin: 10px 0;
}

input[type="text"], select {
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
	<h1>Perform a Transaction</h1>
	<form action="TransactionController" method="post">
		<label for="action">Select Action:</label> <select name="action"
			id="action">
			<option value="deposit">Deposit</option>
			<option value="withdraw">Withdraw</option>
		</select> <br> <label for="accountNo">Account Number:</label> <input
			type="text" name="accountNo" id="accountNo" required> <br>

		<label for="amount">Amount:</label> <input type="text" name="amount"
			id="amount" required> <br> <input type="submit"
			value="Submit">
	</form>
 <form action="AdminController" method="post" class="logout-button">
        <button type="submit" name="action" value="logout">Logout</button>
    </form>
</body>
</html>