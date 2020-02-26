<%@page import="com.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Product</h2>
<%
Product  product = (Product)request.getAttribute("prd");
%>

<p>Id:<%=product.getId() %></p>
<p>Name:<%=product.getName() %></p>
<p>Price:<%=product.getPrice() %></p>
</body>
</html>