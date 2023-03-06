import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
@WebServlet("/SaveSevlet")
public class SaveSevlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement pst;
	int row;
	
	
	public void doPost (HttpServletRequest req, HttpServletResponse rsp) throws IOException{
         rsp.setContentType("Text/html");
         PrintWriter out = rsp.getWriter();
         try{
        	  Class.forName("com.mysql.jdbc.Driver");
        	 
				conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			
        	  String name = req.getParameter("name");
        	  String email = req.getParameter("email");
        	  String city = req.getParameter("city");
        	  
        	
				pst = conn.prepareStatement("insert into supplier(name,e-mail,city) values (?,?,?);");
				out.println("Record Added");
		
			
        	  pst.setString(1,name);
        	  pst.setString(2,email);
        	  pst.setString(3,city);
        	  row = pst.executeUpdate();
        	  out.println("<font color='green'> Record Added </font>");
         }catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
         }
         

	
	}	
	
	

}
