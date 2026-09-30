importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;

public class Loginservlet extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet Loginservlet</title>");            
out.println("</head>");
out.println("<body>");
            String un=request.getParameter("t1");
            String pass=request.getParameter("t2");
if(un.equals("") &&pass.equals("1234"))
out.println("HELLO" +un);
else
out.println("LOGIN FAILED");
out.println("</body>");
out.println("</html>");
        }}}
