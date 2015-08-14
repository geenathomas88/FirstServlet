package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorefreshExample extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setIntHeader("Refresh", 5);
		resp.setContentType("text/html");
		Calendar calendar = new GregorianCalendar();
		
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String am_pm;
		
		if(calendar.get(Calendar.AM_PM)== 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		
		String currentTime = hour +" : " + minute +" : " +second +" "+ am_pm;
		
		PrintWriter pw = resp.getWriter();
		pw.write("Current Time :"+currentTime);
		pw.close();
	}
}
