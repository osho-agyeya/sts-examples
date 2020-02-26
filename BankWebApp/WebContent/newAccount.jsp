<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Account</title>
</head>
<body>

	<h2>New Account</h2>
	
	<form action="newaccount" method="post">
		<fieldset>
			<p>Full Name</p>
			<p>
				<input type="text" placeholder="Full name" name="fullName" required/>
			</p>
			<p>Balance</p>
			<p>
				<input type="number" placeholder="Balance" name="balance" min="0" required/>
			</p>
			<div>
				<button type="submit">Add new user</button>
			</div>
		</fieldset>
	</form>


</body>
</html>