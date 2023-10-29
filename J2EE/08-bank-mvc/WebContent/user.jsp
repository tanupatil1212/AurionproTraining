<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<style>
/* Add your CSS styles here */
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
}

.container {
    max-width: 600px;
    margin: 40px auto;
    padding: 20px;
    background: #fff;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
}

.button-container {
    margin-top: 20px;
}

.dashboard-button, .button-link {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 18px;
    transition: background-color 0.3s;
    text-decoration: none; /* Remove underlines from links */
    margin: 5px; /* Add margin between links */
}

.dashboard-button:hover, .button-link:hover {
    background-color: #0056b3;
}

.logout-button {
    margin: 20px auto; /* Center the button horizontally */
    text-align: center; /* Center the button text within the container */
}

.logout-button button {
    padding: 10px 20px;
    background-color: #e74c3c;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.logout-button button:hover {
    background-color: #c04132;
}
</style>
</head>
<body>
    <div class="container">
       <h1>Welcome, <c:out value="${sessionScope.username}" /></h1>
        <!-- Button Container -->
        <div class="button-container">
           <!-- <form action="TransactionPage.jsp" method="get">
                <button class="dashboard-button" type="submit">Transaction</button>
            </form> -->
              <br>

            <a href="AdminController?action=showUserTransaction&user_id=<c:out value='${userId}' />"  class="button-link">Passbook</a>
            <br>
            <br>
            <a href="AdminController?action=Edit&user_id=<c:out value='${userId}' />" class="button-link">Edit Profile</a>
            <br>
            
            <br>

            <a href="AdminController?action=AccountsTransaction&user_id=<c:out value='${userId}' />"  class="button-link">Gpay</a>
            <br>
        </div>
    </div>
    <form action="AdminController" method="post" class="logout-button">
        <button type="submit" name="action" value="logout">Logout</button>
    </form>
</body>
</html>
