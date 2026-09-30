import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");

            out.println("<head>");
            out.println("<title>Servlet CalculateServlet</title>");
            out.println("</head>");

            out.println("<body>");

            // Get input values
            double n1 = Double.parseDouble(
                    request.getParameter("t1")
            );

            double n2 = Double.parseDouble(
                    request.getParameter("t2")
            );

            // Get operator
            String opr = request.getParameter("opr");

            double result = 0;

            // Perform calculation
            if (opr.equals("+"))
                result = n1 + n2;

            if (opr.equals("-"))
                result = n1 - n2;

            if (opr.equals("*"))
                result = n1 * n2;

            if (opr.equals("/"))
                result = n1 / n2;

            // Display result
            out.println("<h1>RESULT = " + result + "</h1>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}