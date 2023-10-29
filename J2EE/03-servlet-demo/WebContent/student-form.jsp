<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<div class="container">
		<h1 class="mt-5">Student Form</h1>
		<hr>
		<form action="Student" method="POST">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name" required>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" required>
			</div>

			<div class="form-group">
				<label for="degree">Graduation Degree:</label> <select
					class="form-control" id="degree" name="degree">
					<option value="">Select</option>
					<option value="BE">BE</option>
					<option value="BSc">BSc</option>
					<option value="BCom">BCom</option>
				</select>
			</div>

			<div class="form-group">
				<label>Gender:</label><br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="male" value="Male"> <label class="form-check-label"
						for="male">Male</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="female" value="Female"> <label
						class="form-check-label" for="female">Female</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="other" value="Other"> <label class="form-check-label"
						for="other">Other</label>
				</div>
			</div>

			<div class="form-group">
				<label>Favorite Language:</label><br>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="languages[]"
						id="java" value="Java"> <label class="form-check-label"
						for="java">Java</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="languages[]"
						id="react" value="React"> <label class="form-check-label"
						for="react">React</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="languages[]"
						id="angular" value="Angular"> <label
						class="form-check-label" for="angular">Angular</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="languages[]"
						id="python" value="Python"> <label
						class="form-check-label" for="python">Python</label>
				</div>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>
