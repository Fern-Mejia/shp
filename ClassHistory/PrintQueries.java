package ClassHistory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrintQueries {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String year = "2018";
		String semester = "0";
		String file = "/Users/Israel/Desktop/QueriesCourses.txt";
		String line ="";
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){			
			try
		    { 



//		                            0	     1	2		3	4	5	6		7										8		9  10 11 12  13          14               15          16
//INSERT INTO available_courses ( name, section ,course,2019,1, days,starts,ends,department) Values("INTRO HIGHER EDU-COMP",1010,1,2018,0,"MW","11:00:00.000000","12:00:00.000000","CS");

			//year  = index 11;
			//semester == index 12;
			  String myUrl ="jdbc:mysql://68.66.205.212/SHP_DB";
		      Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		      while((line = br.readLine() )!=null) {
		    	  String[] parts  = line.split(",");

		    	  parts[11] = year+"";
		    	  parts[12] = semester;
		    	  line="";
		    	  for(int i = 0 ; i < parts.length ; i++) {
		    		  if(i < parts.length-1)
		    			line+=parts[i] + ",";
		    		  else
		    			  line+= parts[i];
		    	  }
				  System.out.println(line);
				  Statement st = conn.createStatement();
			      int rs = st.executeUpdate(line);

			}
		  }catch(Exception e ){
			  System.out.println(e);
		  }
		}
	}
}