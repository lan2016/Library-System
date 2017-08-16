
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Final_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("html/text");
	PrintWriter pw=response.getWriter();
	HttpSession hs=request.getSession();
	String roll=(String) hs.getAttribute("roll");
	String author=(String) hs.getAttribute("author");
	String publish=(String) hs.getAttribute("publish");
	String isbn=(String) hs.getAttribute("isbn");
	int issuebook =(Integer) hs.getAttribute("issuebook");
	pw.println("ONLINE LIBRARY SYSTEM");
	pw.println("------------------------------------------------------------------------");
	pw.println("");
	pw.println("ROLL NO.="+roll);
	pw.println("AUTHOR NAME="+author);
	pw.println("PUBLISHER NAME="+publish);
	pw.println("BOOK ISBN NO.="+isbn);
	pw.println("TOTAL ISSUED BOOK.="+issuebook);
	pw.println("________________________________________________________________________________");
	System.out.println(roll+author+publish+isbn);
	}

}
