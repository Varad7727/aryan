<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>Login page</h1>
<form action="loginaccess.jsp" method="post">
username:<input type="text" name="username" required><br>
password:<input type="password" name="password" required><br>
<input type="submit" value="LOGIN">

</form>
<a href="register.jsp">Register</a>
</body>
</html>
