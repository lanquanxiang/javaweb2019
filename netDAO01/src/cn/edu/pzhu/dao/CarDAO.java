package cn.edu.pzhu.dao;

import java.util.List;

import cn.edu.pzhu.entity.Car;

public interface CarDAO extends GeneralDAO<Car,Integer>{
	//��չ��������
	/**
	 * ���չؼ��ʲ�ѯ
	 * @param keyword
	 * @return
	 */
	public List<Car> selectByKeyword(String keyword);
	//��չ���ռ۸�����ѯ
	
}
