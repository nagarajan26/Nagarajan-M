package com.nagarajan;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/get")
public class Get extends HttpServlet{
	static int intcon(String s)
	{
		int n=Integer.parseInt(s);
		return n;
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
		PrintWriter out=res.getWriter();
		int found=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nagarajan","root","Naga26@123");
			String s=req.getParameter("dd");
			int date,month;
			String arr[]=s.split("-",3);
			date=intcon(arr[2]);
			month=intcon(arr[1]);
			String query="select dd,mm,k,tt,des from table1 join table2 on table1.id=table2.id";
			Statement stm=con.createStatement();
			ResultSet set1=stm.executeQuery(query);
			int dd,mm,key,id;
			String datecheck,tt,desc;
			int c=1;
			while(set1.next())
			{
				if(c==1)
				{
					out.println("<br>-----------------Reminders----------------<br>");
					c++;
				}
				tt=set1.getString(4);
				key=set1.getInt(3);
				desc=set1.getString(5);
				if(key==3)
				{
					out.println("Description :"+desc+"<br>Time:"+tt);
					out.println("<br>--------------------------------------------<br>");
					found=1;
				}
				else if(key==2)
				{
					String date1=set1.getString(1);
					dd=intcon(date1);
					if(date==dd)
					{
					out.println("Description :"+desc+"<br>Time:"+tt);
					out.println("<br>-------------------------------------------<br>");
					found=1;
					}
				}
				else if(key==1)
				{
					String date1=set1.getString(1);
					dd=intcon(date1);
					String month1=set1.getString(2);
					mm=intcon(month1);
					if(date==dd && month==mm) {
					out.println("Description :"+desc+"<br>Time:"+tt);
					out.println("<br>-------------------------------------------<br>");
					found=1;
					}
				}
			}
	
		}
		catch(Exception e)
		{
			out.println(e+"<br>");
		}
		res.setContentType("text/html");
                out.println("<body bgcolor=\"PapayaWhip\"");
		if(found==1){
		out.println("<br><b>Redirect to main page 'click me'</b><br><input type='button' onclick=\"window.location='index.html'\" value='Click Me!'>");
                }
		else
        {
		out.println("<b>No Reminder on this date<br>Redirect to main page 'click me'</b><br><input type='button' onclick=\"window.location='index.html'\" value='Click Me!'>");
		}

	}

}
