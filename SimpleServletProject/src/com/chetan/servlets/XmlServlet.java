package com.chetan.servlets;

import java.io.*;

import javax.print.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inside XmlServlet, Hello from Get Method");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("XmlServlet, Hello Get method is called");
		String userName = request.getParameter("userName");
		String userId = request.getParameter("id");
		out.println("How are you " + userName.toUpperCase() + "   Your user id is " + userId);
		String profession = request.getParameter("prof");
		String []location = request.getParameterValues("location");
		out.println("You are a " + profession);
		out.println("You are at " + location.length + " places ");
		for (int i = 0; i < location.length; i++) {
			out.println(location[i]);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inside XmlServlet, Hello from Post Method");
		response.getWriter().println("XmlServlet, Hello Post method is called");
		doGet(request, response);
	}
}
