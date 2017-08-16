
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.time.*;
public class Student_Databse_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
int a=0,b=0,c=0,d=0;
		try {
		
		String name= request.getParameter("name");
		String roll= request.getParameter("roll");
		String branch= request.getParameter("branch");
		String sem= request.getParameter("sem");
		String blood=request.getParameter("blood");
		System.out.println("first");
		String Date="2015-01-21";
		System.out.println("second");
		LocalDate ld=LocalDate.now();
		System.out.println(ld);
		java.sql.Date sdob=java.sql.Date.valueOf(Date);
		System.out.println("third");
		System.out.println(sdob);
			Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
			String s1="select * from STUDENTDB";
			PreparedStatement ps1=con.prepareStatement(s1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				a++;
				if(rs1.getString("NAME").equals(name)&&rs1.getString("ROLL").equals(roll))
				{
					
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
				String s="insert into STUDENTDB(NAME,ROLL,FIRSTAUTHOR,SECONDAUTHOR,THIRDAUTHOR,FOURAUTHOR,FIVEAUTHOR,FIRSTPUBLISH,SECONDPUBLISH,THIRDPUBLISH,FOURPUBLISH,FIVEPUBLISH,FIRSTISBN,SECONDISBN,THIRDISBN,FOURISBN,FIVEISBN,TOTALBOOK,FINE,BOOK1DATE,BOOK2DATE,BOOK3DATE,BOOK4DATE,BOOK5DATE,BLOODGROUP,BRANCH,SEM)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(s);
				ps.setString(1, name);
				ps.setString(2, roll);
				ps.setString(3, "null");
				ps.setString(4, "null");
				ps.setString(5, "null");
				ps.setString(6, "null");
				ps.setString(7, "null");
				ps.setString(8, "null");
				ps.setString(9, "null");
				ps.setString(10, "null");
				ps.setString(11, "null");
				ps.setString(12, "null");
				ps.setString(13, "null");
				ps.setString(14, "null");
				ps.setString(15, "null");
				ps.setString(16, "null");
				ps.setString(17, "null");
				ps.setInt(18, 0);
				ps.setInt(19, 0);
				ps.setDate(20, sdob);
				ps.setDate(21, sdob);
				ps.setDate(22, sdob);
				ps.setDate(23, sdob);
				ps.setDate(24, sdob);
				ps.setString(25, blood);
				ps.setString(26, branch);
				ps.setString(27, sem);
				int i=ps.executeUpdate();
				if(i!=0)
				{
			//	JOptionPane.showMessageDialog(null, "Successfully registerd");
					response.sendRedirect("confirm2.html");
		}
				else
				{
					JOptionPane.showMessageDialog(null, "Not Registerd!!Try Again");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(null, "USER ALREADY EXIST");
				response.sendRedirect("stuent.html");
			}
					}
			
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Not Registerd!!Try Again");
		}


	}
}
