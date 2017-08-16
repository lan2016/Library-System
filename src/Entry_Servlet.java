import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class Entry_Servlet extends HttpServlet {
	String s1,s2,s3;
	int a=0,b=0,c=0,d=0;
	int e=0,f=0,g=0,h=0;
int day;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String roll=request.getParameter("roll");
		String author=request.getParameter("author");
		String isbn=request.getParameter("isbn");
		String publish=request.getParameter("publish");
		System.out.println(roll+author+isbn+publish);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String s="select * from STUDENTDB";
			Connection  con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			PreparedStatement ps=con1.prepareStatement(s,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			//s2=rs.getString("ROLL");
				a++;
		//		System.out.println(a);
				if(roll.equals(rs.getString("ROLL")))
				{	
				
		//day=rs.getInt("TOTALBOOK");
		//this.day=day;
		//s3=rs.getString("ROLL");
				}
				else
				{
					b++;
			//		this.b=b;
				//	System.out.println("***");
					//System.out.println(b);
				}
				c=a;
				d=b;
				}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			//System.out.println("outside loop");
			System.out.println(c+"\t"+d);
		//rs.last();
			if(c==d)
			{
				JOptionPane.showMessageDialog(null,"Invalid Roll NO!!TRY AGAIN");
				response.sendRedirect("isue");
	
				System.out.println(" not found ");
			}
			else
			{
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String s1="select * from STUDENTDB";
					Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
					PreparedStatement ps1=con.prepareStatement(s1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet rs1=ps1.executeQuery();
				System.out.println("otside");
				LocalDate ld=LocalDate.now();
				java.sql.Date sdob=java.sql.Date.valueOf(ld);
				System.out.println("date changed");
				while(rs1.next())
				{
				if(roll.equals(rs1.getString("ROLL")))
				{
					System.out.println("roll no found");
					String FIRSTAUTHOR=rs1.getString("FIRSTAUTHOR");
					String SECONDAUTHOR=rs1.getString("SECONDAUTHOR");
					String THIRDAUTHOR=rs1.getString("THIRDAUTHOR");
					String FOURAUTHOR=rs1.getString("FOURAUTHOR");
					String FIVEAUTHOR=rs1.getString("FIVEAUTHOR");
					int day1=rs1.getInt("TOTALBOOK");
					HttpSession hs=request.getSession();
	hs.setAttribute("roll", roll);
	hs.setAttribute("author", author);
	hs.setAttribute("publish", publish);
	hs.setAttribute("isbn", isbn);
	hs.setAttribute("issuebook",day1+1);
	System.out.println((String)hs.getAttribute("roll")+(String)hs.getAttribute("author")+(String)hs.getAttribute("publish")+(String)hs.getAttribute("isbn")+(Integer)hs.getAttribute("issuebook"));
					System.out.println("day"+day1);
					if(FIRSTAUTHOR.equals("null"))
					{
						System.out.println("firstauthor found");
						PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set FIRSTAUTHOR=? where ROLL=?");
						stmt1.setString(1, author);
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set FIRSTPUBLISH=? where ROLL=?");
						stmt2.setString(1, publish);
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set FIRSTISBN=? where ROLL=?");
						stmt3.setString(1, isbn);
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set BOOK1DATE=? where ROLL=?");
						stmt4.setDate(1, sdob);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
						//String s10="select * from STUDENTDB";
						
					//	int day1=day;
						day1++;
						PreparedStatement stmt5=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt5.setInt(1, day1);
						stmt5.setString(2, roll);
						stmt5.executeUpdate();
						System.out.println(i+"row updated");
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							String s11="select * from LIBRARY";
							Connection  con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
							PreparedStatement ps2=con2.prepareStatement(s11,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs2=ps2.executeQuery();
							System.out.println("in book secion outside");
							while(rs2.next())
								{
								System.out.println(author+publish+isbn);
						if(author.equals((rs2.getString("S1")))&&(publish.equals(rs2.getString("S2")))&&(isbn.equals(rs2.getString("S3"))))
						{
							System.out.println("book found");
							int copy=rs2.getInt("S4");
							copy--;
							PreparedStatement stmt6=con2.prepareStatement("update LIBRARY set S4=? where s3=?");
							stmt6.setInt(1,copy );
							stmt6.setString(2, isbn);
						int j=	stmt6.executeUpdate();
							System.out.println(j+" book row updated");
								}
						
						}
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						response.sendRedirect("final.html");
					
					}
					else if(SECONDAUTHOR.equals("null"))
					{
						System.out.println("firstauthor found");
						PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set SECONDAUTHOR=? where ROLL=?");
						stmt1.setString(1, author);
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set SECONDPUBLISH=? where ROLL=?");
						stmt2.setString(1, publish);
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set SECONDISBN=? where ROLL=?");
						stmt3.setString(1, isbn);
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set BOOK2DATE=? where ROLL=?");
						stmt4.setDate(1, sdob);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
						//int day1=day;
						day1++;
						PreparedStatement stmt5=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt5.setInt(1, day1);
						stmt5.setString(2, roll);
						stmt5.executeUpdate();
						System.out.println(i+"row updated");
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							String s11="select * from LIBRARY";
							Connection  con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
							PreparedStatement ps2=con2.prepareStatement(s11,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs2=ps2.executeQuery();
							System.out.println("in book secion outside");
							while(rs2.next())
								{
								System.out.println(author+publish+isbn);
						if(author.equals((rs2.getString("S1")))&&(publish.equals(rs2.getString("S2")))&&(isbn.equals(rs2.getString("S3"))))
						{
							System.out.println("book found");
							int copy=rs2.getInt("S4");
							copy--;
							PreparedStatement stmt6=con2.prepareStatement("update LIBRARY set S4=? where s3=?");
							stmt6.setInt(1,copy );
							stmt6.setString(2, isbn);
						int j=	stmt6.executeUpdate();
							System.out.println(j+" book row updated");
								}
						
						}
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						response.sendRedirect("final.html");
					
					}
					
					else if(THIRDAUTHOR.equals("null"))
					{
						System.out.println("firstauthor found");
						PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set THIRDAUTHOR=? where ROLL=?");
						stmt1.setString(1, author);
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set THIRDPUBLISH=? where ROLL=?");
						stmt2.setString(1, publish);
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set THIRDISBN=? where ROLL=?");
						stmt3.setString(1, isbn);
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set BOOK3DATE=? where ROLL=?");
						stmt4.setDate(1, sdob);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");	
						//int day1=day;
						day1++;
						PreparedStatement stmt5=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt5.setInt(1,day1);
						stmt5.setString(2, roll);
						stmt5.executeUpdate();
						System.out.println(i+"row updated");
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							String s11="select * from LIBRARY";
							Connection  con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
							PreparedStatement ps2=con2.prepareStatement(s11,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs2=ps2.executeQuery();
							System.out.println("in book secion outside");
							while(rs2.next())
								{
								System.out.println(author+publish+isbn);
						if(author.equals((rs2.getString("S1")))&&(publish.equals(rs2.getString("S2")))&&(isbn.equals(rs2.getString("S3"))))
						{
							System.out.println("book found");
							int copy=rs2.getInt("S4");
							copy--;
							PreparedStatement stmt6=con2.prepareStatement("update LIBRARY set S4=? where s3=?");
							stmt6.setInt(1,copy );
							stmt6.setString(2, isbn);
						int j=	stmt6.executeUpdate();
							System.out.println(j+" book row updated");
								}
						
						}
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						response.sendRedirect("final.html");
					
					}
					else if(FOURAUTHOR.equals("null"))
					{
						System.out.println("firstauthor found");
						PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set FOURAUTHOR=? where ROLL=?");
						stmt1.setString(1, author);
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set FOURPUBLISH=? where ROLL=?");
						stmt2.setString(1, publish);
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set FOURISBN=? where ROLL=?");
						stmt3.setString(1, isbn);
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set BOOK4DATE=? where ROLL=?");
						stmt4.setDate(1, sdob);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
						//int day1=day;
						day1++;
						PreparedStatement stmt5=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt5.setInt(1, day1);
						stmt5.setString(2, roll);
						stmt5.executeUpdate();
						System.out.println(i+"row updated");
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							String s11="select * from LIBRARY";
							Connection  con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
							PreparedStatement ps2=con2.prepareStatement(s11,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs2=ps2.executeQuery();
							System.out.println("in book secion outside");
							while(rs2.next())
								{
								System.out.println(author+publish+isbn);
						if(author.equals((rs2.getString("S1")))&&(publish.equals(rs2.getString("S2")))&&(isbn.equals(rs2.getString("S3"))))
						{
							System.out.println("book found");
							int copy=rs2.getInt("S4");
							copy--;
							PreparedStatement stmt6=con2.prepareStatement("update LIBRARY set S4=? where s3=?");
							stmt6.setInt(1,copy );
							stmt6.setString(2, isbn);
						int j=	stmt6.executeUpdate();
							System.out.println(j+" book row updated");
								}
						
						}
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					
						response.sendRedirect("final.html");
					}
					else if(FIVEAUTHOR.equals("null"))
					{
						System.out.println("firstauthor found");
						PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set FIVEAUTHOR=? where ROLL=?");
						stmt1.setString(1, author);
						stmt1.setString(2, roll);
						int i=stmt1.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt2=con.prepareStatement("update STUDENTDB set FIVEPUBLISH=? where ROLL=?");
						stmt2.setString(1, publish);
						stmt2.setString(2, roll);
						stmt2.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt3=con.prepareStatement("update STUDENTDB set FIVEISBN=? where ROLL=?");
						stmt3.setString(1, isbn);
						stmt3.setString(2, roll);
						stmt3.executeUpdate();
						System.out.println(i+"row updated");
						PreparedStatement stmt4=con.prepareStatement("update STUDENTDB set BOOK5DATE=? where ROLL=?");
						stmt4.setDate(1, sdob);
						stmt4.setString(2, roll);
						stmt4.executeUpdate();
						System.out.println(i+"row updated");
					//	int day1=day;
						day1++;
						PreparedStatement stmt5=con.prepareStatement("update STUDENTDB set TOTALBOOK=? where ROLL=?");
						stmt5.setInt(1, day1);
						stmt5.setString(2, roll);
						stmt5.executeUpdate();
						System.out.println(i+"row updated");
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							String s11="select * from LIBRARY";
							Connection  con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
							PreparedStatement ps2=con2.prepareStatement(s11,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs2=ps2.executeQuery();
							System.out.println("in book secion outside");
							while(rs2.next())
								{
							//	System.out.println(author+publish+isbn);
						if(author.equals((rs2.getString("S1")))&&(publish.equals(rs2.getString("S2")))&&(isbn.equals(rs2.getString("S3"))))
						{
							System.out.println("book found");
							int copy=rs2.getInt("S4");
							copy--;
							PreparedStatement stmt6=con2.prepareStatement("update LIBRARY set S4=? where s3=?");
							stmt6.setInt(1,copy );
							stmt6.setString(2, isbn);
						int j =	stmt6.executeUpdate();
							System.out.println(j+" book row updated");
								}
						
						}
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						response.sendRedirect("final.html");
					
					}
					else
					{
						response.sendRedirect("alert.html");
					}
				}
				}
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
				
		
		
	}
			a=0;
			b=0;
	
}

}
