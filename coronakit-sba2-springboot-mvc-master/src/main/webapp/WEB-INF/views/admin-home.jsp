<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<jsp:include page="/header" />

<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>

	<h1>This is Admin dashboard</h1>

	<a href="${pageContext.request.contextPath}/admin/product-list">List
		All Products</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/admin/product-entry">Add
		New Product</a>

</body>
<footer>
	<jsp:include page="/footer" />
</footer>
</html>