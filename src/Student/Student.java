package Student;
import java.sql.*;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import ClassHistory.Course;
import Photo.Schedule;

public class Student {
		int id;
		String Fname ;
		String Lname;
		Schedule schedule;
		ArrayList<Course> courses;
		int units;
		 
		Student(int id ,String Fname , String Lname ){
		this.id = id;
		this.Fname = Fname;
		this.Lname = Lname;
		this.schedule = new Schedule();
		this.units=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return this.Fname + " "+ this.Lname + "\tcin:" + this.id;
	} 

	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	
	public void add(Course course)
	{
	course.add(this);
	
	/*INSERT INTO students_in_class (cin, course_Id)
	VALUES (this.cin , course.course_Id);*/
	
	}
	
	public void fullAdd(Course[] courses)
	{
	int i=0;
	
	while(this.units<18 && courses.length>i)
	{
	if(courses[i].available>0)
	{
	this.add(courses[i]);
	}
	i++;
	}
	}
	
	
	
	
	
}

