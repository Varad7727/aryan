importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.annotation.WebServlet;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/welcome"})
public class welcome extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
           String name=request.getParameter("txt1");
out.println("<h1>Welcome "+name+"<h1>");
        }}}
