package activity7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class studentsearch extends HttpServlet {

   
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            PrintWriter out = response.getWriter();
            Connection con=null;
            Statement stmt = null;
            String name="",regNo="";
            name = request.getParameter("sname");
            regNo = request.getParameter("regNum");
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                stmt = con.createStatement();
            ResultSet query=stmt.executeQuery("SELECT * FROM student_details WHERE name ='"+name+"' OR Student_reg_no ='"+regNo+"'");
            out.print("<TABLE BORDER='"+1+"'>");
            out.print("<TR><TH COLSPAN='"+3+"'>Student_reg_no</TH><TH COLSPAN='"+3+"'>name</TH><TH COLSPAN='"+3+"'>age</TH><TH COLSPAN='"+3+"'>Address</TH><TH COLSPAN='"+3+"'>email</TH><TH COLSPAN='"+3+"'>phone_details</TH></TR>");
            while(query.next())
            {
            out.println("<TR><TD COLSPAN='"+3+"'>'"+query.getString(1)+"'</TD><TD COLSPAN='"+3+"'>'"+query.getString(2)+"'</TD><TD COLSPAN='"+3+"'>'"+query.getInt(3)+"'</TD><TD COLSPAN='"+3+"'>'"+query.getString(4)+"'</TD><TD COLSPAN='"+3+"'>'"+query.getString(5)+"'</TD><TD COLSPAN='"+3+"'>'"+query.getInt(6)+"'</TD></TR>");
            }
            out.print("</TABLE>");
        } catch(Exception e){  
            JOptionPane.showMessageDialog(null, e);
        }
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    public String getServletInfo() {
        return "Short description";
    }
}


		
	
		
		

