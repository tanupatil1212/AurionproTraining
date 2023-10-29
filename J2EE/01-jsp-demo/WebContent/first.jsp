<%@ page import ="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Expression tag</h3>
 <h4>
  Current date
  <%=new Date()%></h4>
 <h4> Hello world in lower case</h4><%=new String("Hello").toLowerCase() %>
<br>
<h2>Scriptlet tags</h2>
<%
for(int i=1;i<=10;i++){
 out.println("i :"+i+ "<br>");
}
%>

<br>
<h2>declaration tag</h2>
<%!
String stringToUpper(String str){
 return str.toUpperCase();
}
%>
<h2>hello world in upper case <%= stringToUpper("Hello world in upper case") %></h2>
</body>
</html>