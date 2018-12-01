package ClassHistory;

import java.util.ArrayList;
import Student.Student;

public class Course {

	public ArrayList<Student> course_students;
	int course_Id;
//	String name ;
//	int section;
//	int  course;
//	int year;
//	int  semester;
//	String  days  ;
//	int  starts ;
//	int ends ;
//	String department;
	public int available;
	
	
	Course (int course_Id){
			this.course_students = new ArrayList<Student>();
			this.course_Id = course_Id;
			this.available=30;
	}


	public String toString() {
		return "Course [course_students=" + course_students.size() + ", course_Id=" + course_Id + "]";
	}


	public ArrayList<Student> getStudents() {
		return this.course_students;
	}
	
	public void add(Student stu)
	{this.course_students.add(stu);}
	
}
