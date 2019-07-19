package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.visa.jdbc.Product;
import com.visa.training.visa.jdbc.ProductDAO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({"/product","/listProducts","/removeProduct"})
public class ProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO dao=new ProductDAO();
		
		if(request.getRequestURI().endsWith("product"))
		{
		String product_name=request.getParameter("product_name");
		String product_price=request.getParameter("product_price");
		String product_qoh=request.getParameter("product_qoh");
		
		Float d1=Float.parseFloat(product_price);
		Integer d2=Integer.parseInt(product_qoh);
		Product p=new Product(product_name,d1,d2);
		
		int id=dao.save(p);
		}
		else if(request.getRequestURI().endsWith("removeProduct"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			dao.remove(id);
		}

		/*
		 * PrintWriter pw=response.getWriter();
		 * pw.println("the details fo the product creatd are "+id+" "+product_name+" "
		 * +d1+" "+d2);
		 */
		try {
			List<Product> li=dao.findAll();
			request.setAttribute("productcontents", li);
			request.getRequestDispatcher("newProduct_el.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	

}
