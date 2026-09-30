<%@page import="java.sql.*" %>
<%
String username= request.getParameter("username");
String password= request.getParameter("password");
try{
Class.forName("com.mysql.jdbc.Driver");
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/regislog?characterEncoding=Latin1","root","root");
PreparedStatementps= con.prepareStatement("select * from userdb where username=? and password=?");
ps.setString(1, username);
ps.setString(2, password);
ResultSetrs=ps.executeQuery();
if(rs.next())
    {
session.setAttribute("username", username);
response.sendRedirect("welcome.jsp");
    }
else
    {
out.println("invalid");
    }
con.close();
}
catch(Exception e)
{
out.println(e);
}
%>
