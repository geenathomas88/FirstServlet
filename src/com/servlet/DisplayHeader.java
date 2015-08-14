package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayHeader extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String title= "HTTP Request Response Header";
		String docType =
			      "<!doctype>\n";
		
		pw.write(docType + "<html>\n" +
		        "<head><title>" + title + "</title></head>\n"+
		        "<body bgcolor=\"#f0f0f0\">\n" +
		        "<h1 align=\"center\">" + title + "</h1>\n" +
		        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
		        "<tr bgcolor=\"#949494\">\n" +
		        "<th>Header Name</th><th>Header Value(s)</th>\n"+
		        "</tr>\n");
		
		Enumeration<String> headerNames = req.getHeaderNames();
		
		while(headerNames.hasMoreElements()){
			String paramName = (String)headerNames.nextElement();
			pw.write("<tr><td>"+paramName + "</td>");
			Enumeration values = req.getHeaders(paramName); // support multiple values
		      if (values != null) {
		        while (values.hasMoreElements()) {
		          String value = (String) values.nextElement();
		          pw.write("<td>"+value + "</td></tr>");
		        }
		}}
		pw.write("</table></body></html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
