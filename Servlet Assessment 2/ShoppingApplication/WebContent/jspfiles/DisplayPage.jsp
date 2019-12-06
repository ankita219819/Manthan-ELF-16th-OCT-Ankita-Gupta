<%@page import="com.manthan.shoppingApplication.bean.ProductInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%ArrayList<ProductInfoBean> al=(ArrayList<ProductInfoBean>)request.getAttribute("Products"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="SearchPage.jsp"/>

<%for(ProductInfoBean p:al){ %>
	<p>Product name:  <%=p.getProduct_name() %></p><br>
	<p>Product cost:  <%=p.getProduct_cost() %></p><br>
	<p>Product description:  <%=p.getDescription() %></p><br>
	<p>Number of Product: <%=p.getNumber_of_products() %></p><br><br><br><br><br><br>

<%} %>

</body>
</html>