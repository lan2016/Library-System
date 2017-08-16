import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

import java.awt.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class Authuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name=request.getParameter("name");
String roll=request.getParameter("roll");
PrintWriter pw=response.getWriter();
if(name.equals("rajat")&&roll.equals("bansal"))
{
//JOptionPane.showMessageDialog(null, "You have Succesfully Login");
//response.sendRedirect("book.html");
	//response.setContentType("text/html");
	//pw.println("<html><body>");
//	pw.println("<script type='javascript'>");
	//pw.println("alert('Suceesfully Login')");
	//pw.println("</script></body></html>");
	RequestDispatcher rd=request.getRequestDispatcher("confirm.html");
	rd.forward(request, response);
	//response.sendRedirect("confirm.html");
}
else
{
	JOptionPane.showMessageDialog(null, "Invalid User Or Password!!");
	response.sendRedirect("authuser.html");
}
       	}

}
