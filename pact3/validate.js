importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.RequestDispatcher;
importjavax.servlet.ServletException;
importjavax.servlet.annotation.WebServlet;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/validate"})
public class validate extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
            String pass=request.getParameter("txt2");
if(pass.equals("servlet"))
            {
RequestDispatcherrd=request.getRequestDispatcher("welcome");
rd.forward(request,response);    }
else
            {
out.println("<font color='red'><b>You have entered wrong password");
RequestDispatcherrd=request.getRequestDispatcher("index.html");
rd.include(request, response);
}}}}
