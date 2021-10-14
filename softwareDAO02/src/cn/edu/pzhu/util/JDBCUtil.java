package cn.edu.pzhu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	
	static{
		//加载properties配置文件
		InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//为四个静态变量赋值
		driver = pro.getProperty("driver");
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
		//注册驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(Connection con,Statement sta,ResultSet res){
		if (res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (sta!=null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con,Statement sta){
		close(con, sta, null);
	}
	public static void close(Connection con,PreparedStatement sta,ResultSet res){
		close(con, (Statement)sta, res);
	}
	public static void close(Connection con,PreparedStatement sta){
		close(con, (Statement)sta, null);
	}
		
	
	
}
