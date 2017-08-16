

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

public class Return_Servlet extends HttpServlet {
	String fa1,fa2,fa3,fa4,fa5;
	String fp1,fp2,fp3,fp4,fp5;
	String i1,i2,i3,i4,i5;
	LocalDate ld1,ld2,ld3,ld4,ld5;
	String roll;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
       		
       			PrintWriter pw=response.getWriter();
       	
		int a = 0,b=0,c=0,d=0;
	response.setContentType("text/html");
	pw.println("<html><head>");
	pw.println("<link rel='stylesheet' type='text/css' href='search2.css'>");	
	pw.println("</html><body>");
	pw.println("<div class='main'>");
	pw.println("<h1 align='center' class='text'>Return Portal</h1>");
	pw.println("<form action='return' method='get' ><input type='text' id='input' placeholder='Enter Roll NO.' name='rajat' required class='form' required>");
	pw.println("<input type='submit' value='Search' name='rajat' class='button1'>");
	//pw.println("</div>");
	pw.println("</form></div><body><html>");
	 roll=request.getParameter("rajat");
	 HttpSession hs=request.getSession();
	 hs.setAttribute("roll", roll);
	 System.out.println(roll);
	 
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
				if((roll.equals(rs.getString("ROLL"))))
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
				response.sendRedirect("alert2.html");
			}
			else
			{
				pw.println("<html><head>");
				pw.println("<link rel='stylesheet' type='text/css' href='search2.css'>");
				pw.println("<script type='text/javascript' language='javascript' src='file1.js'>");
				pw.println("</script>");
				pw.println("</head>");
				pw.println("<body>");
				pw.println("<table border='10px ' cellspacing='2px' bgcolor='black' cellpadding='1' class='main' align='left'>");
				pw.println("<caption><b><h2>Issued Books</h2></b></caption>");
				pw.println("<tr bgcolor='mistyrose'><td><h3>Author Name</h3></td><td><h3>Publisher Name</h3></td><td><h3>ISBN NO.</h3></td><td><h3>Issue Date</h3></td></tr>");
				
						if(!(fa1).equals("null"))
						{
							//System.out.println(rs.getString("FIRSTAUTHOR"));
					pw.println("<tr onclick='javascript:showRow(this)' bgcolor='white' class='second' ><td>"+fa1+"</td><td>"+fp1+"</td><td>"+i1+"</td><td>"+ld1+"</td></tr>");
					}
						if(!(fa2).equals("null"))
						{
					pw.println("<tr onclick='javascript:showRow(this)' bgcolor='white' class='second' ><td>"+fa2+"</td><td>"+fp2+"</td><td>"+i2+"</td><td>"+ld2+"</td></tr>");
					}
						if(!(fa3).equals("null"))
						{
					pw.println("<tr onclick='javascript:showRow(this)' bgcolor='white' class='second' ><td>"+fa3+"</td><td>"+fp3+"</td><td>"+i3+"</td><td>"+ld3+"</td></tr>");
					}
						if(!(fa4).equals("null"))
						{
					pw.println("<tr onclick='javascript:showRow(this)' bgcolor='white' class='second' ><td>"+fa4+"</td><td>"+fp4+"</td><td>"+i4+"</td><td>"+ld4+"</td></tr>");
					}
						if(!(fa5).equals("null"))
						{
					pw.println("<tr onclick='javascript:showRow(this)' bgcolor='white' class='second' ><td>"+fa5+"</td><td>"+fp5+"</td><td>"+i5+"</td><td>"+ld5+"</td></tr>");
					}
						if((fa5).equals("null")&&(fa4).equals("null")&&(fa3).equals("null")&&(fa2).equals("null")&&(fa1).equals("null"))
						{
							pw.println("<tr onclick='javascript:showRow(this)' bgcolor='white' class='second' ><td colspan='4'>NO BOOK IS ISSUED YET </td></tr>");
						}
					pw.println("</table>");
						pw.println("<div class='student'>");
						pw.println("<form action='confirm' method='post'>");
						pw.println("<fieldset>");
						pw.println("<legend><font size='5'>Return Book</font></legend>");
						pw.println("<input type='text' name='roll' id='roll'  value=\""+roll+"\"  readonly onfocus='self.blur' class='name' required>");
					//	pw.println("<input type='text' name='roll' id='roll' placeholder='Enter RollNO' class='name' readonly onfocus='self.blur required>");
						pw.println("<input type='text' name='author' id='fa' placeholder='Author Name' readonly onfocus='self.blur' class='roll'>");
						pw.println("<input type='text' name='publish' id='fb' placeholder='Publisher Name' readonly onfocus='self.blur' class='branch'>");
						pw.println("<input type='text' name='isbn' id='fc' placeholder='ISBN NO.' readonly onfocus='self.blur'class='isbn'>");
						//pw.println("<input type='submit' name='name' value='ISSUE' class='button1'>");
						pw.println("<input type='submit' name='name' value='Return Book' class='rese'>");
						pw.println("</fieldset>");
						pw.println("</form>");
						pw.println("</div>");
				pw.println("</body></html>");
				
				System.out.println("user found");
			}
			a=0;
			b=0;
			
			
			
	 }
	 catch(Exception e)
	 {
System.out.println(e);		 
	 }

	 
	 }
}