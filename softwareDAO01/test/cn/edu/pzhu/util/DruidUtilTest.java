package cn.edu.pzhu.util;


import java.sql.Connection;

import org.junit.Test;

public class DruidUtilTest {

	@Test
	public void testGetConnection() {
		for (int i = 0; i < 11; i++) {
			Connection con = DruidUtil.getConnection();
			System.out.println(con);
			if (i==5) {
				DruidUtil.close(con, null);
			}
		}
	}

}
