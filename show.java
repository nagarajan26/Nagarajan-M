package com.nagarajan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/show")
public class show extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nagarajan","root","Naga26@123");
			int id,id2;
			String tt,desc,dd;
			String s2="Select dd,tt,des from table1,table2 where table1.id=table2.id order by dd,tt";
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
					out.println("\n Date          : "+dd+"<br>");
					out.println("\n Description   : "+desc+"<br>");
					out.println("\n Time          : "+tt+"<br>");
					out.println("\n------------------------------------------<br>");
				}
		}
		catch(Exception e)
		{
			out.println(e+"<br>");
		}
		out.println("<body bgcolor=\"BlanchedAlmond\"></body>");
		out.println("<br><p><b>Redirect to main page 'click me'</b></p><br><input type='button' onclick=\"window.location='index.html'\" value='Click Me!'>");
	}

}
