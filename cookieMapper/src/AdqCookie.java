import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Servlet implementation class AdqCoockie
 */
@WebServlet("/AdqCookie")

public class AdqCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
	
		String param = request.getParameter("tpc_cookie");
		String getcookie = readCookie(request , param);
		if(getcookie != null) {
			
		}else {
			createCookie(request , response);
			
		}
	}
	
	public void createCookie(HttpServletRequest request, HttpServletResponse response) 
		throws UnknownHostException {
		
		String cookieNameParam ="adq_"+ InetAddress.getLocalHost().getHostAddress() + getTimestamp();
		Cookie cookie = new Cookie("adq_cookie", cookieNameParam);
				cookie.setMaxAge(60*60*24*365); // 1 year
				response.addCookie(cookie);

	}
	
	public String readCookie(HttpServletRequest request , String param) {

		String tpcCookieValue = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals(param) ) {
					tpcCookieValue = (c.getValue());
					return tpcCookieValue;
				}
			}
		}
		return null;
	}
	
//	public String adqCookieValue(HttpServletRequest request) {
//		
//		String cookieValue="Adq";
//		String tpcCookieValue = readCookie(request);
//		
//		if(!tpcCookieValue.equals(null) && !tpcCookieValue.equals("")) {
//			cookieValue+=
//		}
//		
//		
//		return cookieValue;
//	}
	
	private String getTimestamp() {
		//DateFormat df = DateFormat.getTimeInstance();
	    Calendar cal = Calendar.getInstance();
	    Timestamp time = new Timestamp(cal.getTimeInMillis());

	    // Prints local time
	    //System.out.println(df.format(new Date(time.getTime())));
	    // Printe local time, but I want UTT Time
	    //System.out.println("timestamp: " + time);
	    return time.toString();
	}
	
	public void checkHashMapper(){
		
	}
	
}



