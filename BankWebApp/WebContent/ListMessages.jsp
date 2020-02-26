<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Messages</title>
</head>
<body>
	<h2>Messages</h2>

	<p>
	<h4>Global Message: <%=application.getAttribute("global") %></h4>
	<h4>Global Message:${global}</h4>
	</p>


	<%
	    List<String> messages = (List<String>) session.getAttribute("messages");
	%>
	<%
	    if (messages == null) {
	        out.println("<p>No messages</p>");
	    }
	%>
	<%
	    if (messages != null) {
	        for (String msg : messages) {
	%>


	<p>
		<%=msg%>
	</p>
	<%
	    }
	    }
	%>



</body>
</html>