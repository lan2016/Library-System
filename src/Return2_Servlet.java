
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Return2_Servlet extends HttpServlet {
	int a,b,c,d;
	int tb;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("call class");
		String roll=request.getParameter("roll");	
		String author=request.getParameter("author");
		String publish=request.getParameter("publish");
		String isbn=request.getParameter("isbn");
		HttpSession hs= request.getSession();
		System.out.println(roll+author+publish+isbn);
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String s="select * from STUDENTDB";
				Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
				PreparedStatement ps=con.prepareStatement(s);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					a++;
					if(rs.getString("ROLL").equals(roll))
					{
						hs.setAttribute("roll1", roll);
						hs.setAttribute("author1", author);
						hs.setAttribute("publish1",publish);
						hs.setAttribute("isbn1", isbn);
				 if(rs.getString("FIRSTAUTHOR").equals(author))
						{
					 PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set FIRSTAUTHOR=? where ROLL=?");
					 stmt1.setString(1, "null");
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set FIRSTPUBLISH=? where ROLL=?");
						stmt2.setString(1, "null");
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set FIRSTISBN=? where ROLL=?");
						stmt3.setString(1, "null");
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
						tb=rs.getInt("TOTALBOOK");
						tb--;
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt4.setInt(1, tb);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
					hs.setAttribute("iss", tb);
						}
				 else if(rs.getString("SECONDAUTHOR").equals(author))
				 {
					 PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set SECONDAUTHOR=? where ROLL=?");
					 stmt1.setString(1, "null");
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set SECONDPUBLISH=? where ROLL=?");
						stmt2.setString(1, "null");
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set SECONDISBN=? where ROLL=?");
						stmt3.setString(1, "null");
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
					
						tb=rs.getInt("TOTALBOOK");
						tb--;
						hs.setAttribute("iss", tb);
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt4.setInt(1, tb);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
					
				 }
				 else if(rs.getString("THIRDAUTHOR").equals(author))
				 {
					 PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set THIRDAUTHOR=? where ROLL=?");
					 stmt1.setString(1, "null");
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set THIRDPUBLISH=? where ROLL=?");
						stmt2.setString(1, "null");
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set THIRDISBN=? where ROLL=?");
						stmt3.setString(1, "null");
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
					
						tb=rs.getInt("TOTALBOOK");
						tb--;
						hs.setAttribute("iss", tb);
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt4.setInt(1, tb);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
					
				 }
				 else if(rs.getString("FOURAUTHOR").equals(author))
				 {
					 PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set FOURAUTHOR=? where ROLL=?");
					 stmt1.setString(1, "null");
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set FOURPUBLISH=? where ROLL=?");
						stmt2.setString(1, "null");
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set FOURISBN=? where ROLL=?");
						stmt3.setString(1, "null");
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
					
						tb=rs.getInt("TOTALBOOK");
						tb--;
						hs.setAttribute("iss", tb);
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt4.setInt(1, tb);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
					
				 }
				
				 else if(rs.getString("FIVEAUTHOR").equals(author))
				 {
					 PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set FIVEAUTHOR=? where ROLL=?");
					 stmt1.setString(1, "null");
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set FIVEPUBLISH=? where ROLL=?");
						stmt2.setString(1, "null");
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set FIVEISBN=? where ROLL=?");
						stmt3.setString(1, "null");
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
						tb=rs.getInt("TOTALBOOK");
						tb--;
						hs.setAttribute("iss", tb);
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt4.setInt(1, tb);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
					 
				 }
								 
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
					
				}
				else
				{
					System.out.println("ggggg");
					try {
						System.out.println("ffff");
						//Class.forName("oracle.jdbc.driver.OracleDriver");
						String s1="select * from LIBRARY";
						Connection  con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
						PreparedStatement ps1=con1.prepareStatement(s1);
						ResultSet rs1=ps1.executeQuery();
						System.out.println("book isseeee");
						while(rs1.next())
						{
							System.out.println("book found");
							if(rs1.getString("S1").equals(author)&&rs1.getString("S3").equals(isbn))
									
									{
								System.out.println("book not found");
									int d=	rs1.getInt("S4");
									d++;
									PreparedStatement stmt67=con1.prepareStatement("update LIBRARY set S4=? where S3=?");
									stmt67.setInt(1,d);
									stmt67.setString(2, isbn);
								int i=	stmt67.executeUpdate();
									System.out.println(i+"row updated");
								//RequestDispatcher rd=request.getRequestDispatcher("style");
								//rd.forward(request, response);
									response.sendRedirect("style.html");
									}
							else
							{
								System.out.println("insid else");
							}
									
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					System.out.println("return");
				}
				a=0;
				d=0;
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}

}
