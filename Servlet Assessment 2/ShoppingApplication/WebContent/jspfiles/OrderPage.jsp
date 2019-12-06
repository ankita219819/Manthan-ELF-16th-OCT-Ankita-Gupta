<%@page import="com.manthan.shoppingApplication.bean.OrderListBean"%>
<%@page import="com.manthan.shoppingApplication.bean.OrderInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	ArrayList<OrderListBean> al=(ArrayList<OrderListBean>)request.getAttribute("ormsg");
%>
<%
	String nornsg = (String) request.getAttribute("normsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="font-size: 15px; color: green;">
		<%
			if (al != null) {
		%>
		
		<%for(OrderListBean o:al){ %>
			<p>
			<%=o.getOrder_id() %>
			<%=o.getPrice() %>
			<%=o.getProduct_name() %>
			</p>
		
		<%} %>
		
		<%
			}
		%>
	</p>

	<p style="font-size: 15px; color: red;">
		<%
			if (nornsg != null) {
		%>
		<%=nornsg%>
		<%
			}
		%>
	</p>
	

	
</body>
</html>