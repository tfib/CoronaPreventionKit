<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<jsp:include page="/header" />
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>

<h1>This is User dashboard</h1>

	<a href="${pageContext.request.contextPath}/user/show-kit">Show Kit Details</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/user/show-list">List All Products</a>

<jsp:include page="/footer" />
</body>
</html>