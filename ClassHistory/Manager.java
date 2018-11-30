package ClassHistory;

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

/*
 * In order to start the application we must call this in the 
 * init of our server. it should be the first method called.
 * that is because it initializes our student list and our 
 * courses lists and our history courses lists. 
 */



@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try
	    {	
	        Class.forName("com.mysql.jdbc.Driver");
			String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
		    Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		    String query ="Select * from available_courses";
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);

	     while(rs.next()){
	    	  int id = rs.getInt("course_id");
	    	  CourseManager.available_courses.add(new Course(id));
	     }	      
	    }catch(Exception e ) {
	    	
	    } 
		
		
		for(Course course: CourseManager.available_courses) {
			out.println("<h1> " + course.toString()+ "</h1>");
		}
		
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
