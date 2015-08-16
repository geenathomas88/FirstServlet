package com.sessiontracking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionExample extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		Date sessionCreated = new Date(session.getCreationTime());
		Date lastAcessTime = new Date(session.getLastAccessedTime());
		
		Integer visitCount = new Integer(0);
		String visitKey = new String("visitCount");
		String userIdKey = new String("userId");
		String userId = new String("Abcd");
		String title = "Welcome back";
		
		if(session.isNew()){
			title = "Welcome new user";
		}else{
			visitCount = (Integer) session.getAttribute(visitKey);
			visitCount++;
			userId = (String) session.getAttribute(userIdKey);
		}
		session.setAttribute(visitKey, visitCount);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		pw.write("<html><head><title>"+title+"</title></head><body><h3>"+title+"</h3><table>"+
		"<tr><td>Session Id: </td><td>"+session.getId()+
		"</td></tr><tr><td>Session Created At: </td><td>"+sessionCreated+
		"</td></tr><tr><td>Session last Acess Time: </td><td>"+lastAcessTime+
		"</td></tr><tr><td>User Id: </td><td>"+userId+
		"</td></tr><tr><td>Visit Count: </td><td>"+visitCount+
		"</td></tr></table></body></html>");
		pw.close();
	}
}
