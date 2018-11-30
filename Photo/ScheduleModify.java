package Photo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ScheduleModify")
public class ScheduleModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		 ArrayList<Schedule> SchedulesList = new  ArrayList<Schedule>();		 
		 SchedulesList.add(new Schedule());
		 SchedulesList.add(new Schedule());
		 getServletContext().setAttribute("SchedulesList", SchedulesList);	 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Modify Schedule</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
       
        
        out.println("<Style>");  
        out.println(".true{ background: green;"
        		+ "width:30px; height:30px;}");
        out.println(".false{ background: red;"
        		+ "width:30px; height:30px;}");
       out.println("th, td {\n" + 
       		"    text-align: center;\n" + 
       		"} ;"
       		+ ".noselect {\n" + 
       		"  -webkit-touch-callout: none; /* iOS Safari */\n" + 
       		"    -webkit-user-select: none; /* Safari */\n" + 
       		"     -khtml-user-select: none; /* Konqueror HTML */\n" + 
       		"       -moz-user-select: none; /* Firefox */\n" + 
       		"        -ms-user-select: none; /* Internet Explorer/Edge */\n" + 
       		"            user-select: none; /* Non-prefixed version, currently\n" + 
       		"                                  supported by Chrome and Opera */\n" + 
       		"}");
       out.println(".right{"
       		+ "float:right;};");
        out.println("</Style>");
        
        out.println("</head>");
        out.println("<body>");
         
        out.println("<div class=\"container\">");
        
        out.println("<H1>Schedule Modifier</H1>");
        
        out.println("<div class=\"right\">");
        
        out.println("<H3>Hold down <small>shift</small> key and hover over boxes</h3>");
        out.println("<H3>Or <small>click</small> down on the boxes to modify</h3>");
        
        out.println("<H3>");
    	out.println("<input type=\"button\" class=\"true\"> </button>");
    	out.println("means available</H3>");
    	
    	  out.println("<H3>");
      	out.println("<input type=\"button\" class=\"false\"> </button>");
      	out.println("means unavailable</H3>");
      	out.println("</div>");
        ArrayList<Schedule> schedules = (ArrayList<Schedule>) getServletContext().getAttribute("SchedulesList");
 
        if(schedules != null) {

        //here the code should get the query from the database to get the id of the logged in student.
        //for testing purposes i am using 0 as the first index.
        
        Schedule schedule = null ;
        
        for(Schedule sch :  schedules) {
        	if(sch.getId() == 3000) {
        		schedule = sch;
        		break;
        	}
        }
        
        Button[][] temp = schedule.getButtons();
         
    	out.println("<table class=\"noselect\">");
	    	out.println("<tr>" );
		    	out.println("<td> Hours </td>");
		    	out.println("<td> Mon</td>");
		        out.println("<td> Tue</td>");
		        out.println("<td> Wed</td>");
		        out.println("<td> Thu</td>");
		        out.println("<td>Fri</td>");
		        out.println("<td> Sat</td>");
	    	out.println("</tr>" );
    	int time = 7;
        for(int i = 0 ; i < temp.length ; i++) {
        	out.println("<tr>");
        	if(time < 12)
        		out.println("<td>" + (time) +":00 AM</td>");
        	else {
        		if(time - 12 == 0)
            		out.println("<td>" + 12 +":00 PM</td>");
        		else
        			out.println("<td>" + (time - 12) +":00 PM</td>");
        	}
        	for(int j = 0 ; j < temp[0].length; j++) {
            	out.println("<td>");
        		out.println( temp[i][j].toString() );
            	out.println("</td>");
        	}
        	out.println("</tr>");
        	time++;
        }
    	out.println("</table>");


        out.println("<button  onclick=\"Submit()\" >Submit</button>");

        out.println("<form id=\"myForm\" action=\"Change\" method=\"POST\" hidden>\n" + 
        		"		    matrix:  <input type=\"text\" name=\"matrix\" id=\"textHidden\" value=\"\"><br>\n" + 
        		"		 CIN : <input type=\"text\" name=\"cin\" id=\"cinHidden\" value=\"\"><br>\n " +
        		"		</form>");
       
        out.println("<script>\n" + 
        		"function myFunction(element) {\n" + 
        		"\n" + 
        		"    if( element.className==\"true\"){\n" + 
        		"        element.className = \"false\";\n" + 
        		"    } else{\n" + 
        		"        element.className = \"true\";\n" + 
        		"    }   \n" + 
        		"}\n" + 
        		
        		
        		
        		"function Submit(){\n" + 
        		"    var matrix =\"\";\n" + 
        		"\n" + 
        		"    for (let i = 0; i < 16; i++) {\n" + 
        		"       for(let j = 0 ; j < 6 ; j++){\n" + 
        		"           if(document.getElementById(i + \",\" + j).className == \"true\"){\n" + 
        		"               matrix += \"1\";\n" + 
        		"           }else{\n" + 
        		"                matrix += \"0\";\n" + 
        		"           }\n" + 
        		"\n" + 
        		"       }\n" + 
        		"        \n" + 
        		"    }\n" + 
        		"    document.getElementById(\"textHidden\").value = matrix;\n" + 
        		"    document.getElementById(\"cinHidden\").value = " + schedule.id+ ";\n" + 
        		"    document.getElementById(\"myForm\").submit();\n" + 
        		"}\n" + 
        		"</script> ");
        
        
        
        
        out.println("<script>\n" + 
        		"function drag(x) {\n" + 
        		"            if (event.shiftKey) {\n" + 
        		"                if( x.className==\"true\"){\n" + 
        		"        x.className = \"false\";\n" + 
        		"    } else{\n" + 
        		"        x.className = \"true\";\n" + 
        		"    }    \n" + 
        		"              \n" + 
        		"                }\n" + 
        		"            \n" + 
        		"        }\n" + 
        		"        </script>");
	}
        else {
        	out.println("<h1>Empty List</h1> ");
        }
        
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
