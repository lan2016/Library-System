
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
public class Available_Book_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String s="select * from library";
	Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	PreparedStatement ps=con.prepareStatement(s);
	ResultSet rs=ps.executeQuery();
	pw.println("<html><head><title>Available Books</title>");
	pw.println("<link rel='stylesheet' type='text/css' href='available.css'>");
	pw.println("</head>");
	pw.println("<body>");
	pw.println("<p class='main'><font size='7px' color='green'><u><b>Available Books Data<font></u></b></p>");
pw.println("<table border='10px ' cellspacing='2px' bgcolor='black' cellpadding='10' class='third' align='center'>");
pw.println("<tr bgcolor='red'><td><h3>Author Name</h3></td><td><h3>Publisher Name</h3></td><td><h3>ISBN NO.</h3></td><td><h3>Copies</h3></td></tr>");
	while(rs.next())
	{
		pw.println("<tr bgcolor='white' class='second'><td><b>"+rs.getString("s1")+"</b></td><td><b>"+rs.getString("s2")+"</b></td><td><b>"+rs.getString("s3")+"</b></td><td><b>"+rs.getInt("s4")+"</b></td></tr>");
	}
	pw.println("</table>");
	pw.println("</body></html>");

} catch (Exception e) {
System.out.println(e);
}
	}

}
