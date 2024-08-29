package com.revshop.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public static Connection getConnection()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://zilldbinstance.c56oqs26ohc6.ap-south-1.rds.amazonaws.com:3306/Zill","akhil","akki9398");
		return con;
	}

}
