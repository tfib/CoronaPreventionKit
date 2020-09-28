<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<style>
form input{
position:fixed; 
right:30px; 
top:20px
}
</style>
</head>
<body>
<jsp:include page="/header" />
<br>
<br>
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>

<h1>This is User dashboard</h1>

	<a href="${pageContext.request.contextPath}/user/show-kit">Show Kit Details</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/user/show-list">List All Products</a>

<footer>
	<jsp:include page="/footer" />
</footer>
</body>
</html>