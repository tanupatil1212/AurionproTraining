<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Accounts</title>
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

.account-list {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	font-size: 24px;
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #333;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
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

.action-buttons {
	text-align: center;
}

.action-buttons form {
	display: inline;
	margin: 0 5px;
}

.action-buttons input[type="submit"] {
	background-color: #007BFF;
	color: white;
	border: none;
	border-radius: 5px;
	padding: 5px 10px;
	cursor: pointer;
	font-size: 14px;
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
		<div class="account-list">
			<h1>User Accounts</h1>
			<p>User ID: ${user_id}</p>
			<table>
				<thead>
					<tr>
						<th>Account Number</th>
						<th>Account Type</th>
						<th>Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${accounts}" var="account">
						<tr>
							<td>${account.accountno}</td>
							<td>${account.accounttype}</td>
							<td>${account.amount}</td>
							<td class="action-buttons">
								<form action="withdraw.jsp" method="get">
									<input type="hidden" name="accountNo"
										value="${account.accountno}"> <input type="submit"
										value="Withdraw">
								</form>
								<form action="deposit.jsp" method="get">
									<input type="hidden" name="accountNo"
										value="${account.accountno}"> <input type="submit"
										value="Deposit">
								</form>
							</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>
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
	<form action="AdminController" method="post" class="logout-button">
		<button type="submit" name="action" value="logout">Logout</button>
	</form>
</body>
</html>
