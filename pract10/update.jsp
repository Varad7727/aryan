<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<%
       String eno=request.getParameter("textEno");
       String name=request.getParameter("textName");
       String age=request.getParameter("textAge");
       String sal=request.getParameter("textSal");
try
       {
Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=latin1","root","root");
PreparedStatementstmt = con.prepareStatement("select * from emp where empid=?");
stmt.setString(1,eno);
ResultSetrs = stmt.executeQuery();
if(rs.next())
           {
PreparedStatement pst1=con.prepareStatement("update emp set salary=? whereempid=?");
PreparedStatement pst2=con.prepareStatement("update emp set age=? whereempid=?");
PreparedStatement pst3=con.prepareStatement("update emp set ename=? whereempid=?");
out.println("<h1>Employee "+ eno +"Record update succesfully</hl>");
pst1.setString(1,sal);
pst1.setString(2,eno);
pst2.setString(1,age);
pst2.setString(2,eno);

pst3.setString(1,name);
pst3.setString(2,eno);
pst1.executeUpdate();
pst2.executeUpdate();
pst3.executeUpdate(); }
else   {
out.println("<h1>EMPLOYEE RECORD NOT EXIST</h1>");
           } }
catch(Exception e)
       {
out.println(e);
       } %>
</body>
</html>
