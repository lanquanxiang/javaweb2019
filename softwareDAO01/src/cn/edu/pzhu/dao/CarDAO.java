package cn.edu.pzhu.dao;

import java.util.List;

import cn.edu.pzhu.entity.Car;

public interface CarDAO extends GeneralDAO<Car, Integer>{
	//���չؼ��ֽ���ģ����ѯ
	public List<Car> selectByKeyword(String keyword);
	//���ռ۸���в�ѯ
	
}
