package com.nagarajan;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/del")
public class delete extends HttpServlet {
	static ArrayList<Integer> obj=new ArrayList<Integer>();
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
        out.println("<body bgcolor=\"LightCyan\">");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nagarajan","root","Naga26@123");
			String select="Select table2.id,tt,des from table1,table2 where table1.id=table2.id;";
			Statement stm=con.createStatement();
			ResultSet set2=stm.executeQuery(select);
			String dd,tt,des;
			int count=1,id,i=0; 
			while(set2.next())
		   {
			tt=set2.getString(2);
			des=set2.getString(3);
			id=set2.getInt(1);
			obj.add(id);
			
			out.println("<pre>");
			out.println("<b>"+count+".Description:"+des+"    Time: "+tt+"</b>");
			i++;
			count++;
		}
		if(count>1) {
			out.println("  <script>\r\n"
					+ "        function goBack() {\r\n"
					+ "            window.location = \"index.html\""
					+ "        }"
					+ "        </script>");
		out.println("<form action=\"del1\">");
		out.println("<i>Which Description did you want to delete</i><br>");
		out.printf("<input type=\"number\" name=\"num\" min=\"1\" max=\"%s\"",Integer.toString(count-1),"required><br></pre>\n");
		out.println("<br>");
		out.println("<p><input type=\"Submit\" value=\"Submit\">  <button onclick=\"goBack()\">Back</button></p>");
		//out.println("<button onclick=\"goBack()\">Back</button>");
		
	}
		else {
			out.println("<i>Nothing to Delete</>");
			out.println("<br>Redirect to main page 'click me'<br><input type='button' onclick=\"window.location='index.html'\" value='Click Me!'>");
		}

		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
