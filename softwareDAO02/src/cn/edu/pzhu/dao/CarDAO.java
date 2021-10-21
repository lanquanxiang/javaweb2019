package cn.edu.pzhu.dao;

import java.util.List;

import cn.edu.pzhu.entity.Car;

public interface CarDAO extends GeneralDAO<Car, Integer>{
	//°´ÕÕ¹Ø¼ü×Ö²éÑ¯
	public List<Car> selectByKeyword(String keyword);
}
