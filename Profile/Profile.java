package Profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Albums HomePage</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class=\"container\">");
        
        int cin = -1;
        try {
        	cin = (int) request.getSession().getAttribute("cin");
        }catch(Exception e){
        	
        }
        
        
        try
	    {	
	         Class.forName("com.mysql.jdbc.Driver");

			String myUrl ="jdbc:mysql://68.66.205.212/SHP_DB";
		      Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		      

	      //replace with your query
//		  String query ="Select * from students where email=" + email + "& password=" + password;
		    String query ="Select * from students where cin=" + cin;
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);

	      if(rs.next()){
	    	out.println("<h1> Welcome " + rs.getString("Fname") + " " + rs.getString("Lname")+ " </h1>");
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	      }
	      else{
	      	out.println("<p>OOPS</p>");
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	  }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
		
		
		
		
		
		
		
		
		
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
