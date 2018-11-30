package Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Photo.Names;

public class StudentManager {

	public static void main(String[] args) {
		try
	    { String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
	      Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
	      String Fname,Lname ,email,password;
	      
	      for(int i  = 0 ; i < 10; i++) {
	    	  Fname=Names.getFirstName();
	    	  String fnametrimmer="";
	    	 for(int j = 0 ; j < Fname.length(); j++) {
	    		 if(!(Fname.charAt(j)==' ')) {
	    			 fnametrimmer += Fname.charAt(j);
	    		 }
	    	 }
	    	 Fname = fnametrimmer;
	    	  if(Fname.indexOf(" ") > 0)
	    		  Fname =Fname.substring(Fname.indexOf(" "));
	    	  Lname = Names.getLastName();
	    	  if(Lname.indexOf(" ") > 0)
	    		  Lname =Lname.substring(Lname.indexOf(" "));
	    	  email = Fname+Lname+"@shp.com";
	    	  
	    	  password="password";
	      String query ="insert into students Values(null,\""+Fname+"\",\""+Lname+"\",\""+email+"\",\""+password+"\")";
	      Statement st = conn.createStatement();
	      st.executeUpdate(query);
	      st.close();
	      }
	      
	      System.out.println("FINISHED FOR LOOP");
	     
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		
		
		
		
	}

}
