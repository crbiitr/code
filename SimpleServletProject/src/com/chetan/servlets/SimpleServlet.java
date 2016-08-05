package com.chetan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(urlPatterns = { "/SimpleServlet", "/SimpleServletPath" }, initParams = {@WebInitParam( name = "userName", value = "Atul")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

/*	*//**
	 * @see Servlet#init(ServletConfig)
	 *//*
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello from init method");
	}

	*//**
	 * @see Servlet#destroy()
	 *//*
	public void destroy() {
		System.out.println("Hello from destroy method");
	}

	*//**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from service method");
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Hello from doGet method");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3> Hi, How are you </h3></body></html>");
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		if (userName != null && userName.length() > 0) {
			session.setAttribute("sessionUserName", userName);
			context.setAttribute("contextUserName", userName);
		}
		
		out.println("<br>Request parameter has user name as : " + userName);
		out.println("<br>Session parameter has user name as : " + (String) session.getAttribute("sessionUserName"));
		out.println("<br>context parameter has user name as : " + (String) context.getAttribute("contextUserName"));
		out.println("<br>Init parameter has default user name as : " + getServletConfig().getInitParameter("userName"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from doPost method");
	}

}
