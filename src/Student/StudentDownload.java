package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class StudentDownload {
	public static void main(String[] args) throws SQLException {
		String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
	    Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		ListManager listM= new ListManager();
		ListOfCourses ListC= listM.getListOfCourses();
		ListOfStudents ListS= listM.getListOfStudents();
		for(Student student :ListS.getList()) {
			student.fullAdd(ListC.getList(), conn);	
		}
	}
}
