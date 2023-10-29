<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>

<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #ccc;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:nth-child(odd) {
	background-color: #ffffff;
}
</style>
</head>
<body>
	<h1>Student List</h1>
	<hr>
	<hr>
	<br>
	<br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Percentage</th>
				<th>Remark</th>
			</tr>
		</thead>
		<c:forEach var="student" items="${allNewStudents}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.email}</td>
				<td>${student.percentage}</td>
				<td><c:choose>
						<c:when test="${student.percentage > 80}">Excellent</c:when>
						<c:when test="${student.percentage <= 70}">Good</c:when>
						<c:otherwise>All good, keep it up</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
