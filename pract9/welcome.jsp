<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<%
    String user=(String)session.getAttribute("username");
if(user==null)
    {
response.sendRedirect("login.jsp");
    }
    %>
<html>
<body>
<h2>WELCOME JSP</h2>
<a href="logout.jsp">LOGOUT</a>
</body>
</html>

