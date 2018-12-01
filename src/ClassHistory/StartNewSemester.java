package ClassHistory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StartNewSemester
 */
@WebServlet("/StartNewSemester")
public class StartNewSemester extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//this Section of code will start a new Semester by following these steps:
	
	
			/*	Part 1: Transfer --------------------------------------------------------
			 * 	1: transfer all the sql data from available_courses to course_history;
			 * 	2: Transfer the course object to the course history object
/// the transfer part of the database is working. 
 * 
 * 
 *///
			/*  
			 *  Part 2: Erase --------------------------------------------------------
			 * 	3: erase the course history object 
			 * 	4: Erase the data from available courses table;
			 
			 
			 *  Part 3: Create new --------------------------------------------------------
			 * 	5: insert new courses to the course table in the database 
			 * 	6: instantiate new course objects 
			 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Albums HomePage</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<form method=\"get\" action+\"StartNewSemester\">");
        out.println("year: <input type=\"text\" name=\"year\" placeholder=\"XXXX\"/>");
        out.println("semester: <input type=\"text\" name=\"semester\" placeholder=\"0 for fall 1 for spring\"/> ");
        out.println("<input type=\"submit\" name=\"submit\">");
       out.println("</form>");
        int semester;
		int year;
		
		if (request.getParameter("submit") != null && request.getParameter("year") != null && request.getParameter("semester") != null) {
			year = Integer.parseInt(request.getParameter("year"));
			semester = Integer.parseInt(request.getParameter("semester"));
			
			HttpSession session = request.getSession(true);
		
			
			if((semester==0||semester==1) && year >= 2018) {
//				request.setAttribute("year", year);
//				request.setAttribute("semester", semester);
				session.setAttribute("year",year);
				session.setAttribute("semester",semester);

				
				out.println("<h1> You Are About the Make a change to the database </h2>");
				out.println("<h3>Please Log In as an Administrator</h3>");
				  
				out.println("<form method=\"post\" action=\"StartNewSemester\"><br>\n" + 
			        		"	Email : <input type=\"text\" name=\"email\" >\n<br>" + 
			        		"	Password : <br><input type=\"text\" name=\"password\">\n" + 
			        		"<input type=\"submit\" name=\"submit\">"+ 
			        		"</form>");
			}
		}
        
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
		
		
	
	} 
	private void Part1(int year, int semester) {
		
		//Transfer Sql data by year  - semester;
		try
	    { 
		      Class.forName("com.mysql.jdbc.Driver");

		  String myUrl ="jdbc:mysql://68.66.205.212/SHP_DB";
	      Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		  String query ="INSERT INTO course_history (course_id , name, section ,course, year, semester, days,starts,ends,department)Select  a.course_id ,  a.name,  a.section , a.course,  a.year,  a.semester,  a.days,  a.starts, a.ends, a.department from available_courses as a WHERE year ="+ year + " and  semester = "+ semester + ";";
		  Statement st = conn.createStatement();
	      int rs = st.executeUpdate(query);
	      System.out.println("Result set: " + rs);
		  
	    }catch(Exception e ){
	    	System.out.println(e);
	    }
		
		//------------------------------------------------------------------------------------------------
		//Now to transfer the objects from courses to history courses.
		
		for(Course course : CourseManager.available_courses) {
			CourseManager.course_history.add(new ClassHistory( course.course_Id, course.getStudents()));
		}
		
		
		
	}
	private void Part2( int year, int semester) {
		
		// erase all the rows from available_courses;
		try{
		  Class.forName("com.mysql.jdbc.Driver");
		  String myUrl ="jdbc:mysql://68.66.205.212/SHP_DB";
	      Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		  String query ="delete from available_courses where year='"+year+"'and semester='"+semester+"';";
		  Statement st = conn.createStatement();
	      int rs = st.executeUpdate(query);
	      System.out.println("Result set: " + rs); 
	    }catch(Exception e ){
	    	System.out.println(e);

	    } 
		
		//------------------------------------------------------------------------------------------------

		
		///erase courses  objects
		for(Course course : CourseManager.available_courses ) {
			course = null;
		}
		CourseManager.available_courses = null;
		
	}
	private void Part3(int year, int semester) throws FileNotFoundException, IOException {
		
		//toggle between semesters.
		if(semester == 1) { // spring 
			semester = 0; //change to fall
		} //toggle between years.
		else {// if semester is fall
			semester = 1; //change to spring. and increment year.
			year++;
		}
		
		//insert new courses into DB.
		String file = "/Users/Israel/Desktop/QueriesCourses.txt";
		String line = "" ;
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){			
			try
		    { 
//                0	     1	2		3	4	5	6		7										8		9  10 11 12  13          14               15          16
//INSERT INTO available_courses ( name, section ,course,2019,1, days,starts,ends,department) Values("INTRO HIGHER EDU-COMP",1010,1,2018,0,"MW","11:00:00.000000","12:00:00.000000","CS");

			//year  = index 11;
			//semester == index 12;
				
				 String myUrl ="jdbc:mysql://68.66.205.212/SHP_DB";
			      Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		      while((line = br.readLine() )!=null) {
		    	  
		    	//split query 
		    	  String[] parts  = line.split(",");
		    	//change semester and year 
		    	  parts[11] = year+"";
		    	  parts[12] = semester+"";
		    	  line="";
		    	  
		    	//unite query back together
		    	  for(int i = 0 ; i < parts.length ; i++) {
		    		  if(i < parts.length-1)
		    			line+=parts[i] + ",";
		    		  else
		    			  line+= parts[i];
		    	  }
		
				  System.out.println(line);
				  
				  //execute query
				  Statement st = conn.createStatement();
			      int rs = st.executeUpdate(line);
			      System.out.println("Result set: " + rs);

			     } conn.close();
		  }catch(Exception e ){
			  System.out.println(e);
		  }
		br.close();}catch(Exception e) {
	    	System.out.println(e);
		}
		//------------------------------------------------------------------------------------------------
		
		// insert new Courses into objects. Selects all from db and instantiates a new object for each.
		CourseManager.available_courses = new ArrayList<Course>();

		try
	    {	
			String myUrl ="jdbc:mysql://israel-java.com/SHP_DB";
		    Connection conn = DriverManager.getConnection(myUrl, "team", "SHPpassword!102" );
		    String query ="Select * from available_courses";
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);

		     while(rs.next()){
		    	  int id = rs.getInt("course_id");
		    	  CourseManager.available_courses.add(new Course(id));
		     }	      
	    }catch(Exception e ) {
	    	System.out.println(e);

	    } 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
    	if (request.getParameter("submit") != null) {
    		out.println("<h4>" + request.getParameter("email") +"</h4>");
			out.println("<h4>" + request.getParameter("password") +"</h4>");

			if(request.getParameter("email").compareTo("admin@shp.com")==0 && 
					request.getParameter("password").compareTo("password")==0) {
				
				HttpSession session = request.getSession(false);

				int y = (Integer) session.getAttribute("year");
				int s = (Integer) session.getAttribute("semester");
//				int y = (Integer) request.getAttribute("year");
//				int s =(Integer) request.getAttribute("semester");
				
//				
//				String year = (String)request.getAttribute("year"); 
////				int y = (Integer) request.getAttribute("year");
//				String semester = (String)request.getAttribute("semester");
//
//				try {
//				int y = Integer.parseInt(year.trim());
//				int s = Integer.parseInt(semester.trim());;
//				}catch(Exception e ) {
//					out.println("<h4>y:" + year + "</h4>");
//					out.println("<h4>y:" + semester + "</h4>");
//
//				}
//				
				
				/*
				* 
				* Execute the three functions. --- --- --- -- START
			 	* 
			 	*/				 
				Part1(y,s);			
				Part2(y,s);			
				Part3(y,s);
				/*
				* 
				* Execute the three functions. --- --- - -- - - END
				* 
				*/	
				
				
				
				
				out.println("<h1> changes have been made to dB</h1>");

			}
			else {
				out.println("<h1> Wrong Password </h1>");
				}
		}else {
			out.println("<h1> no changes have been made </h1>");
		}	
	}
}