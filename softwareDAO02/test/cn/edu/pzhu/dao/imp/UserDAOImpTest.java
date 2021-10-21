package cn.edu.pzhu.dao.imp;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.entity.User;

public class UserDAOImpTest {
	
	UserDAO dao = new UserDAOImp();
	
	@Test
	public void testAdd() {
		System.out.println(dao.add(new User("8", "8")));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelect() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

}
