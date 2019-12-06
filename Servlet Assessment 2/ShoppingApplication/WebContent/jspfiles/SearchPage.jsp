<%@page import="com.manthan.shoppingApplication.bean.UserInfoBean"%>
<%@page import="com.manthan.shoppingApplication.bean.ProductInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<%
	ArrayList<ProductInfoBean> al = (ArrayList<ProductInfoBean>) request.getAttribute("Products");
%>
<%
	UserInfoBean bean = (UserInfoBean) session.getAttribute("userinfo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div style="float: left;">
		<a href="">Order details</a>
	</div>
	<p style="font-size: 15px; color: red;">
		<%
			if (msg != null) {
		%>
		<%=msg%>
		<%
			}
		%>
	</p>
	<form action="./searchservlet">

		<input type="text" name="search" placeholder="Search products">&nbsp<input
			type="submit" value="Search">

	</form>

	<%
		if (al != null) {
	%>

	<%
		for (ProductInfoBean p : al) {
	%>
	<p>
		Product name:
		<%=p.getProduct_name()%></p>
	<p>
		Product cost:
		<%=p.getProduct_cost()%></p>
	<p>
		Product description:
		<%=p.getDescription()%></p>
	<p>
		Number of Product:
		<%=p.getNumber_of_products()%></p>
	<a href="orderServlet?prodID=<%=p.getProduct_id()%>&userID=<%=bean.getUserID()%>">Buy</a>
	<hr>

	<%
		}
	%>
	<%} %>

</body>
</html>