<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
    <p>
        <%
            List<String> styles = (List<String>) request.getAttribute("styles");
            if (styles != null) {
                for (String style : styles) {
                    out.print("<br>try: " + style);
                }
            } else {
                out.print("No beer styles available.");
            }
        %>
    </p>
</body>
</html>