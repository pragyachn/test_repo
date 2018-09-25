<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String message=(String)request.getAttribute("mymessage");
out.println(message+"<br>");

%>

PLEASE FILL UP THE BOOK DETAILS:
<br>
<form action="addme" method="get">
ISBN:<input type ="text" name="isbn"><br>
NAME OF BOOK:<input type ="text" name="name"><br>
BOOK PRICE:<input type ="text" name="price"><br>
NAME OF AUTHOR:<input type ="text" name="author"><br>
NAME OF PUBLICATION:<input type ="text" name="publication"><br>
<input type="submit" value="ADD NEW BOOK">
</form>
</body>
</html>