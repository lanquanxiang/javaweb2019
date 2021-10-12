package cn.edu.pzhu.test;

import org.junit.Test;

import cn.edu.pzhu.dao.CarDAO;
import cn.edu.pzhu.dao.CarDAOImp;
import cn.edu.pzhu.entity.Car;

public class TemplateTest {
	
	CarDAO dao = new CarDAOImp();
	
	@Test
	public void add(){
		Car car = new Car(100, "zhangsan", "zhangsan", 100.00);
		System.out.println(dao.add(car));
	}
	
	@Test
	public void delete(){		
		System.out.println(dao.detele(100));
	}
	
	@Test
	public void select(){		
		System.out.println(dao.selectById(100));
	}
	
	@Test
	public void selectAll(){		
		System.out.println(dao.selectAll());
	}

}
