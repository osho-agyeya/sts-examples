<%@page import="com.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://osho.com/training" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ELDemo</title>
</head>
<body>

<h2>JSP Expression Language</h2>

<h4>App Name: ${appName}</h4>

<h5>Name: ${name}</h5>

<h6>Message:${message}</h6>

<h5>Session Message:${sessionScope.message}</h5>
<h5>App Message:${applicationScope.message}</h5>

<p>Product Id--:${product.id}</p>
<p>Name:${product.name}</p>
<p>Price:${product.price}</p>




<%--
<%Product product =(Product)request.getAttribute("product"); %>

<p>
	Product ID:<%=product.getId() %>
	
</p>

<p>
	Name:<%=product.getName() %>
	
</p>

<p>
	Price:<%=product.getPrice() %>
	
</p>
--%>
</body>
</html>