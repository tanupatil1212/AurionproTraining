<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Created Successfully</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .container {
            margin: 100px auto;
            max-width: 300px;
            background: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .dashboard-container {
            text-align: center;
        }
        .dashboard-heading {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        .user-details {
            background: #f4f4f4;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 20px;
        }
        .user-details p {
            margin: 0;
        }
        .button-container a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007BFF; /* Change to your desired background color */
            color: #fff; /* Text color */
            text-decoration: none;
            border: 1px solid #007BFF; /* Border color */
            border-radius: 5px;
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
    <div class="container">
        <div class="dashboard-container">
            <h1 class="dashboard-heading"> Successfully Done</h1>
            <div class="user-details">
                <!-- Include user details if needed -->
            </div>
            <div class="button-container">
                <a href="home.jsp">Back to Admin Dashboard</a>
            </div>
        </div>
    </div>
     <form action="AdminController" method="post" class="logout-button">
        <button type="submit" name="action" value="logout">Logout</button>
    </form>
</body>
</html>
