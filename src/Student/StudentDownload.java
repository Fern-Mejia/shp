package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class StudentDownload {

	public static void main(String[] args) {
		ListManager listM= new ListManager();
		listM.printCourses();
	}

}
