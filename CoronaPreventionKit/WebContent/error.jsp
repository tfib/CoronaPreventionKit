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
	<%
		String error = request.getAttribute("error").toString();
	%>
	<%=error%>
	
</body>

<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>