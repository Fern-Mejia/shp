package Profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	       
	        out.println("<form method=\"post\" action=\"Login\"><br>\n" + 
	        		"	Email : <input type=\"text\" name=\"email\" >\n<br>" + 
	        		"	Password : <br><input type=\"text\" name=\"password\">\n" + 
	        		"	<br><input type=\"submit\" name=\"Login\" value=\"Login\"> \n" + 
	        		"</form>");

	        out.println("</div>");
	        out.println("</body>");        
	        out.println("</html>");
		
		
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
			response.setContentType("text/html");
		  out.println("<form method=\"post\" action=\"Login\"><br>\n" + 
	        		"	Email : <input type=\"text\" name=\"email\" >\n<br>" + 
	        		"	Password : <br><input type=\"text\" name=\"password\">\n" + 
	        		"	<br><input type=\"submit\" name=\"Login\" value=\"Login\"> \n" + 
	        		"</form>");
		String email;
		String password;
			if (request.getParameter("Login") != null) {
				email = request.getParameter("email");
				System.out.println(email);
				password = request.getParameter("password");
 
				try
			    {	
			         Class.forName("com.mysql.jdbc.Driver");

					String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
				      Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
				      

			      //replace with your query
//				  String query ="Select * from students where email=" + email + "& password=" + password;
				    String query ="Select cin from students where email=\"" + email +"\" and pw = \"" + password +"\"";
			      Statement st = conn.createStatement();
			      ResultSet rs = st.executeQuery(query);

			      if(rs.next()){
			    	  HttpSession session = request.getSession();
					  session.setAttribute("cin", rs.getInt("cin"));
		 			System.out.println("Login Successful by " + rs.getInt("cin"));
		 			
		 			
		 			response.sendRedirect("Profile");
			      }
			      else{
			      	out.println("<p>Wrong Email Or Password</p>");
			      	System.out.println("Login UNSuccessful");
			      }
			      st.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			  }
		 }else {
				System.out.println("Login UnSuccessful");
		 }
	}
}