package Photo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Change
 */
@WebServlet("/Change")
public class Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String str =  request.getParameter("matrix");
		 String s = request.getParameter("cin");
		 int cin = Integer.parseInt(s);
		 
	        ArrayList<Schedule> schedules = (ArrayList<Schedule>) getServletContext().getAttribute("SchedulesList");
	        
	        Schedule schedule = null ;
	        
	        
	        for(Schedule sch :  schedules) {
	        	if(sch.getId() == 3000) {
	        		schedule = sch;
	        		break;
	        	}
	        }

	        
	        Button[][] buttons = schedule.getButtons();
	        boolean[][] bools = schedule.getAvailable();
	        
	        

		 if(str != null) {
			 int charPos=0;
			 for(int i = 0 ; i < 16 ; i++){
				 for(int j  = 0 ; j < 6 ; j++) {
					 if(str.charAt(charPos++)=='1') {
							bools[i][j] = true;
							buttons[i][j].setClicked(true);
					 }else {
							bools[i][j] = false;
							buttons[i][j].setClicked(false);
					 }
				 }
			 }
			 
			 
			 
		        schedule.setAvailable(bools);
		        schedule.setButtons(buttons);

		        getServletContext().setAttribute("SchedulesList", schedules);
			 response.setContentType("text/html");
		        
		    PrintWriter out = response.getWriter();
		    
		     
		    out.println("you have altered the schedule for student with cin "  + cin);
		    
		    
	          schedules = (ArrayList<Schedule>) getServletContext().getAttribute("SchedulesList");
	        
	        schedule = null ;
	        
	        
	        for(Schedule sch :  schedules) {
	        	if(sch.getId() == 3000) {
	        		schedule = sch;
	        		break;
	        	}
	        }
	       boolean[][] a  =  schedule.getAvailable();
	       out.println("<div>");
	        for(int i = 0 ; i < a.length ; i++){
				 for(int j  = 0 ; j < a[i].length ; j++) {
					 out.print(a[i][j] + " ");
				 	}
				out.println("<div>");
	        }
		 }
		 
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
