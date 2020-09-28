<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

<jsp:include page="${pageContext.request.contextPath}/header" />

	<a href="${pageContext.request.contextPath}/user/show-kit">Show Kit
		Details</a>
	<br>
	<br>

	<form:form action="/finalize">
		<form:label path="deliveryAddress">
			<h4>
				<b>Please enter the complete shipping address:</b>
			</h4>
			<form:textarea path="deliveryAddress" rows="4" cols="25"></form:textarea>
			<form:errors path="deliveryAddress" />
		</form:label>
		<form:button>Finalize</form:button>
	</form:form>

</body>
</html>