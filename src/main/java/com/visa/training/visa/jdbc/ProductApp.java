package com.visa.training.visa.jdbc;

import java.sql.SQLException;
import java.util.List;

public class ProductApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

			ProductDAO dao=new ProductDAO();
			Product toBeSaved=new Product("book",4.5F,10);
			int id=dao.save(toBeSaved);
			System.out.println(id);
			Product p=dao.findById(id);
			System.out.println(p.toString());
			List<Product>li=dao.findAll();
			li.forEach(System.out::println);
			System.out.println("removing paste with id 104");
			dao.remove(105);
			li=dao.findAll();
			li.forEach(System.out::println);
			dao.update(p);
			li=dao.findAll();
			li.forEach(System.out::println);
	}
	

}
