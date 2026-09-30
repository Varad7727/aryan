importcom.mysql.jdbc.Connection;
importcom.mysql.jdbc.PreparedStatement;
importjava.io.IOException;
importjava.io.PrintWriter;
importjava.sql.DriverManager;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;

public class Registerservlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");  out.println("<head>"); out.println("<title>Servlet Registerservlet</title>");            
out.println("</head>");
out.println("<body>");
 String id=request.getParameter("txt1");
            String ps=request.getParameter("txt2");
             String em=request.getParameter("txt3");
         String co=request.getParameter("txt4");
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
                 Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/info?characterEncoding=latin1","root","root");
PreparedStatementpst=(PreparedStatement) con.prepareStatement("insert into user values (?,?,?,?)");
pst.setString(1,id);
pst.setString(2,ps);
pst.setString(3,em);
pst.setString(4,co);
int row = pst.executeUpdate();
out.println("<h1>"+row+ "INSERTED SUCCESSFULLY");
             } catch(Exception e)
             {
out.println(e);  }
out.println("</body>");
out.println("</html>");
}}}


Steps:
1.	Open sql command line client.
2.	Add password:root
3.	create database info;
4.	Show databases(search our db)
5.	Use info;
6.	Create table user(username varchar(20) primary key,
7.	Password varchar(20),
8.	Email varchar(20),
9.	Country varchar(20));
10.	Insert into user values(‘muskan’,’1234’,’mus@gmail.com’,’india’);
11.	select * from user;
12.	Open netbeans
13.	Create new project 
14.	Right click on libraries-> Add Jar/Folder-> Browse mysql-connector-java-5.1.12-bin
