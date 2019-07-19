package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet({ "/bookcart", "/carcart", "/bikecart" })
public class ShoppingCartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri=request.getRequestURI();
		HttpSession session=request.getSession();
		if(uri.endsWith("bookcart"))
		{
			String[] selectedBooks=request.getParameterValues("books");
			session.setAttribute("books", selectedBooks);
			request.getRequestDispatcher("cars.html").forward(request, response);
		}
		else if(uri.endsWith("carcart"))
		{
			String[] selectedCars=request.getParameterValues("cars");
			session.setAttribute("cars", selectedCars);
			request.getRequestDispatcher("bikes.html").forward(request, response);
		}
		else if(uri.endsWith("bikecart"))
		{
			String[] selectedBikes=request.getParameterValues("bikes");
			String[] books=(String[])session.getAttribute("books");
			String[] cars=(String[])session.getAttribute("cars");
			
			/*
			 * PrintWriter pw=response.getWriter(); pw.println("<html><body>");
			 * pw.println("<h4>books<h4>"); pw.println("<ul>");
			 * 
			 * Stream.of(books).map(s->"<li>"+s+"</li>").forEach(pw::println);
			 * 
			 * pw.println("</ul>");
			 * 
			 * pw.println("<h4>cars<h4>"); pw.println("<ul>");
			 * 
			 * Stream.of(cars).map(s->"<li>"+s+"</li>").forEach(pw::println);
			 * 
			 * pw.println("</ul>");
			 * 
			 * pw.println("<h4>bikes<h4>"); pw.println("<ul>");
			 * 
			 * Stream.of(selectedBikes).map(s->"<li>"+s+"</li>").forEach(pw::println);
			 * 
			 * pw.println("</ul>");
			 * 
			 * 
			 * pw.println("</body></html>");
			 */
			
			request.getRequestDispatcher("shopcart_el.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
