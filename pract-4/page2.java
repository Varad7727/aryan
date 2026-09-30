importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
importjavax.servlet.http.HttpSession;
public class Page2 extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet Page2</title>");            
out.println("</head>");
out.println("<body>");
HttpSessionhs=request.getSession(false);
out.println("<h1>WELCOME AGAIN ON PAGE NO. 2</h1>");
int visit =Integer.parseInt((String)
hs.getAttribute("visit"))+1;
out.println("<h1>YOU VISITED"+visit+"Times</h1>");
hs.setAttribute("visit",""+ visit);
out.println("<h1>YOUR SESSION ID IS"+hs.getId()+"</h1>");
out.println("<h1>YOU LOGGED IN"+newjava.util.Date(hs.getCreationTime()));
out.println("<h1><a href=Page1>CLICK FOR PAGE 0</a></h1>");
out.println("<h1><a href=LogoutServlet>CLICK FOR TERMINATE SESSION</a></h1>");
out.println("</body>");
out.println("</html>");
        }}}
