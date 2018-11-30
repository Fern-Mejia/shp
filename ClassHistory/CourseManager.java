package ClassHistory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class CourseManager {
	static ArrayList<Course> available_courses = new ArrayList<Course>();
	static ArrayList<ClassHistory> course_history = new ArrayList<ClassHistory>();
}
