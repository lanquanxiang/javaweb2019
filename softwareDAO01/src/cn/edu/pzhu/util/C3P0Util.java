package cn.edu.pzhu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static DataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
		//dataSource = new ComboPooledDataSource("otherc3p0");
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
