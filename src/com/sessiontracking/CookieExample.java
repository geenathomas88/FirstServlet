package com.sessiontracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieExample extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String uName = req.getParameter("username");
		pw.write("Welcome "+uName);
		
		Cookie cookie = new Cookie("userName", uName);
		resp.addCookie(cookie);
		
		pw.write("<form action=\"showcookie\" method=\"get\">");
		pw.write("<h2>This is an example to learn Cookie</h2>");
		pw.write("Email : <input type=\"text\" name=\"email\">");
		pw.write("<input type='submit' value='Go'>");
		pw.write("</form>");
	}
}
