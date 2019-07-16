package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product_name=request.getParameter("product_name");
		String product_price=request.getParameter("product_price");
		String product_qoh=request.getParameter("product_qoh");
		
		Float d1=Float.parseFloat(product_price);
		Integer d2=Integer.parseInt(product_qoh);
		Product p=new Product(product_name,d1,d2);
		ProductDAO dao=new ProductDAO();
		int id=dao.save(p);

		PrintWriter pw=response.getWriter();
		pw.println("the details fo the product creatd are "+id+" "+product_name+" "+d1+" "+d2);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}
	

}
