<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<body>

	<fieldset>
	<form action="save" method="post">
	<p>
	Name
	</p>
	<div>
	<input placeholder="Name" name="name">
	</div>
	
	<p>
	Price
	</p>
	<div>
	<input placeholder="Price" name="price">
	</div>
	
	<p>
	Category
	</p>
	<div>
	<input placeholder="Category" name="category">
	</div>
	
	<p>
	Units in stock
	</p>
	<div>
	<input placeholder="Units" name="units">
	</div>
	
	<p>
	<button type="submit">Save</button>
	</p>
	
	</form>
	</fieldset>
</body>
</html>