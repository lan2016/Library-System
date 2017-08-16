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
@WebServlet("/Search_Servlet")
public class Search_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

PrintWriter pw=response.getWriter();
String last = null;
String name=null;
int a=0;
response.setContentType("text/html");
pw.println("<html><head>");
pw.println("<link rel='stylesheet' type='text/css' href='search.css'>");
pw.println("</html><body>");
pw.println("<div class='main'>");
pw.println("<h1 align='center' class='text'>Online Search Portal</h1>");
pw.println("<form action='search' method='get' ><input type='text' placeholder='Author Name' name='rajat' required class='form'>");
pw.println("<input type='submit' value='search' name='rajat' class='button'>");
//pw.println("</div>");
pw.println("</form></div><body><html>");
//RequestDispatcher rd=request.getRequestDispatcher("ahead");
//rd.include(request,response);
 name=request.getParameter("rajat");
System.out.println(name);
pw.println("<html><head>");

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String s="select * from library";
	Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	PreparedStatement ps=con.prepareStatement(s,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		if(rs.getString("S1").equals(name))
		{
			if(rs.getInt("s4")>0)
			{
			pw.println("<table border='10px ' cellspacing='2px' bgcolor='black' cellpadding='1' class='main' align='left'>");
			pw.println("<caption><b><h2>Searched Book </h2></b></caption>");
			pw.println("<tr bgcolor='mistyrose'><td><h3>Author Name</h3></td><td><h3>Publisher Name</h3></td><td><h3>ISBN NO.</h3></td></tr>");
			
			pw.println("<tr bgcolor='white' class='second'><td><b>"+rs.getString("s1")+"</b></td><td><b>"+rs.getString("s2")+"</b></td><td><b>"+rs.getString("s3")+"</b></td></tr>");
		a++; 
		}
		}
		last=rs.getString("S1");	
		 	}
	System.out.println("resultset element");
	System.out.println(last);
	rs.last();
	System.out.println("last element");
	System.out.println(rs.getString("S1"));
	System.out.println("name"+name);
	 if((rs.getString("S1")).equals(last)&&!(name).equals("null")&&a==0)
	{
		 System.out.println("insd elopp");
		pw.println("<b>NO BOOK FOUND</b>");
	}
	

	pw.println("</body></html>");
}
catch(Exception e )

{
	//pw.println("<p>my name is rajat</p>");
}
pw.println("</body></html>");
	}

}
