package cn.edu.pzhu.service.inf;

import java.util.ArrayList;

import cn.edu.pzhu.entity.Car;

public interface CarService {
	//显示所有汽车信息
	public ArrayList<Car> showCar();
	//显示第page页的num条信息
	public ArrayList<Car> showCar(int page,int num);
	//新增一辆汽车信息
	
	//按照关键词查询汽车信息
	
	//编辑汽车信息
	
	//删除汽车信息
}
