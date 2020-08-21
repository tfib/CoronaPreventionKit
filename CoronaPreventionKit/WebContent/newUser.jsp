<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<h3>
		<b> Welcome Visitor!!! </b>
	</h3>
	<h4>
		<b> Please fill the below details to proceed further.</b>
	</h4>
	<br>
	<br>
	<form action="userDetailsSave" method="post">
	<label> User Full Name: <input type="text" name="pName" required>
		</label> <br> <label> Mobile Number: <input type="text"
			name="pContact" pattern="[1-9][0-9]{9}"required></label><br> <label> e-mail:
			<input type="email" name="pEmail" required>
		</label><br>
		<button>Proceed to View Available Products</button>	
	</form>	

</body>
<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>