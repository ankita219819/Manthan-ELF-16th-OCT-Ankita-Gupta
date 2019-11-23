<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
	
<%String msg= (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="font-size: 15px; color: red;"><%if(msg!=null){ %> <%=msg %><%} %></p>
	<fieldset>
		<legend>LogIn</legend>
		<form action="./loginM" method="post">

			<table>

				<tr>
					<td>User Id</td>
					<td>:</td>
					<td><input type="number" name="uid" <%if(msg=="Locked"){%> disabled="disabled"><%} %></td>

				</tr>


				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" <%if(msg=="Locked"){%> disabled="disabled"><%} %></td>

				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="LogIn"></td>
				</tr>
				
				<tr>
					<td colspan="3"><a href="./Register"><input type="submit" value="Add Me"></a></td>
				</tr>
				
				<tr>
					<td colspan="3"><a href="./forgot">Forgot password</a></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>