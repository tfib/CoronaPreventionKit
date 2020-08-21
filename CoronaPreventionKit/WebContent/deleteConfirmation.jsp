<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<br>
	<p>
		<a href="doListProducts">View Products List</a>
	</p>
	<br>
	<%
		if (request.getAttribute("Message") != null) {
	%>
	<%
		String message = request.getAttribute("Message").toString();
	%>
	<%=message%>
	<%
		}
	%>
</body>
<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>