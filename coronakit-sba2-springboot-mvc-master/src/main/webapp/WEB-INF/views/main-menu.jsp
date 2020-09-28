<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="${pageContext.request.contextPath}/header" />
</head>
<body>

<h2>Hello <security:authentication property="principal.username"/></h2>
<br/>

<hr/>
<h1>Welcome to Corona Kit Dashboard!!!</h1>

<security:authorize access="hasRole('ADMIN')">
	<hr/>
	<a href="${pageContext.request.contextPath}/admin/home">ADMIN DASHBOARD</a>
</security:authorize>

<security:authorize access="hasRole('USER')">
	<hr/>
	<a href="${pageContext.request.contextPath}/user/home">USER DASHBOARD</a>
</security:authorize>


</body>
<footer>
	<jsp:include page="${pageContext.request.contextPath}/footer" />
</footer>
</html>