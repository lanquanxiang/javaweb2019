package cn.edu.pzhu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	public static DataSource ds = new ComboPooledDataSource();
	public static DataSource getDs() {
		return ds;
	}
	//2.获得连接
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//3.释放资源
	public static void close(Connection con,Statement sta,ResultSet res){
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
