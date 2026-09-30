importjava.io.IOException;
importjava.io.InputStream;
importjava.io.PrintWriter;
importjavax.servlet.ServletContext;
importjavax.servlet.ServletException;
importjavax.servlet.ServletOutputStream;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
public class DownloadServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
 String filename = request.getParameter("filename");
intlen=0;
try (ServletOutputStream out = response.getOutputStream()) {
ServletContext context = getServletConfig().getServletContext();
response.setContentType((context.getMimeType(filename)!=null)?context.getMimeType(filename):"application/pdf");
response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"/");
InputStream is = context.getResourceAsStream("/"+filename);
byte[] b=new byte[1024];
while((is!=null)&&((len=is.read(b)) !=-1))
 {
out.write(b,0,len);
 }
out.flush();
is.close();
out.close();
} } }
