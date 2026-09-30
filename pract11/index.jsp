<body>
<h1>welcome to index page</h1>
<% session.setAttribute("user","Admin"); %>
<%
Cookie ck=new Cookie("name","mycookie");
response.addCookie(ck);
%>
<form action="ExpressionLanguage.jsp">
Enter Name:<input type="text" name="name" /><br/><br/>
<input type="submit" value="Submit"/>
</form>
</body>
