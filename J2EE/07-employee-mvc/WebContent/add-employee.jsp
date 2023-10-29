<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Employee</title>
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
            margin: 0 auto;
            max-width: 200px;
            background-color: #007bff;
            color: #fff;
        }

        .btn-submit:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function validateForm() {
            var dobInput = document.getElementById("DOB");
            var eldInput = document.getElementById("ELD");
            var dobValue = dobInput.value;
            var eldValue = eldInput.value;
            var currentDate = new Date();
            var selectedDate = new Date(dobValue);
            var selectedEldDate = new Date(eldValue);

            if (selectedDate > currentDate || selectedEldDate > currentDate) {
                alert("Birthdate or Employee Leaving Date cannot be a future date.");
                dobInput.value = ""; // Clear the input field
                eldInput.value = ""; // Clear the input field
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Add Employee</h1>
    <div class="form-container">
        <form action="EmployeeController" method="get" onsubmit="return validateForm();">
            <div class="form-group">
                <label for="Emplid">ID</label>
                <input type="text" class="form-control" id="Emplid" name="Emplid">
            </div>
            <div class="form-group">
                <label for="firstname">First Name</label>
                <input type="text" class="form-control" id="firstname" name="firstname">
            </div>
            <div class="form-group">
                <label for="lastname">Last Name</label>
                <input type="text" class="form-control" id="lastname" name="lastname">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="DoJ">Date of Joining:</label>
                <input type="date" id="DoJ" name="DoJ" required>
            </div>
            <div class="form-group">
                <label for="DOB">Date of Birth:</label>
                <input type="date" id="DOB" name="DOB" required>
            </div>
            <div class="form-group">
                <label for="ELD">Employee Leaving Date:</label>
                <input type="date" id="ELD" name="ELD" required>
            </div>
        </div>
        <input type="hidden" name="action" value="add">
        <button class="btn btn-submit btn-block">Submit</button>
        </form>
    </div>
</div>
</body>
</html>