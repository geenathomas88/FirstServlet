package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		ServletConfig config = getServletConfig();
		String uName = config.getInitParameter("uname");//get init-param
		pw.write("user name : " +uName+"<br>");
		
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("dbName");//get single context-param
		pw.write("Driver Name : "+driver+"<br>");

		Enumeration<String> e = context.getInitParameterNames();//get all context param
		while(e.hasMoreElements()){
			String name = e.nextElement();
			pw.write(name +" : " + context.getInitParameter(name)+"<br>");
		}
				pw.close();
	}
}
