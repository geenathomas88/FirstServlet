package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InputValidationFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter service invoked.");
		PrintWriter pw = resp.getWriter();
		
		String userName = req.getParameter("username");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String phonenumber = req.getParameter("phonenumber");
		String[] languages = req.getParameterValues("language");
		
		System.out.println("Filter service invoked.-----"+languages);
		if((userName.isEmpty()) || (address.isEmpty()) || (gender.isEmpty()) || (age.isEmpty()) || (phonenumber.isEmpty()) || (languages == null || languages.length == 0) ){
			pw.write("<h4 style= 'color:red'>Please enter all the fields.</h4>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req,resp);
		}else{
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter invoked.");
		
	}

	
}
