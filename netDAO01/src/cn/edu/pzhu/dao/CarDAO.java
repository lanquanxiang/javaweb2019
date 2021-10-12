package cn.edu.pzhu.dao;

import java.util.List;

import cn.edu.pzhu.entity.Car;

public interface CarDAO extends GeneralDAO<Car,Integer>{
	//扩展其他方法
	/**
	 * 按照关键词查询
	 * @param keyword
	 * @return
	 */
	public List<Car> selectByKeyword(String keyword);
	//扩展按照价格来查询
	
}
