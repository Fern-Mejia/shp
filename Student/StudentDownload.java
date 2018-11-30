package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class StudentDownload {

	public static void main(String[] args) {
		try
	    {	
			String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
		    Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		    String query ="Select * from students";
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);

		     while(rs.next()){
		    	  int id = rs.getInt("cin");
		    	  
		    	  String Fname = rs.getString("Fname");
		    	  String Lname = rs.getString("Lname");
		    	  ListManager.Students.add(new Student(id,Fname,Lname));
		     }	      
	    }catch(Exception e ) {
	    	System.out.println(e);

	    } 
		print();
	}

	private static void print() {	
		for(Student student :ListManager.Students) {
			System.out.println(student.toString());		
		}
	}

}
