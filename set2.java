package com.nagarajan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/set2")
public class set2  extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nagarajan","root","Naga26@123");
			PreparedStatement ptmt=con.prepareStatement("insert into table1(dd,mm,tt,k) values(?,?,?,?)");
			PreparedStatement ptmt2=con.prepareStatement("insert into table2(des) values(?)");
			String k= req.getParameter("1");
			String k2=req.getParameter("2");
			String k3=req.getParameter("3");
			if(k!=null)
			{
				String desc=req.getParameter("des");
				String time=req.getParameter("time");
				String date=req.getParameter("day");
				String month=req.getParameter("month");
				int key=1;
				ptmt.setString(1, date);
				ptmt.setString(2, month);
				ptmt.setString(3, time);
				ptmt.setInt(4, key);
				ptmt2.setString(1,desc);
				ptmt.executeUpdate();
				ptmt2.executeUpdate();
			}
			else if(k2!=null)
			{
				String desc=req.getParameter("des");
				String time=req.getParameter("time");
				String date=req.getParameter("date");
				int key=2;
				ptmt.setString(1, date);
				ptmt.setString(2, null);
				ptmt.setString(3, time);
				ptmt.setInt(4, key);
				ptmt2.setString(1,desc);
				ptmt.executeUpdate();
				ptmt2.executeUpdate();
			}
			else if(k3!=null)
			{
				String desc=req.getParameter("des");
				String time=req.getParameter("time");
				int key=3;
				ptmt.setString(1, null);
				ptmt.setString(2, null);
				ptmt.setString(3, time);
				ptmt.setInt(4, key);
				ptmt2.setString(1,desc);
				ptmt.executeUpdate();
				ptmt2.executeUpdate();
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		res.sendRedirect("index.html");
	}
}
