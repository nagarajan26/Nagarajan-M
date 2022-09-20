<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.io.IOException,java.io.PrintWriter,java.sql.*,javax.servlet.annotation.WebServlet" %>
    <%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Reminder</title>
</head>
<body bgcolor="PowderBlue">
<%
        int found=0;
        out.println("<body bgcolor=\"BlanchedAlmond\"></body>");
        response.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nagarajan","root","Naga26@123");
			int id,id2;
			String tt,desc,dd;
			String s2="Select dd,tt,des from table1,table2 where table1.id=table2.id ";
			Statement stm=con.createStatement();
			ResultSet set2=stm.executeQuery(s2);
			int c=1;
			
			while(set2.next())
			{
				if(c==1)
				{
					out.println("\n<br>-----------------Reminders----------------<br>");
					c++;
				}
					dd=set2.getString(1);
					tt=set2.getString(2);
					desc=set2.getString(3);
					out.println("\n Description   : "+desc+"<br>");
					out.println("\n Time          : "+tt+"<br>");
					out.println("\n------------------------------------------<br>");
					found=1;
				}
		}
		catch(Exception e)
		{
			out.println(e+"<br>");
		}
		if(found==1)
		{
		out.println("<br><b>Redirect to main page 'click me'</b><br><input type='button' onclick=\"window.location='index.html'\" value='Click Me!'>");
		}
		else
		{
			out.println("<i>No Reminders Set</i>");
			out.println("<br><b>Redirect to main page 'click me'</b><br><input type='button' onclick=\"window.location='index.html'\" value='Click Me!'>");
		}


%>
</form>
</body>
</html>