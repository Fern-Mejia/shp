package Student;
import java.sql.*;
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
	
	
	public void add(Course course, Connection conn)
	{
	course.add(this);
	this.units=this.units+3;
	course.added();
	try {
    String query ="INSERT INTO students_in_class (cin, course_Id) VALUES ("+this.id +", "+course.getcourse_Id()+")";
    Statement st = conn.createStatement();
    int rs = st.executeUpdate(query);
	} catch(Exception e){}
	
	}
	
	public void fullAdd(ArrayList<Course> courses, Connection conn) throws SQLException
	{
	int i=0;
	while(this.units<18 && courses.size()>i)
	{
		if(courses.get(i).available>0 && this.checkForDups(this.courses, courses.get(i))) 
		{this.add(courses.get(i), conn);}
		i++;
		}
	}
	
	public ArrayList<Course> getClassSchedule(Connection conn){
		ArrayList<Course> List= new ArrayList<Course>();
		try {
		    String query ="Select course_Id from students_in_class WHERE cin= "+ this.id;
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while(rs.next()){
		    	  int course_Id = rs.getInt("course_Id");
		    	  List.add(new Course(course_Id));  	  
		     }	
			} catch(Exception e){}
		
		return this.getClassScheduleFromDB(conn, List);
	}
	
	public ArrayList<Course> getClassScheduleFromDB(Connection conn, ArrayList<Course> List){
		ArrayList<Course> List2= new ArrayList<Course>();
		for(Course courses :List) {
		try {
		    String query ="Select * from available_courses WHERE course_Id= "+ courses.getcourse_Id() ;
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while(rs.next()){
		    	  int course_Id = rs.getInt("course_Id");
		    	  String name= rs.getString("name");
		    	  int section = rs.getInt("section");
		    	  int  course = rs.getInt("course");
		          int year = rs.getInt("year");
		    	  int  semester = rs.getInt("semester");
		    	  String  days = rs.getString("days");
		    	  Date  starts = rs.getDate("starts"); 
		    	  Date ends = rs.getDate("ends"); 
		    	  String department  = rs.getString("department");
		    	  List2.add(new Course(course_Id,name,section,course,year,semester,days,starts,ends,department));  	  
		     }	 
			} catch(Exception e){}
		}
		return List2;
	}
	
	public boolean checkForDups(ArrayList<Course> courses, Course course) {
		try {
		for(Course c: courses)
		{if(c.getSection()==course.getSection()) {return false;}}
		return true;
	  }catch(NullPointerException e) {return true;}
	}
}

