package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Initialized");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Service method doGet is invoked");
		String userName = req.getParameter("username");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String phonenumber = req.getParameter("phonenumber");
		String[] languages = req.getParameterValues("language");
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		pw.print("<h1>Welcome "+userName+"</h1>");
		pw.print("<p>Address:"+address+"</p>");
		pw.print("<p>Gender:"+gender+"</p>");
		pw.print("<p>Age:"+age+"</p>");
		pw.print("<p>Phone Number:"+phonenumber+"</p>");
		pw.print("<p>Languages:");
		for(String language:languages){
			pw.print(language + " ");
		}pw.print("</p>");
		pw.close();
	}

	@Override
	public void destroy() {
	System.out.println("Servlet Destroyed!!");
	}
}
