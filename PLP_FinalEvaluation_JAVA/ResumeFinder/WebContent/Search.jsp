
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
input[type=text]{
	padding: 16px 32px;
	border-radius: 7px;
	border:0.1 solid grey;
	font-size: 16px;
	width:400pt;
	margin-left: 20%;
} 
input[type=submit] {

	background-color: #f4511e;
	border:none;
  	border-radius: 7px;
  	color: white;
  	padding: 16px 32px;
  	text-align: center;
  	font-size: 13px;
  	opacity: 0.6;
  	margin-left: 35%;
	
}
input[type=submit]:hover {opacity: 1;}

</style>
</head>
<body>

	<div style="float: right;"><a href="./upload-file">Upload</a></div>
	<br/>
	<form action="./SearchKey" >
	<input type="text" name="input" placeholder="search multiple values with comma"><br/><br/>
	<input type="submit" value="Search">
	</form>
</body>
</html>