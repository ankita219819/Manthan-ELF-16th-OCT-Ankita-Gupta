<%@page import="manthan.assessment.bean.Bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%Bean b=(Bean)session.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div></div><div style="float: right;"><a href=" ">Logout</a></div>

<br>
<h1 align="center">WELCOME</h1>

<p><%=b.getUsername() %>, welcome to our page.</p>
</body>
</html>