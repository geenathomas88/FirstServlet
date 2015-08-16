package com.sessiontracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCookie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		Cookie cookie= null;
		Cookie[] cookies = null;
			
		cookies = req.getCookies();
		for(int i=0;i<cookies.length;i++){
			cookie = cookies[i];
			pw.write("hello your"+cookie.getName()+" is "+cookie.getValue());
		}
		pw.write("<a href= \"logout\">Logout</a>");
		pw.close();
	}
}
