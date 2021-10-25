package cn.edu.pzhu.dao;

import java.util.List;

import cn.edu.pzhu.entity.Car;

public interface CarDAO extends GeneralDAO<Car, Integer>{
	//按照关键字进行模糊查询
	public List<Car> selectByKeyword(String keyword);
	//按照价格进行查询
	
}
