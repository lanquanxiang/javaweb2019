package cn.edu.pzhu.util;

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
	public static DataSource ds = null;
	static{
		//加载配置文件
		InputStream inputStream = JDBCUtil.class.getClassLoader().
				getResourceAsStream("druid.properties");
		Properties pro = new Properties();
		try {
			pro.load(inputStream);
			//druid连接池的初始化方法
			ds = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static DataSource getDs() {
		return ds;
	}
	
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(ResultSet res,Statement sta,Connection con){
		if(res!=null){
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sta!=null){
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void close(Statement sta,Connection con){
		close(null, sta, con);
	}
	
	public static void close(ResultSet res,PreparedStatement sta,Connection con){
		close(res, (Statement)sta, con);
	}
	
	public static void close(PreparedStatement sta,Connection con){
		close(null, (Statement)sta, con);
	}
	
}
