package cn.edu.pzhu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DruidUtil {
	private static DataSource dataSource = null;
	static{
		InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//≥ı ºªØ
		try {
			dataSource = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
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
