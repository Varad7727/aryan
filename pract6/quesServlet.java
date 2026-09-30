importjava.sql.Statement;
importjava.io.IOException;
importjava.io.PrintWriter;
importjava.sql.Connection;
importjava.sql.DriverManager;
importjava.sql.ResultSet;
importjava.sql.SQLException;
importjava.util.Enumeration;
importjava.util.logging.Level;
importjava.util.logging.Logger;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;


public class QuesServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
PrintWriter out=response.getWriter();
        String paramName,paramValue[];
intcnt=0;
        String ans="";
        Enumeration paramNames=request.getParameterNames();
try
        {
Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qans?characterEncoding=latin1","root","root");
 Statement stmt=  (Statement) con.createStatement();
ResultSetrs=stmt.executeQuery("select ans from qsans");
         // ResultSetrs=stmt.execute("select any from qsans");
while(rs.next() &&paramNames.hasMoreElements())
          {
              String s=rs.getString(1);
paramName=(String)paramNames.nextElement();
paramValue=request.getParameterValues(paramName);
for(inti=0;i<paramValue.length;i++)
              {
ans=paramValue[i];
              }
if(s.equals(ans))
cnt++;
          }
out.println("<h1> You have scored "+cnt+"points out of 5</h1>");


        } 
catch (Exception e) {
out.println("sorry try again");
        } 
    }

}
