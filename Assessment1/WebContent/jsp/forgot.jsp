<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%String msg= (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="font-size: 15px; color: red;"><%if(msg!=null){ %> <%=msg %><%} %></p>
	<form action="./forgotP" method="post">
		<table>
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><input type="text" name="uid" required></td>
			</tr>

			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td>:</td>
				<td><input type="password" name="cpassword" required></td>
			</tr>

			<tr>
				<td colspan="3" align="center">
				<td><input type="submit" name="Set" required></td>
			</tr>

		</table>


	</form>
</body>
</html>