<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<style>
a{
display: inline-block;
margin: 30px;
}
form input{
position:fixed; 
right:30px; 
top:20px
}
</style>
</head>
<body>
<jsp:include page="/header" />
<br> <br>
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>

	<h3>This is Admin dashboard</h3>

	<a href="${pageContext.request.contextPath}/admin/product-list">List
		All Products</a>
	<a href="${pageContext.request.contextPath}/admin/product-entry">Add
		New Product</a>

</body>
<footer>
	<jsp:include page="/footer" />
</footer>
</html>