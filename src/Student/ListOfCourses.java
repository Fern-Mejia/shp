package Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ClassHistory.Course;

public class ListOfCourses {
	ArrayList<Course> List= new ArrayList<Course>();
	public ListOfCourses() {
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
		    	  int section = rs.getInt("section");
		    	  int  course = rs.getInt("course");
		          int year = rs.getInt("year");
		    	  int  semester = rs.getInt("semester");
		    	  String  days = rs.getString("days");
		    	  Date  starts = rs.getDate("starts"); 
		    	  Date ends = rs.getDate("ends"); 
		    	  String department  = rs.getString("department");
		    	  List.add(new Course(course_Id,name,section,course,year,semester,days,starts,ends,department));  	  
		     }	      
		     
	    }catch(Exception e ) {
	    	System.out.println(e);
	    	

	    } 
		
	}
	public ArrayList<Course> getList()
	{return this.List;}
	

}
