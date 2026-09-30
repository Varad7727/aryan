<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>Register Page</h1>
<form action="Registeraccess.jsp" method="post">
            Enter username <input type="text" name="username" required><br>
            Enter password <input type="password" name="password" required><br>
<input type="submit" value="Register"><br>
<a href="login.jsp">LOGIN</a>
</form></body></html>

Registeraccess.jsp
<%@page import="java.sql.*" %>
<%
String username= request.getParameter("username");
String password= request.getParameter("password");
try{
Class.forName("com.mysql.jdbc.Driver");
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/regislog?characterEncoding=Latin1","root","root");
PreparedStatementps= con.prepareStatement("insert into userdb(username,password) values(?,?)");
ps.setString(1, username);
ps.setString(2, password);
inti = ps.executeUpdate();
if(i>0)
    {
out.println("REgistration successful");
out.println("<br><a href='login.jsp'>LOgin HERE</a>");
    }
con.close();
}
catch(Exception e)
{
out.println(e);
}
%>
