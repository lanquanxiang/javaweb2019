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
