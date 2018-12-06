package Student;

import java.util.ArrayList;

import ClassHistory.Course;
import Photo.Schedule;

public class ListManager {
	ListOfCourses Courses = new ListOfCourses();
	ListOfStudents Students = new ListOfStudents();
	
	
	public ListOfStudents getListOfStudents()
	{
		return this.Students;
	}
	
	public ListOfCourses getListOfCourses()
	{
		return this.Courses;
	}
	
	public void print() {	
		/*for(Student student :this.Students.List) {
			System.out.println(student.toString());		
		}*/
		for(Course course :this.Courses.List) {
			System.out.println(course.toString());		
		}
	}
	
}
