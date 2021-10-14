package cn.edu.pzhu.dao.inf;

import java.util.ArrayList;

import cn.edu.pzhu.entity.Car;

public interface CarDAO extends GeneralDAO<Car,Integer>{
	//�������������µķ���
	/**
	 * ���������۸񣬲�ѯ��start��end֮��۸����������
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<Car> selectByPrice(double start,double end);
	
	//���ӷֶβ�ѯ
	public ArrayList<Car> selectAll(int start,int length);
	
	//��Ҫ������ط�����ģ����ѯ���ؼ��ʣ�
}
