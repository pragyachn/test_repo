<%@page import="com.beans.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<table border="1">
	<c:forEach var="book" items="${books }">
	<tr> 
		
		
		<td><c:out value="${book.name}"></c:out></td>
		<td><c:out value="${book.ISBN}"></c:out></td>
		<td><c:out value="${book.price}"></c:out></td>
		<td><c:out value="${book.author}"></c:out></td>
		<td><c:out value="${book.publication}"></c:out></td>
	<td><a href="delete?ISBN=<c:out value='${ book.ISBN}'/>">DELETE</a></td>
	</tr>
	 </c:forEach>
</table>


</body>
</html>