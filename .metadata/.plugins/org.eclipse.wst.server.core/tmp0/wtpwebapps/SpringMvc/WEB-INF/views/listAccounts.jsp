<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
</head>
<body>

<h3>List Accounts</h3>

<table border="1px">
	<thead>
		<tr>
			<th>Account ID</th>
			<th>Name</th>
			<th>Balance</th>
		</tr>
	</thead>
	<!--  now we will use a tag library -->
	<tbody>
	
	<c:forEach var="acc" items="${allAccounts}">
	<tr>
	<td>${acc.id }</td>
	<td>${acc.name }</td>
	<td>${acc.balance}</td>
	<td><a href="toUpdateAccountJSP?id=${acc.id}" />Edit</a></td>
	</tr>
	</c:forEach>
		
	</tbody>
</table>

</body>
</html>