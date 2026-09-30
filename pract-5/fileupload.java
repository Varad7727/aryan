importjava.io.File;
importjava.io.FileNotFoundException;
importjava.io.FileOutputStream;
importjava.io.IOException;
importjava.io.InputStream;
importjava.io.OutputStream;
importjava.io.PrintWriter;
importjavax.servlet.ServletException;
importjavax.servlet.annotation.MultipartConfig;
importjavax.servlet.http.HttpServlet;
importjavax.servlet.http.HttpServletRequest;
importjavax.servlet.http.HttpServletResponse;
importjavax.servlet.http.Part;
public class Fileupload extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throwsServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {

            String path=request.getParameter("destination");
            Part filePart=request.getPart("file");
            String filename=filePart.getSubmittedFileName();
out.print("<br><br><hr> file name: "+filename);
OutputStreamos=null;
InputStream is=null;
try  {
os=new FileOutputStream(new File(path+File.separator+filename));
is=filePart.getInputStream();
int read=0;
while((read = is.read())!=1)
                {
os.write(read);
                }
out.println("<br>file uploaded successfully!!!");
            }
catch(FileNotFoundException e)
            {
out.print(e);
            }  }   }}

