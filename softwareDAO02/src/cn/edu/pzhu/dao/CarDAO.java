package cn.edu.pzhu.dao;

import java.util.List;

import cn.edu.pzhu.entity.Car;

public interface CarDAO extends GeneralDAO<Car, Integer>{
	//���չؼ��ֲ�ѯ
	public List<Car> selectByKeyword(String keyword);
}
