package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ClassHistory.Course;

public class ListOfCourses {
	ArrayList<Course> List= new ArrayList<Course>();
	public ArrayList<Course> ListOfCoursess() {
		
		try
	    {	
			String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
		    Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		    String query ="Select * from available_courses";
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);
		    

		     while(rs.next()){
		    	  int course_Id = rs.getInt("course_Id");
		    	  String name= rs.getString("name");
		    	  List.add(new Course(course_Id,name));
		    	  
		     }	      
		     
	    }catch(Exception e ) {
	    	System.out.println(e);
	    	return null;

	    } 
		return List;
	}

	

}
