

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login_Servlet extends HttpServlet {
	int a=0,b=0,c=0,d=0;
	int fine=0;
	String fa1,fa2,fa3,fa4,fa5;
	String fp1,fp2,fp3,fp4,fp5;
	String i1,i2,i3,i4,i5;
	LocalDate ld1,ld2,ld3,ld4,ld5;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name=request.getParameter("name");
String bg = null,sem = null,branch = null;
String roll=request.getParameter("roll");
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String s="select * from STUDENTDB";
	Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	PreparedStatement ps=con.prepareStatement(s);
	ResultSet rs=ps.executeQuery();
	String Date="2015-01-21";
	LocalDate currentdate=LocalDate.now();
	//java.sql.Date sdob=java.sql.Date.valueOf(ld);
	java.sql.Date sdob1=java.sql.Date.valueOf(Date);
	LocalDate fixdate=sdob1.toLocalDate();
	while(rs.next())
	{
		a++;
		if((name.equals(rs.getString("NAME")))&&(roll.equals(rs.getString("ROLL"))))
				{
			java.sql.Date f1=rs.getDate("BOOK1DATE");
			java.sql.Date f2=rs.getDate("BOOK2DATE");
			java.sql.Date f3=rs.getDate("BOOK3DATE");
			java.sql.Date f4=rs.getDate("BOOK4DATE");
			java.sql.Date f5=rs.getDate("BOOK5DATE");
	//System.out.println("current date="+ld);
	 ld1 =f1.toLocalDate();
	 ld2 =f2.toLocalDate();
	 ld3 =f3.toLocalDate();
	ld4 =f4.toLocalDate();
	 ld5 =f5.toLocalDate();
	 fa1=rs.getString("FIRSTAUTHOR");
	 fa2=rs.getString("SECONDAUTHOR");
	 fa3=rs.getString("THIRDAUTHOR");
	 fa4=rs.getString("FOURAUTHOR");
	 fa5=rs.getString("FIVEAUTHOR");
	 fp1=rs.getString("FIRSTPUBLISH");
	 fp2=rs.getString("SECONDPUBLISH");
	 fp3=rs.getString("THIRDPUBLISH");
	 fp4=rs.getString("FOURPUBLISH");
	 fp5=rs.getString("FIVEPUBLISH");
	 i1=rs.getString("FIRSTISBN");
	 i2=rs.getString("SECONDISBN");
	 i3=rs.getString("THIRDISBN");
	 i4=rs.getString("FOURISBN");
	 i5=rs.getString("FIVEISBN");
	//System.out.println(gh);
			if(!(ld1).equals(fixdate))
			{
				Period p=Period.between(ld1, currentdate);
			int a=	p.getYears();
			int b=	p.getMonths();
			int c=	p.getDays();
			if(a<0)
			{
				a=-1*a;
			}
			if(b<0)
			{
				b=-1*b;
			}
			if(c<0)
			{
				c=-1*c;
			}
			System.out.println(a+"year"+b+"month"+c+"day");
			System.out.println("*************");
			int d=a*365+b*30+c;
			System.out.println(d);
			if(d>30)
			{
				fine=fine+(d-30)*10;
				System.out.println("first fine"+fine);
		
			}
			}
			if(!(ld2).equals(fixdate))
			{
				Period p=Period.between(ld2, currentdate);	
			//	Period p=Period.between(ld1, currentdate);
				int a=	p.getYears();
				int b=	p.getMonths();
				int c=	p.getDays();
				int d=a*365+b*30+c;
				if(a<0)
				{
					a=-1*a;
				}
				if(b<0)
				{
					b=-1*b;
				}
				if(c<0)
				{
					c=-1*c;
				}
				System.out.println(d);
				if(d>30)
				{
					fine=fine+(d-30)*10;
					System.out.println("second fine"+fine);
							}
				System.out.println(a+"year"+b+"month"+c+"day");
				System.out.println("*************");
			}

			
			if(!(ld3).equals(fixdate))
			{
				Period p=Period.between(ld3, currentdate);
				int a=	p.getYears();
				int b=	p.getMonths();
				int c=	p.getDays();
				if(a<0)
				{
					a=-1*a;
				}
				if(b<0)
				{
					b=-1*b;
				}
				if(c<0)
				{
					c=-1*c;
				}
				System.out.println(a+"year"+b+"month"+c+"day");
				System.out.println("*************");
				int d=a*365+b*30+c;
				System.out.println(d);
				if(d>30)
				{
					fine=fine+(d-30)*10;
					System.out.println("third fine"+fine);
					}
			
		
			}
			if(!(ld4).equals(fixdate))
			{
				Period p=Period.between(ld4, currentdate);
				int a=	p.getYears();
				int b=	p.getMonths();
				int c=	p.getDays();
				if(a<0)
				{
					a=-1*a;
				}
				if(b<0)
				{
					b=-1*b;
				}
				if(c<0)
				{
					c=-1*c;
				}
				
				System.out.println(a+"year"+b+"month"+c+"day");
				System.out.println("*************");
				int d=a*365+b*30+c;
				System.out.println(d);
				if(d>30)
				{
					fine=fine+(d-30)*10;
					System.out.println("four fine"+fine);
					}
			
		
			}
			if(!(ld5).equals(fixdate))
			{Period p=Period.between(ld5, currentdate);
			int a=	p.getYears();
			int b=	p.getMonths();
			int c=	p.getDays();
			if(a<0)
			{
				a=-1*a;
			}
			if(b<0)
			{
				b=-1*b;
			}
			if(c<0)
			{
				c=-1*c;
			}
			System.out.println(a+"year"+b+"month"+c+"day");
			System.out.println("*************");
			int d=a*365+b*30+c;
			System.out.println(d);
			if(d>30)
			{
				fine=fine+(d-30)*10;
				System.out.println("five fine"+fine);
			}
		
			}
			PreparedStatement stmt1=con.prepareStatement("update STUDENTDB set FINE=? where ROLL=?");
			stmt1.setInt(1, fine);
			stmt1.setString(2, roll);
			int i=stmt1.executeUpdate();
			System.out.println(i+"row updated");
			 bg=rs.getString("BLOODGROUP");
		 sem=rs.getString("SEM");
		 branch=rs.getString("BRANCH");
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
		
		//System.out.println("user not found");
		response.sendRedirect("alert2.html");
	}
	else
	{
		pw.println("<html><head>");
		pw.println("<link rel='stylesheet' type='text/css' href='login.css'>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div class='main'>");
		pw.println("<h1 align='center' class='text'>Online Student Portal</h1>");
		pw.println("<p ><h2 class='name'>Student Name-> <b class='common'>"+ name +"</b></h2></p>");
		pw.println("<p ><h2 class='roll'>Roll No.-> <b class='common'>"+ roll+"</b></h2></p>");
		pw.println("<p ><h2 class='branch'>Branch-> <b class='common'>"+ branch+"</b></h2></p>");
		pw.println("<p ><h2 class='sem'>Semester-> <b class='common'>"+ sem+"</b></h2></p>");
		pw.println("<p ><h2 class='bg'>BloodGroup-> <b class='common'>"+ bg+"</b></h2></p>");
		pw.println("<p ><h2 class='fine'>Fine-> <b class='common'>"+ fine+" Rupees</b></h2></p>");
		pw.println("<table border='10px ' cellspacing='2px' bgcolor='black' cellpadding='1' class='main' align='left'>");
		pw.println("<caption><b><h2>Issued Books</h2></b></caption>");
		pw.println("<tr bgcolor='mistyrose'><td><h3>Author Name</h3></td><td><h3>Publisher Name</h3></td><td><h3>ISBN NO.</h3></td><td><h3>Issue Date</h3></td></tr>");
		
				if(!(fa1).equals("null"))
				{
					//System.out.println(rs.getString("FIRSTAUTHOR"));
			pw.println("<tr  bgcolor='white' class='second' ><td>"+fa1+"</td><td>"+fp1+"</td><td>"+i1+"</td><td>"+ld1+"</td></tr>");
			}
				if(!(fa2).equals("null"))
				{
			pw.println("<tr  bgcolor='white' class='second' ><td>"+fa2+"</td><td>"+fp2+"</td><td>"+i2+"</td><td>"+ld2+"</td></tr>");
			}
				if(!(fa3).equals("null"))
				{
			pw.println("<tr  bgcolor='white' class='second' ><td>"+fa3+"</td><td>"+fp3+"</td><td>"+i3+"</td><td>"+ld3+"</td></tr>");
			}
				if(!(fa4).equals("null"))
				{
			pw.println("<tr  bgcolor='white' class='second' ><td>"+fa4+"</td><td>"+fp4+"</td><td>"+i4+"</td><td>"+ld4+"</td></tr>");
			}
				if(!(fa5).equals("null"))
				{
			pw.println("<tr  bgcolor='white' class='second' ><td>"+fa5+"</td><td>"+fp5+"</td><td>"+i5+"</td><td>"+ld5+"</td></tr>");
			}
				if((fa5).equals("null")&&(fa4).equals("null")&&(fa3).equals("null")&&(fa2).equals("null")&&(fa1).equals("null"))
				{
					pw.println("<tr  bgcolor='white' class='second' ><td colspan='4'>NO BOOK IS ISSUED YET </td></tr>");
				}
			
		pw.println("</table>");
		pw.println("<form action='login.html'>");
		pw.println("<input type='submit'  value='LOGOUT' class='button'>");
		pw.println("</form>");
		pw.println("</body></html>");
		System.out.println("user found");
	}
	a=0;
	b=0;
	fine=0;
	}
catch(Exception e)
{
	System.out.println(e);
}
}
}
