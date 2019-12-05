<%@page import="com.manthan.resume.Bean.ResumeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%ArrayList<ResumeBean> al=(ArrayList<ResumeBean>)request.getAttribute("resumeBean"); %>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

table {
	border-collapse: collapse;
	margin-left: 20%;
	width:450pt;
}
th, td {
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
	background-color: #f2f2f2;
}

</style>
</head>
<body>
<jsp:include page="Search.jsp" /> 
<br>
<br> 
<table>
<%if(al!=null && !al.isEmpty()){ %>
	<tr>
		<th>Email ID</th>
		<th>File Name</th>
		<th>Download</th>
	</tr>
	<%for(ResumeBean rs:al){ %>
	<tr>
	
		<td><%=rs.getFileID() %></td>
		<td><%=rs.getFileName() %></td>
		<td><a href="Download?filename=<%=rs.getFileName()%>"  download> <i class="fa fa-download"></i></a></td>
	</tr>
	<%} %>
	<%} %>

</table>
</body>
</html>