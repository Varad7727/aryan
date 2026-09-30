<%@page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>

<body>
<h1>JSP INTRINSIC OBJECTS IN JSP</h1>
<h2>1.Request Objects</h2>
<p>Request Method:<%= request.getMethod() %></p>
<p>Client IP:<%= request.getRemoteAddr() %></p>
<p>Request URL:<%= request.getRequestURI() %></p>
<p>Context Path:<%= request.getContextPath() %></p>
<h2>2.Response Objects</h2>
<p>Content type: <%= response.getContentType() %></p>
<% response.setHeader("X-Sample-Header" ,"DemoHeader"); %>
<p>Character Encoding Type <%=response.getCharacterEncoding() %></p>
<h2>3.Session Object</h2>
<%
session.setAttribute("username","Enterprise java");
                 String user=(String) session.getAttribute("username");
                 %>
<p>Username from session:<%= user %></p>
<p>Session Id:<%= session.getId() %></p>
<p>Creation Time<%=new java.util.Date(session.getCreationTime())%></p>
<p>Last Access Time<%=new java.util.Date(session.getLastAccessedTime())%></p>
<h2>4.Application Object</h2>
<% application.setAttribute("appName","JSP Demo App");%>
<p>Application Name:<%= application.getAttribute("appName")%></p>
<p>Server Info:<%= application.getServerInfo() %></p>
<h2>5.Out Object</h2>
<% 
out.println("Current time"+new Date());
                     %>
<h2>6. Config Object</h2>
<p>Servlet Name:<%= config.getServletName() %></p>
<h2>7.Page Context Object</h2>
<p> Request Locale:<%= pageContext.getRequest().getLocale()%></p>
<h2>8.Page Object</h2>
<p>Page Object Class: <%= page.getClass().getName() %></p>
</body>
</html>
