package com.ssm.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	
	private static String url = "jdbc:mysql://localhost:3306/db_telephone_book";;
	private static String username = "root";;
	private static String password = "root";;
	
	private static Connection conn;
	
	
	//得到连接
	public Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}	
		
		return conn;
		
		
	}
	//关闭连接
	
	public void closeConnection(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
	}
}
