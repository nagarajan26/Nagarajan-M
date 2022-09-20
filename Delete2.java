package com.nagarajan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.nagarajan.*;
@WebServlet("/del1")
public class Delete2 extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		delete obj1=new delete();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nagarajan","root","Naga26@123");
		int del=Integer.parseInt(req.getParameter("num"));
		out.println(obj1.obj.get(del-1));
		PreparedStatement ptmt1=con.prepareStatement("delete from table2 where id=?");
		ptmt1.setInt(1, obj1.obj.get(del-1));
		ptmt1.executeUpdate();
		PreparedStatement ptmt3=con.prepareStatement("delete from table1 where id=?");
		ptmt3.setInt(1, obj1.obj.get(del-1));
		obj1.obj.clear();
		ptmt3.executeUpdate();
		
		}
		catch(Exception e)
		{
			obj1.obj.clear();
			out.println("<p onclick=\"alert(\"Invalid Input\")\">");
			
		}
		obj1.obj.clear();
		res.sendRedirect("index.html");
	}
}
