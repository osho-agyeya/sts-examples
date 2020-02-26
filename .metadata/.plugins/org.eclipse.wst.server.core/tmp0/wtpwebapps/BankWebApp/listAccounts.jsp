<%@page import="com.model.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
</head>
<body>
	<h2>Accounts</h2>
	
	<%
		List<Account> accounts=(List<Account>)request.getAttribute("listAccounts");
	%>
	<%for(Account account:accounts){%>
		<div>
		<form action="deleteaccount" method="post">
			<p>Id:<input type="text" name="id" readonly value="<%=account.getId() %>"></p>
			<p>Name:<%=account.getName() %></p>
			<p>Balance:<%=account.getAmount() %></p>
			<button type="submit">Delete</button>
			<hr>
		</form>		
		</div>
	<%}%>
</body>
</html>