package ClassHistory;

import java.util.ArrayList;
import Student.Student;

public class Course {

	public ArrayList<Student> course_students;
	int course_Id;
	String name ;
//	int section;
//	int  course;
//	int year;
//	int  semester;
//	String  days  ;
//	int  starts ;
//	int ends ;
//	String department;
	public int available;
	
	
	public Course (int course_Id, String name){
			this.course_students = new ArrayList<Student>();
			this.course_Id = course_Id;
			this.name=name;
			this.available=30;
	}

	@Override
	public String toString() {
		return Integer.toString(course_Id) +"  "+ name;
	}


	public ArrayList<Student> getStudents() {
		return this.course_students;
	}
	
	public void add(Student stu)
	{this.course_students.add(stu);}
	
}
