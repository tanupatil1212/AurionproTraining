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
</style>
</head>
<body>
	<h1>User Passbook</h1>
	<table>
		<tr>
			<th>Transaction ID</th>
			<th>Account Number</th>
			<th>Transaction Type</th>
			<th>Transaction Time</th>
			<th>Description</th>
			<th>Amount</th>
		</tr>
		<c:forEach items="${transactions}" var="transaction" >
			<tr>
				<td>${transaction.trans_id}</td>
				<td>${transaction.account_no}</td>
				<td>${transaction.transaction_type_id}</td>
				<td>${transaction.transaction_time}</td>
				<td>${transaction.description}</td>
				<td>${transaction.amount}</td>
			</tr>
		</c:forEach>

	</table>
	 <form action="AdminController" method="post" class="logout-button">
        <button type="submit" name="action" value="logout">Logout</button>
    </form>
</body>
</html>
