package testing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/TestingServlate")
public class TestingServlate extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
					{
					// Set response content type
					response.setContentType("text/html");
					
					PrintWriter out = response.getWriter();
					String title = "Testing for AdIQuity Input";
					out.println(
							"<html>" +
							"<body>" +
							"<form action=\"TestingServlate\" method=\"GET\">" +
							"Publisher Name:<input type=\"text\" name=\"name\">" + 
							"<br />" +
							"No. of Results   :<input type=\"text\" name=\"no\" />" + 
							"<input type=\"submit\" value=\"Submit\" />" +
							"</form>" +
							"</body>" +
							"</html>");
					
					String name = request.getParameter("name");
					String no =  request.getParameter("no");
					out.println(
							"<html>" +
							"<body>" +
							"<h1>Name is " + name + "</h1>" +
							"<h1>No is   " + no + "</h1>" +
							"</body></html>");
					
					
					if(!no.equals("null")) {
						for(int i=1; i<Integer.parseInt(no); i++) {
							out.println(no);
						}
					}
					
					}
}

//out.println(docType +
//        "<html>\n" +
//        "<head><title>" + title + "</title></head>\n" +
//        "<body bgcolor=\"#f0f0f0\">\n" +
//        "<h1 align=\"center\">" + title + "</h1>\n" +
//        "<ul>\n" +
//        "  <li><b>First Name</b>: "
//        + request.getParameter("first_name") + "\n" +
//        "  <li><b>Last Name</b>: "
//        + request.getParameter("last_name") + "\n" +
//        "</ul>\n" +
//        "</body></html>");
//}


                                                                                                                 