importjava.io.IOException;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.annotation.WebServlet;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
importjavax.ejb.EJB;
import mypack1.CCBean;
@WebServlet(urlPatterns = {"/CCServlet"})
public class CCServlet extends HttpServlet {

    @EJB CCBeanobj;
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet CCServlet</title>");            
out.println("</head>");
out.println("<body>");
doubleamt= Double.parseDouble(request.getParameter("amt"));
if(request.getParameter("type").equals("r2d"))
            {
out.println("<h1>"+amt+"Rupees = "+obj.r2Dollar(amt)+"Dollars</h1>");
            }
if(request.getParameter("type").equals("d2r"))
            {
out.println("<h1>"+amt+"Dollars = "+obj.d2rupees(amt)+"rupees</h1>");
            }
out.println("</body>");
out.println("</html>");
        } }   }
