importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
public class LogoutServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet LogoutServlet</title>");            
out.println("</head>");
out.println("<body>");
javax.servlet.http.HttpSessionhs=request.getSession();
if(hs!=null)
hs.invalidate();
out.println("<h1>YOU ARE LOGGED OUT NOW.....</h1>");
out.println("</body>");
out.println("</html>");
        }}}
