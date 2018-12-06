package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import ClassHistory.Course;

public class ShowSchedule {

	public static void main(String[] args) throws SQLException {
		String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
	    Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		ListManager listM= new ListManager();
		ListOfCourses ListC= listM.getListOfCourses();
		ListOfStudents ListS= listM.getListOfStudents();
		ArrayList<Course> sampleList=ListS.getList().get(1).getClassSchedule(conn);
		for(Course course :sampleList) {
			System.out.println(course.toString());		
		}
	}

}
