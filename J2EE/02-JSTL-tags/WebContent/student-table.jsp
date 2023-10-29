<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.List, java.util.ArrayList, com.aurionpro.model.Student"%>
	<%@page import="com.aurionpro.model.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
  List<Student> students = new ArrayList<>();
  students.add(new Student(1, "tanuja", "tanuja@gmail.com", 70));
  students.add(new Student(2, "vedant", "vedant@gmail.com", 77));
  students.add(new Student(3, "Lokesh", "lokesh@gmail.com", 87));
  
  pageContext.setAttribute("Students", students);
 %>
 
 <table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Percentage</th>
            <th>Remark</th>
        </tr>
    </thead>
    <c:forEach var="student" items="${Students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.percentage}</td>
            <td>
                <c:choose>
                    <c:when test="${student.percentage > 85}">
                        Distinction
                    </c:when>
                    <c:otherwise>
                        Pass
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>