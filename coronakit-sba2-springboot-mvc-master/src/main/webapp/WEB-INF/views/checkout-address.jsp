<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<jsp:include page="${pageContext.request.contextPath}/header" />

	<spring-form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</spring-form:form>
	<a href="${pageContext.request.contextPath}/user/show-kit">Show Kit
		Details</a>
	<br>
	<br>

	<form action="${pageContext.request.contextPath}/user/finalize"
		method="post">
		<label>
			<h4>
				<b>Please enter the complete shipping address:</b>
			</h4> <textarea name="address" rows="4" cols="25"></textarea>
		</label>
		<button>Finalize</button>
	</form>
<footer>
	<jsp:include page="${pageContext.request.contextPath}/footer" />
</footer>
</body>
</html>