<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<h2>Login</h2>
	
	<%	
		System.out.println("Hello scriplet");// this going to service
		String email = request.getParameter("email");
        
		String password = request.getParameter("pwd"); // we have to end with a semicolon
	    if(email == null){
	        email="";
	    }
	%>
	<form action="validate" method="post">
		<fieldset>
			<p>Email</p>
			<p>
				<input type="text" placeholder="Email" name="email" value="<%=email%>">
			</p>
			<p>Password</p>
			<p>
				<input type="text" placeholder="Password" name="pwd"/>
			</p>
			<div>
				<button type="submit">Login</button>
			</div>
		</fieldset>
	</form>


</body>
</html>