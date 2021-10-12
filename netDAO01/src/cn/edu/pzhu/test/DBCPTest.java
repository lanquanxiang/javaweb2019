package cn.edu.pzhu.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.edu.pzhu.util.C3P0Util;
import cn.edu.pzhu.util.DruidUtil;

public class DBCPTest {
	
	@Test
	public void test1(){
		for (int i = 0; i < 11; i++) {
			Connection con = C3P0Util.getConnection();
			System.out.println(con);
			if (i==5) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	@Test
	public void test2(){
		for (int i = 0; i < 11; i++) {
			Connection con = DruidUtil.getConnection();
			System.out.println(con);
			if (i==5) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
