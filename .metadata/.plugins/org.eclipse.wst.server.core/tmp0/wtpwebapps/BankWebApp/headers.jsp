<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Request Headers</h2>

	<%
	    Enumeration<String> keys = request.getHeaderNames();
	%>

	<table>
		<thead>
			<tr>
				<th>Key</th>
				<th>Value</th>
			</tr>
		</thead>
		<tbody>

			<%
			    while (keys.hasMoreElements()) {
			        String key = keys.nextElement();
			%>

			<tr>
				<td><%=key%></td>
				<td><%=request.getHeader(key)%></td>
			</tr>
			<%
			    }
			%>
		</tbody>
	</table>

</body>
</html>