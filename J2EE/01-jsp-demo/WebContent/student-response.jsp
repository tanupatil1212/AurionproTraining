<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Response</title>
</head>

<body>

  <div class="container">
        <h1 class="mt-5">Student Response Form</h1>
         <hr>
        <div class="alert alert-success mt-3">
            <p>Name: <%= request.getParameter("name") %></p>
            <p>Email: <%= request.getParameter("email") %></p>
            <p>Graduation Degree: <%=request.getParameter("degree") %></p>
            <p>Gender:<%=request.getParameter("gender") %></p>
            <p><strong>Favorite Programming Languages:</strong></p>
            <ul>
                <%-- Loop through selected languages --%>
                <%
                    String[] languages = request.getParameterValues("languages[]");
                    if (languages != null) {
                        for (String language : languages) {
                %>
                <li><%= language %></li>
                <%
                        }
                    }
                %>
            </ul>
        </div>
    </div>

</body>
</html>