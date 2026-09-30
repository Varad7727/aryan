importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
importjavax.servlet.http.HttpSession;
public class Page1 extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet Page1</title>");            
out.println("</head>");
out.println("<body>");
HttpSessionhs=request.getSession(true);
if(hs.isNew())
           {
out.println("<body bgcolor=yellow>");
              String name=request.getParameter("txtName");
hs.setAttribute("uname",name);
hs.setAttribute("visit","1");
out.println("<h1>WELCOME FIRST TIME</H1>");
 }
else
 {
out.println("<h1>WELCOME AGAIN</h1>");
int visit=Integer.parseInt((String)
hs.getAttribute("visit"))+1;
out.println("<h1>You visited"+visit+"Times</h1>");
hs.setAttribute("visit",""+visit);  
}
out.println("<h1>YOUR SESSION ID"+hs.getId()+"</h1>");
out.println("<h1>YOU LOGGED IN AT"+newjava.util.Date(hs.getCreationTime())+"</h1>");
out.println("<h1><a href=Page2>CLICK FOR PAGE2</a></h1>");
out.println("<h1><a href=LogoutServlet>CLICK TO TERMINATE SESSION</a></h1>");
out.println("</body>");
out.println("</html>");
 } } }
