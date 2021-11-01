package cn.edu.pzhu.util;


import java.sql.Connection;

import org.junit.Test;

public class C3P0UtilTest {

	@Test
	public void testGetConnection() {
		for (int i = 0; i < 11; i++) {
			Connection con = C3P0Util.getConnection();
			System.out.println(con);
			if (i==5) {
				C3P0Util.close(con, null);
			}
		}
	}

}
