<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header" />
	<h1>Welcome to Corona-Kit Home...</h1>
	<hr />
	<a href="${pageContext.request.contextPath}/custom-login"><input
		type="button" value="Login" /></a>
	<hr />
</body>
<footer>
	<jsp:include page="${pageContext.request.contextPath}/footer" />
</footer>
</html>