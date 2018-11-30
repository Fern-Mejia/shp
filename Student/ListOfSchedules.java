package Student;

import java.util.ArrayList;




import Photo.Schedule;

public class ListOfSchedules {
	static ArrayList<Student> Students = new ArrayList<>();
	ArrayList<Schedule> schedules = new ArrayList<>();
	
	 public static void main(String[] args) {
	 	Students.add(new Student(3000, null, null));
	 	System.out.println(Students.get(0).getFname() +" " + Students.get(0).getLname());
	 }
}