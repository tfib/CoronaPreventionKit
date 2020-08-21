<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Prevention Kit Portal</title>
</head>
<body>
<h2> CORONA PREVENTION KIT PORTAL</h2>
<br>
<%if(!request.getServletPath().equalsIgnoreCase("/index.jsp")) {%>
<a href="index.jsp">Home Page</a>
<%} %>
&nbsp;&nbsp;&nbsp;
	<%if(!(session.getAttribute("isAdmin")==null)) { %>
	<a href="logout"> logout</a>
	<%} %>
</body>
</html>