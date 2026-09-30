<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h2>Validation Page</h2>
<%
            String name=request.getParameter("name");
             String agestr=request.getParameter("age");
              String email=request.getParameter("email");
               String gender=request.getParameter("gender");
                String hobbies[]=request.getParameterValues("hob");
                String errmsg="";

if(name == null || name.trim().equals(""))
                {
errmsg += "Please provide your  name <br>";
                }
if(agestr == null || agestr.trim().equals(""))
                {
errmsg += "Please provide your  age <br>";
                }
else
                 {
try
                     {
int age=Integer.parseInt(agestr);
if(age <= 0 || age > 120)
                         {
errmsg+= "Age must be between 1 and 120 <br>";
                         }
                     }
catch(Exception ex)
                     {
errmsg+= "Invalid age format<br>";
                     }
                 }
if(email == null || email.trim().equals(""))
                {
errmsg += "Please provide your  email <br>";
                }
else
                 {
                     String emailpattern ="^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
if(!email.matches(emailpattern))
                     {
errmsg+="invalid email format";
                     }
                 }
if(hobbies == null || hobbies.length==0)
                {
errmsg += "Please provide your  hobbies <br>";
                } 
if(gender == null || gender.trim().equals(""))
                {
errmsg += "Please provide your  gender<br>";
                } 
if(!errmsg.trim().equals(""))
                {
out.println("<p style='color:red;'>"+errmsg+"</p>");
out.println("<a href='index.html'>Go back </a>");
                }
else
                {
out.println("<p><strong>Name:</strong>"+name+"</p>");
out.println("<p><strong>Age:</strong>"+agestr+"</p>");
out.println("<p><strong>Hobbies:</strong></p>");
for(String hobby:hobbies)
                        {
out.println("<p>"+hobby+"</p>");
                        }

out.println("<p><strong>Email:</strong>"+email+"</p>");
out.println("<p><strong>Email:</strong>"+gender+"</p>");
out.println("<a href='index.html'>Go back to form </a>");
        }
        %>

</body>
</html>
