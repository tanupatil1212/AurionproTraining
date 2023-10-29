<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- **************************************************** -->
	<!-- fn:contains() -->
	<c:set var="String" value="hello" />

	<c:if test="${fn:contains(String, 'hello')}">
		<p>Found hello string
		<p>
	</c:if>

	<c:if test="${fn:contains(String, 'HELLO')}">
		<p>Found HELLO string
		<p>
	</c:if>

	<!--fn:endsWith-->
	<c:set var="String" value=" learning" />

	<c:if test="${fn:endsWith(String, 'learning')}">
		<p>String ends with learning
		<p>
	</c:if>

	<c:if test="${fn:endsWith(String, 'JSTL')}">
		<p>String ends with JSTL
		<p>
	</c:if>
	<!-- **************************************************** -->
	<!-- fn:trim() Function -->
	<c:set var="str1" value="Welcome to JSP        programming         " />
	<p>String-1 Length is : ${fn:length(str1)}</p>

	<c:set var="str2" value="${fn:trim(str1)}" />
	<p>String-2 Length is : ${fn:length(str2)}</p>
	<p>Final value of string is : ${str2}</p>


	<!-- **************************************************** -->
	<!-- fn:toLowerCase() Function -->

	<c:set var="string" value="Welcome to JSP Programming" />
	${fn:toLowerCase("HELLO,")} ${fn:toLowerCase(string)}





</body>
</html>
