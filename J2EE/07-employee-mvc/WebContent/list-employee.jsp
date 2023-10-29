<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <style>
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #333;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #333;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
            
        }
        btn btn-primary:{
        margin: 300px;
        padding:20px;
        }
	.home-button {
    display: inline-block;
    background-color:#110730; /* Choose your desired background color */
    color: #000000;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    text-align: center;
    
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.home-button:hover {
    background-color: #0056b3; /* Change the color on hover */
}
	
        
       
    </style>
</head>

<body>

    <h1>Employee Information</h1>
	<div class="navbar">
    <div class="home-button">
        <a href="EmployeeController" class="navbar-brand">Home</a>
    </div>
</div>

<form action="EmployeeController" method="get">
    <div class="input-group mb-3">
        <select class="form-control" id="searchParameter" name="searchParameter">
            <option value="id">ID</option>
            <option value="EmpId">EmpID</option>
            <option value="firstName">First Name</option>
            <option value="lastName">Last Name</option>
            <option value="email">Email</option>
            <option value="DOJ">Date of Joining</option>
            <option value="DOB">Date of Birth</option>
            <option value="ELD">Employee Leaving Date</option>
        </select>
        <input type="text" class="form-control" id="searchValue" placeholder="Search" name="searchValue">
        <div class="input-group-append">
            <button class="btn btn-primary" type="submit">Search</button>
        </div>
    </div>
    <input type="hidden" name="action" value="search">
</form>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Employee ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Date of Joining</th>
            <th>Birth Date</th>
            <th>Employee Leaving Date</th>
            <th>Update</th>
            <th>Delete</th> <!-- Add this header for the "Update" button -->
        </tr>
        <c:forEach items="${allEmp}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.emp_ID}</td>
                <td>${employee.first_name}</td>
                <td>${employee.last_name}</td>
                <td>${employee.email}</td>
                <td>${employee.DOJ}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.ELD}</td>
                <td>
                   <a href="EmployeeController?action=update&id=${employee.id}" class="btn btn-primary">Update</a>
			
                </td>
                <td><a href="EmployeeController?action=delete&id=${employee.id}"
						class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
	
    <div style="text-align: center;">
        <a href="add-employee.jsp" class="btn btn-primary">Add Employee</a>
    </div>

</body>
</html>