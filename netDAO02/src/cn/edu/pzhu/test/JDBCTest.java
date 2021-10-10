package cn.edu.pzhu.test;

import org.junit.Test;

import cn.edu.pzhu.dao.imp.CarDAOImp;
import cn.edu.pzhu.dao.inf.CarDAO;
import cn.edu.pzhu.entity.Car;

public class JDBCTest {
	CarDAO dao = new CarDAOImp();
	
	@Test
	public void insert(){
		Car car = new Car(100,"zhangsan","people",1.1);
		System.out.println(dao.insert(car));
	}
	
	@Test
	public void delete(){
		Integer id = new Integer(1);
		System.out.println(dao.delete(id));
	}
	
	@Test
	public void select(){
		Integer id = new Integer(2);
		System.out.println(dao.selectById(id));
	}
	
	@Test
	public void selectAll(){
		System.out.println(dao.selectAll());
	}
}
