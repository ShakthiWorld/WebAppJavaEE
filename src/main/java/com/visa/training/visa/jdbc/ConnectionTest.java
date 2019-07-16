package com.visa.training.visa.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		
		Connection c=JdbcUtil.getConnection();
		DatabaseMetaData metaData=c.getMetaData();
		System.out.println("product name is "+metaData.getDatabaseProductName());
		System.out.println("version name is "+metaData.getDatabaseProductVersion());

	}

}
