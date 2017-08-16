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

public class Complete_Servlet extends HttpServlet {
	String fa1,fa2,fa3,fa4,fa5;
	String fp1,fp2,fp3,fp4,fp5;
	String i1,i2,i3,i4,i5;
	LocalDate ld1,ld2,ld3,ld4,ld5;
	String roll,name,branch,sem,bg;
	int tb,fine;
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		PrintWriter pw=response.getWriter();
       response.setContentType("text/html");		
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
String s1="select * from STUDENTDB";
PreparedStatement ps1=con.prepareStatement(s1);
ResultSet rs=ps1.executeQuery();
pw.println("<html><head></head><body>");
pw.println("<table border='10px ' cellspacing='2px' bgcolor='black' cellpadding='1' class='main' align='left'>");
pw.println("<caption><b><h2>Student Database</h2></b></caption>");
pw.println("<tr bgcolor='mistyrose'><td><h3>Name</h3></td><td><h3>ROLL NO.</h3></td><td><h3>Branch</h3></td><td><h3>Semester</h3></td><td><h3>Author1</h3></td><td><h3>Author2</h3></td><td><h3>Author3</h3></td><td><h3>Author4</h3></td><td><h3>Author5</h3></td><td><h3>Publisher1</h3></td><td><h3>Publisher2</h3></td><td><h3>Publisher3</h3></td><td><h3>Publisher4</h3></td><td><h3>Publisher5</h3></td><td><h3>BOOK ISBN1</h3></td><td><h3>BOOK ISBN2</h3></td><td><h3>BOOK ISBN3</h3></td><td><h3>BOOK ISBN4</h3></td><td><h3>BOOK ISBN5</h3></td><td><h3>BOOK1 IssueDate</h3></td><td><h3>BOOK2 IssueDate</h3></td><td><h3>BOOK3 IssueDate</h3></td><td><h3>BOOK4 IssueDate</h3></td><td><h3>BOOK5 IssueDate</h3></td><td><h3>Total Issued Books</h3></td><td><h3>Fine</h3></td></tr>");	
while(rs.next())
{
	java.sql.Date f1=rs.getDate("BOOK1DATE");
	java.sql.Date f2=rs.getDate("BOOK2DATE");
	java.sql.Date f3=rs.getDate("BOOK3DATE");
	java.sql.Date f4=rs.getDate("BOOK4DATE");
	java.sql.Date f5=rs.getDate("BOOK5DATE");
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
System.out.println("rajat");
name=rs.getString("NAME");
roll=rs.getString("ROLL");
tb=rs.getInt("TOTALBOOK");
fine=rs.getInt("FINE");
branch=rs.getString("BRANCH");
sem=rs.getString("SEM");
bg=rs.getString("BLOODGROUP");
String Date="1001-01-01";
java.sql.Date sdob1=java.sql.Date.valueOf(Date);
LocalDate m1=sdob1.toLocalDate();

if(rs.getString("FIRSTAUTHOR").equals("null")&&rs.getString("SECONDAUTHOR").equals("null")&&rs.getString("THIRDAUTHOR").equals("null")&&rs.getString("FOURAUTHOR").equals("null")&&rs.getString("FIVEAUTHOR").equals("null"))
{
	fa1="--";
	fa2="--";
	fa3="--";
	fa4="--";
	fa5="--";
	fp1="--";
	fp2="--";
	fp3="--";
fp4="--";
	fp5="--";
	i1="--";
	i2="--";
	i3="--";
	i4="--";
	i5="--";
	fine=0;
tb=0;
ld1=m1;
ld2=m1;
ld3=m1;
ld4=m1;
ld5=m1;
	//pw.println("<tr bgcolor='white' class='second'><td>"+name+"</td><td>"+roll+"</td><td>"+branch+"</td><td>"+sem+"</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>-</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td><td>--</td></tr>");
}
 if(rs.getString("FIRSTAUTHOR").equals("null"))
	{
		
	fa1="--";
	fp1="--";
	i1="--";
	ld1=m1;
	}
		//pw.println("<tr bgcolor='white' class='second'><td>"+name+"</td><td>"+roll+"</td><td>"+branch+"</td><td>"+sem+"</td><td>--</td><td>--</td><td>--</td><td>--</td><td>"+fa5+"</td><td>--</td><td>--</td><td>--</td><td>--</td><td>"+fp5+"</td><td>--</td><td>--</td><td>--</td><td>--</td><td>"+i5+"</td><td>-</td><td>--</td><td>--</td><td>--</td><td>"+ld5+"</td><td>"+tb+"</td><td>"+fine+"</td></tr>");	}
if(rs.getString("SECONDAUTHOR").equals("null"))
	{
	fa2="--";
	fp2="--";
	i2="--";
	ld2=m1;
		///pw.println("<tr bgcolor='white' class='second'><td>"+name+"</td><td>"+roll+"</td><td>"+branch+"</td><td>"+sem+"</td><td>--</td><td>--</td><td>--</td><td>"+fa4+"</td><td>"+fa5+"</td><td>--</td><td>--</td><td>--</td><td>"+fp4+"</td><td>"+fp5+"</td><td>--</td><td>--</td><td>--</td><td>"+i4+"</td><td>"+i5+"</td><td>--</td><td>--</td><td>--</td><td>"+ld4+"</td><td>"+ld5+"</td><td>"+tb+"</td><td>"+fine+"</td></tr>");
	}
 if(rs.getString("THIRDAUTHOR").equals("null"))
	{
	 fa3="--";
		fp3="--";
		i3="--";
		ld3=m1;
		//pw.println("<tr bgcolor='white' class='second'><td>"+name+"</td><td>"+roll+"</td><td>"+branch+"</td><td>"+sem+"</td><td>--</td><td>--</td><td>"+fa3+"</td><td>"+fa4+"</td><td>"+fa5+"</td><td>--</td><td>--</td><td>"+fp3+"</td><td>"+fp4+"</td><td>"+fp5+"</td><td>--</td><td>--</td><td>"+i3+"</td><td>"+i4+"</td><td>"+i5+"</td><td>--</td><td>--</td><td>"+ld3+"</td><td>"+ld4+"</td><td>"+ld5+"</td><td>"+tb+"</td><td>"+fine+"</td></tr>");
	}
if(rs.getString("FOURAUTHOR").equals("null"))
	{
	fa4="--";
	fp4="--";
	i4="--";
	ld4=m1;
		//pw.println("<tr bgcolor='white' class='second'><td>"+name+"</td><td>"+roll+"</td><td>"+branch+"</td><td>"+sem+"</td><td>--</td><td>"+fa2+"</td><td>"+fa3+"</td><td>"+fa4+"</td><td>"+fa5+"</td><td>--</td><td>"+fp2+"</td><td>"+fp3+"</td><td>"+fp4+"</td><td>"+fp5+"</td><td>--</td><td>"+i2+"</td><td>"+i3+"</td><td>"+i4+"</td><td>"+i5+"</td><td>--</td><td>"+ld2+"</td><td>"+ld3+"</td><td>"+ld4+"</td><td>"+ld5+"</td><td>"+tb+"</td><td>"+fine+"</td></tr>");
	}
if(rs.getString("FIVEAUTHOR").equals("null"))
{
fa5="--";
fp5="--";
i5="--";
ld5=m1;
	//pw.println("<tr bgcolor='white' class='second'><td>"+name+"</td><td>"+roll+"</td><td>"+branch+"</td><td>"+sem+"</td><td>--</td><td>"+fa2+"</td><td>"+fa3+"</td><td>"+fa4+"</td><td>"+fa5+"</td><td>--</td><td>"+fp2+"</td><td>"+fp3+"</td><td>"+fp4+"</td><td>"+fp5+"</td><td>--</td><td>"+i2+"</td><td>"+i3+"</td><td>"+i4+"</td><td>"+i5+"</td><td>--</td><td>"+ld2+"</td><td>"+ld3+"</td><td>"+ld4+"</td><td>"+ld5+"</td><td>"+tb+"</td><td>"+fine+"</td></tr>");
}

//else 
	//{
		//pw.println("<tr bgcolor='white' class='second'><td>"+name+"</td><td>"+roll+"</td><td>"+branch+"</td><td>"+sem+"</td><td>"+fa1+"</td><td>"+fa2+"</td><td>"+fa3+"</td><td>"+fa4+"</td><td>"+fa5+"</td><td>"+fp1+"</td><td>"+fp2+"</td><td>"+fp3+"</td><td>"+fp4+"</td><td>"+fp5+"</td><td>"+i1+"</td><td>"+i2+"</td><td>"+i3+"</td><td>"+i4+"</td><td>"+i5+"</td><td>"+ld1+"</td><td>"+ld2+"</td><td>"+ld3+"</td><td>"+ld4+"</td><td>"+ld5+"</td><td>"+tb+"</td><td>"+fine+"</td></tr>");	
	//}
pw.println("<tr bgcolor='white' class='second'><td>"+name+"</td><td>"+roll+"</td><td>"+branch+"</td><td>"+sem+"</td><td>"+fa1+"</td><td>"+fa2+"</td><td>"+fa3+"</td><td>"+fa4+"</td><td>"+fa5+"</td><td>"+fp1+"</td><td>"+fp2+"</td><td>"+fp3+"</td><td>"+fp4+"</td><td>"+fp5+"</td><td>"+i1+"</td><td>"+i2+"</td><td>"+i3+"</td><td>"+i4+"</td><td>"+i5+"</td><td>"+ld1+"</td><td>"+ld2+"</td><td>"+ld3+"</td><td>"+ld4+"</td><td>"+ld5+"</td><td>"+tb+"</td><td>"+fine+"</td></tr>");	
//}
}
pw.println("</table></body></html>");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}

	

}
