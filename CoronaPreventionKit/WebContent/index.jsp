<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

	<a href="newUser.jsp"> Click here to proceed as Visitor </a>
	<br>
	<br>

	<form action="adminLogin" method="post">
		<h3>If you are Admin, Enter login credentials</h3>
		<br> <label>User Name: <input type="text" name="username">
		</label> <br> <label>Password: <input type="password"
			name="password">
		</label> <br>
		<button>Login</button>
	</form>

	<%
		if (request.getAttribute("message") != null) {
	%>
	<%
		String str = request.getAttribute("message").toString();
	%>
	 <%=str%>
	<%
		}
	%>
</body>

<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>