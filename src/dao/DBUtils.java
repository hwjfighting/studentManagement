package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static final String url="jdbc:mysql://localhost:3306/db_student?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";//数据库地址
	public static final String username="root";
	public static final String password="root";
	
	/**
	 * 返回数据库的连接对象
	 */
	
	public static Connection getCon() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			con=DriverManager.getConnection(url, username, password);//建立连接
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return con;
	}
	
	public static void main(String[] args) {
		Connection c1=getCon();
		System.out.println(c1);
	}

}
