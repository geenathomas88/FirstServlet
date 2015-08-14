package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		ServletContext context = getServletContext();
		context.setAttribute("CompanyName", "Google");
		
		pw.write("Welcome to first page. Attribute Company name is set. <br>");
		pw.write("<a href='getattribute'>visit second page</a>");
		pw.close();
	}
}
