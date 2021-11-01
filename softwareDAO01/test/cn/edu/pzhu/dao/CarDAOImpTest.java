package cn.edu.pzhu.dao;


import org.junit.Test;

public class CarDAOImpTest {
	
	CarDAO dao = new CarDAOImp();
	
	@Test
	public void testDelete() {
		System.out.println(dao.delete(new Integer(50)));
	}

	@Test
	public void testSelectById() {
		System.out.println(dao.selectById(new Integer(50)));
	}

	@Test
	public void testSelect() {
		System.out.println(dao.select());
	}

}
