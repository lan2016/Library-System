import javax.servlet.*;
import java.awt.*;
import javax.swing.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
public class book_servlet extends HttpServlet 
{
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String authorname=request.getParameter("authorname");
	String publishername=request.getParameter("publishername");
	String isbn=(request.getParameter("isbn"));
	int copy=Integer.parseInt((request.getParameter("copy")));
	System.out.println(copy);
	int a=0,b=0,c=0,d=0;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		String s1="select * from LIBRARY";
		PreparedStatement ps1=con.prepareStatement(s1);
	ResultSet rs1=	ps1.executeQuery();
		while(rs1.next())
		{
			a++;
			if(rs1.getString("S1").equals(authorname)&&rs1.getString("S2").equals(publishername)||rs1.getString("S3").equals(isbn))
			{
		//	b++;
			}	
			else
			{
			b++;	
		
		}
			c=a;
			d=b;
		}
		if(c==d)
		{
			String s="insert into library(s1,s2,s3,s4)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1, authorname);
			ps.setString(2, publishername);
			ps.setString(3, isbn);
			ps.setInt(4,copy);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "YOur BooK Registered Succesfully");
			response.sendRedirect("book.html");	
	
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "BOOK ALREADY EXIST");
			response.sendRedirect("book.html");
	
				}
		a=0;
		b=0;
		}
		
	//	String s1=JOptionPane.showInputDialog(this, "sjsjjs");
		//System.out.println(s1);
		
	
		catch (Exception e) {
System.out.println(e);
	}
	

	
	}

}
