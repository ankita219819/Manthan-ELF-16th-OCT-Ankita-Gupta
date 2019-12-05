<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%String lmsg=(String)request.getAttribute("lmsg");%>
<%String rmsg=(String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>

	<div >
		<a style="float: right; color: black;" href="./Search-file" >Search</a>
	</div>
	<br>
	<div >
	
	
	<h1 align="center" style="color:mediumblue;">File Upload</h1>
	<h2 align="center" style="color:mediumblue;">Select a file to upload:</h2>
	<br />
	<br>
	
	<form action="./uploadServlet" method="post" enctype="multipart/form-data">
			<input style="margin-left: 40%; color:mediumblue;" type="file" name="file" size="50" />
		 	<br>
			<br> 
			<input style="margin-left: 40%; margin-bottom: 5%; background-color: mediumblue; border:none;border-radius: 7px;padding: 16px 32px;
  	text-align: center;
  	font-size: 13px; color:white;" type="submit" value="Upload File" />
	</form>
	<%if(lmsg!=null){ %>
		<p style="color: green; margin-left: 40%; "><%=lmsg%>
	<%} %>
	<%if(rmsg!=null){%>
		<p style="color: red; margin-left: 40%; "><%=rmsg %>
	<%} %>
	</div>
</body>
</body>

</html>