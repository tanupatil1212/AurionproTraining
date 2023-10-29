<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
        }
        .container {
            margin: 40px auto;
            max-width: 600px;
            background: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .dashboard-button {
            margin: 10px;
            padding: 20px 40px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
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
    <h1>Welcome, User!</h1>
    <!-- Button Container -->
    <div class="button-container">
        <form action="TransactionPage.jsp" value=showmethod="get">
            <button class="dashboard-button" type="submit">Transaction</button>
        </form>
        <br>
        <form action="passbook.jsp" method="get">
            <button class="dashboard-button" type="submit">Passbook</button>
        </form>
        <br>
        <form action="EditProfile.jsp" method="get">
            <button class="dashboard-button" type="submit">Edit Profile</button>
        </form>
    </div>
</div>
 <form action="AdminController" method="post" class="logout-button">
        <button type="submit" name="action" value="logout">Logout</button>
    </form>
</body>
</html>
