package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigReader extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ServletConfig config=getServletConfig();
		String initParamValue=config.getInitParameter("user");
		
		ServletContext context=getServletContext();
		String contextInitParamValue=context.getInitParameter("company");
		
		PrintWriter pw=response.getWriter();
		System.out.println("User "+initParamValue);
		System.out.println("Company "+contextInitParamValue);
	}
	

}
