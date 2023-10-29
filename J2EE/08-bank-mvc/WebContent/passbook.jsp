<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Passbook</title>
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

table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #ccc;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #007BFF;
	color: white;
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
	<h1>User Passbook</h1>
	<!-- <form action="AdminController" method="get">
	<input type="hidden name="user_id" value="${isUser.user_id}">
    <label for="startDate">Start Date:</label>
    <input type="date" name="startDate" id="startDate">
    <label for="endDate">End Date:</label>
    <input type="date" name="endDate" id="endDate">
    <input type="hidden" name="action" value="searchByDate">
    <button type="submit" >Search</button>
</form> -->
	<form action="AdminController" class="search-bar">
		<label for="startDate">Start Date:</label> <input type="hidden"
			name="user_id" value="${user_id}"> <input type="date"
			name="startDate" id="startDate"> <label for="endDate">End
			Date:</label> <input type="date" name="endDate" id="endDate"> <input
			type="hidden" name="action" value="searchTransactionByDate">
		<button type="submit">Search</button>
	</form>

	<table>
		<tr>
			<th>Transaction ID</th>
			<th>Account Number</th>
			<th>Transaction Type</th>
			<th>Transaction Time</th>
			<th>Description</th>
			<th>Amount</th>
		</tr>
		<c:forEach items="${userTransactions}" var="transactions">
			<tr>
				<td>${transactions.trans_id}</td>
				<td>${transactions.account_no}</td>
				<td>${transactions.transaction_type_id}</td>

				<td>${transactions.transaction_time}</td>
				<td>${transactions.description}</td>

				<td>${transactions.amount}</td>
			</tr>
		</c:forEach>

	</table>

	<form action="AdminController" method="get" class="logout-button">
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
