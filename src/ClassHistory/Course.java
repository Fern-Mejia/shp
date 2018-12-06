package ClassHistory;

import java.sql.Date;
import java.util.ArrayList;
import Student.Student;

public class Course {

	public ArrayList<Student> course_students= new ArrayList<Student>();;
	int course_Id;
	String name ;
	int 	section;
	int  	course;
	int 	year;
	int  	semester;
	String  days  ;
	Date  	starts ;
	Date 	ends ;
	String department;
	public int available;
	
	
	public Course (int course_Id ,String name, int section,int  course,int year,int  semester,String  days , Date  starts ,Date ends ,String department)
	{		this.course_Id = course_Id;
			this.name=name;
			this.section= section;
			this.course=course;
			this.year=year;
			this.semester=semester;
			this.days  =days  ;
			this.starts =starts ;
			this.ends =ends ;
			this.department=department;
			this.available=30;
	}
	
	public Course(int course_ID)
	{
		this.course_Id=course_ID;
	}
	
	
   public int getSection() {return this.section;}

	@Override
	public String toString() {
		return Integer.toString(course_Id) +"  "+ name+" "+ 
	section+" "+course+" "+year+" "+semester+" "+days+" "+starts+" "+ends
	+" "+department+" "+available;
	}


	public ArrayList<Student> getStudents() {
		return this.course_students;
	}
	
	public void add(Student stu)
	{this.course_students.add(stu);}
	
	public int getcourse_Id() {return this.course_Id;}
	public void added() {this.available=this.available-1;}
	
}
