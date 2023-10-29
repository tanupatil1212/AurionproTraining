<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
/* Custom styles */
.form-container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
}

.btn-submit {
	
	background-color: #007bff;
	color: #fff;
}

.btn-submit:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Add Student</h1>
		<div class="form-container">
			<form action="StudentController" method="get">
				<div class="form-group">
					<label for="firstname">First Name</label> <input type="text"
						class="form-control" id="name" name="firstname">
				</div>

				<div class="form-group">
					<label for="lastname">Last Name</label> <input type="text"
						class="form-control" id="name" name="lastname">
				</div>

				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" name="email">
				</div>

				<input type="hidden" name="action" value="add">
				<button class="btn btn-submit btn-block">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>
