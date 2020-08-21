<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<h3>
		<b>Welcome Admin!!!</b>
	</h3>
	<br>
	<p>
		<a href="doListProducts">View Existing Products </a>
	</p>
	<P>
		<a href="newProduct.jsp">Create a New Product</a>
	</P>

</body>
<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>