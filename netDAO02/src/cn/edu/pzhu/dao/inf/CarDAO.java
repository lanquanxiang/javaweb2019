package cn.edu.pzhu.dao.inf;

import java.util.ArrayList;

import cn.edu.pzhu.entity.Car;

public interface CarDAO extends GeneralDAO<Car,Integer>{
	//根据需求派生新的方法
	/**
	 * 给定两个价格，查询从start到end之间价格的所有汽车
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<Car> selectByPrice(double start,double end);
	
	//增加分段查询
	public ArrayList<Car> selectAll(int start,int length);
	
	//需要在这个地方增加模糊查询（关键词）
}
