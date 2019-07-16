package com.visa.training.visa.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	public int save(Product pro) {
		// insert
		int generatedId = 0;
		try (Connection con = JdbcUtil.getConnection()) {

			Statement st = con.createStatement();
			/*
			 * String str = "Insert into product values(" + toBeSaved.getId() + ",'"+
			 * toBeSaved.getName() + "',"+ toBeSaved.getPrice() + "," + toBeSaved.getQoh() +
			 * ")";
			 */

			String str = "insert into product(product_name,product_price,product_qoh) values(?,?,?)";
			PreparedStatement p = con.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);

			p.setString(1, pro.getName());
			p.setFloat(2, pro.getPrice());
			p.setInt(3, pro.getQoh());
			p.executeUpdate();

			ResultSet keys = p.getGeneratedKeys();
			keys.next();
			generatedId = keys.getInt(1);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generatedId;

	}

	public Product findById(int id) throws SQLException {
		// read based on id

		Product pro = null;
		try (Connection con = JdbcUtil.getConnection()) {
			PreparedStatement p = con.prepareStatement("select * from product where product_id=?");
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();

			if (rs.next()) {
				pro = mapRow(rs);

			}

		}
		return pro;

	}

	private Product mapRow(ResultSet rs) throws SQLException {
		Product pro;
		pro = new Product();
		pro.setId(rs.getInt(1));
		pro.setName(rs.getString(2));
		pro.setPrice(rs.getFloat(3));
		pro.setQoh(rs.getInt(4));
		return pro;
	}

	public List<Product> findAll() throws SQLException { // read all
	  List<Product> li = new ArrayList<Product>();
	  Product p;
	  try (Connection c = JdbcUtil.getConnection()) 
	  { 
		  Statement st =c.createStatement();
		  ResultSet rs=st.executeQuery("select * from product");
		  while(rs.next())
		  {
			  p=mapRow(rs);
			  li.add(p);
		  }
	  }
	  return li;
	  
	  
	  }

	public void remove(int id) {
		// remove
		try(Connection con=JdbcUtil.getConnection()){
			PreparedStatement ps=con.prepareStatement("delete from product where product_id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Product updated) {
		// update
		try(Connection con=JdbcUtil.getConnection()){
			PreparedStatement ps=con.prepareStatement("update product set product_name=?");
			ps.setString(1, updated.getName());
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


