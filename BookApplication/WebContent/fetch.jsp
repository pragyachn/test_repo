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

<form action ="update" method="post">
Select ISBN<select name="isbn">
<c:forEach var="boo" items="${bk }">
 <option>${boo.ISBN }</option>
</c:forEach>
</select><br>


updated price<input type="text" name="price"><br>
<input type="submit" value="CHANGE PRICE">

</form>

</body>
</html>