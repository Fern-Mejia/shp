package Student;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Photo.Schedule;

public class Student {
		int id;
		String Fname ;
		String Lname;
		Schedule schedule;
		ArrayList courses;
		 
		Student(int id ,String Fname , String Lname ){
		this.id = id;
		this.Fname = Fname;
		this.Lname = Lname;
		this.schedule = new Schedule();
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
	
	
	
	
	
	
	
}
