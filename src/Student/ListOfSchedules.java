package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Photo.Schedule;

public class ListOfSchedules {
	public ArrayList<Schedule> ListOfSchedules() {
		ArrayList<Schedule> List= new ArrayList<Schedule>();
		try
	    {	
			String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
		    Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		    String query ="Select * from Schedules";
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);
		    

		     while(rs.next()){
		    	  int id = rs.getInt("cin");
		    	  
		    	  String Fname = rs.getString("Fname");
		    	  String Lname = rs.getString("Lname");
		    	 // List.add(new Schedule(id,Fname,Lname));
		     }	      
	    }catch(Exception e ) {
	    	System.out.println(e);
	    	return null;

	    } 
		return List;
	}

	

}