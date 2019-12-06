<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="./registerServlet" method="post">
		<table>
			<tr>
				<td>User Id: </td>
				<td>:</td>
				<td><input type="text" name="uid" required></td>
			</tr>

			<tr>
				<td>User Name: </td>
				<td>:</td>
				<td><input type="text" name="uname" required></td>
			</tr>

			<tr>
				<td>Email ID: </td>
				<td>:</td>
				<td><input type="email" name="email" required></td>
			</tr>

			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password" required></td>
			</tr>
			
			<tr>

				<td colspan="3" align="center">
				<td><input type="submit" name="register" value="Register">
				</td>
			</tr>

		</table>


	</form>
</body>
</html>