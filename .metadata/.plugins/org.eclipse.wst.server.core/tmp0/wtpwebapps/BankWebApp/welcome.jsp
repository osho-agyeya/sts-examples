<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h2>Welcome to the Bank Application</h2>
	<%
	String email="",loggedInTime="";
		Cookie cookies[]=request.getCookies();
		if(cookies!=null){
		    for(Cookie ck:cookies){
		        if(ck.getName().equals("email")){
		            email=ck.getValue();
		        }
		        if(ck.getName().equals("loggedInTime")){
		            loggedInTime=ck.getValue();
		        }
		    }
		}
		
	%>
	<p>Logged in as <%=email %></p>
	<p>Logged in at <%=loggedInTime %></p>
	
	<a href="accounts">View Accounts</a>
	
	<a href="newAccount.jsp">Add new account</a>
	
	<form action="logout" method="post">
			<button type="submit">Logout</button>
	</form>
	
	
</body>
</html>