<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h1>Welcome to Corona-Kit Home...</h1>
	<hr />
	<p> Please click on Login button to Continue </p>
	<a href="${pageContext.request.contextPath}/custom-login"><input
		type="button" value="Login" /></a>
	<hr />
</body>
<footer>
	<jsp:include page="/footer" />
</footer>
</html>