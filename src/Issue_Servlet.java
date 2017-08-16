import java.io.IOException;
import java.io.PrintWriter;
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
public class Issue_Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String s="select * from library";
	Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	PreparedStatement ps=con.prepareStatement(s);
	ResultSet rs=ps.executeQuery();

	pw.println("<html><head><title>Issue Book</title>");
	pw.println("<link rel='stylesheet' type='text/css' href='issue.css'>");
	pw.println("<script type='text/javascript' language='javascript' src='file.js'>");
	pw.println("</script");
	pw.println("</head>");
	pw.println("<body bgcolor='wheat'>");
//	pw.println("<p class='main'><font size='7px' color='green'><u><b>Available Books<font></u></b></p>");
pw.println("<table border='10px ' cellspacing='2px' bgcolor='black' cellpadding='10' class='main' align='left'>");
pw.println("<caption><b><h2>Available Books</h2></b></caption>");
pw.println("<tr bgcolor='mistyrose'><td><h3>Author Name</h3></td><td><h3>Publisher Name</h3></td><td><h3>ISBN NO.</h3></td><td><h3>Copies</h3></td></tr>");
	while(rs.next())
	{
		if(rs.getInt("s4")>0)
		{
		pw.println("<tr onclick='javascript:showRow(this)' bgcolor='white' class='second' ><td>"+rs.getString("s1")+"</td><td>"+rs.getString("s2")+"</td><td>"+rs.getString("s3")+"</td><td>"+rs.getInt("s4")+"</td></tr>");
	}
	}
	pw.println("</table>");
	pw.println("<div class='student'>");
	pw.println("<form action='section' method='post'>");
	pw.println("<fieldset>");
	pw.println("<legend><font size='5'>Issue Book</font></legend>");
	pw.println("<input type='text' name='roll' id='roll' placeholder='Enter RollNO' class='name' required>");
	pw.println("<input type='text' name='author' id='fa' placeholder='Author Name' readonly onfocus='self.blur' class='roll'>");
	pw.println("<input type='text' name='publish' id='fb' placeholder='Publisher Name' readonly onfocus='self.blur'class='branch'>");
	pw.println("<input type='text' name='isbn' id='fc' placeholder='ISBN NO.' readonly onfocus='self.blur'class='isbn'>");
	pw.println("<input type='submit' name='name' value='ISSUE' class='button'>");
	pw.println("<input type='reset' name='name' value='RESET' class='rese'>");
	pw.println("</fieldset>");
	pw.println("</form>");
	pw.println("</div>");
	pw.println("</body></html>");
	
} catch (Exception e) {
System.out.println(e);
}
//RequestDispatcher rd=request.getRequestDispatcher("/section");
//rd.forward(request,response);
//response.sendRedirect("/section");
	}


	}


