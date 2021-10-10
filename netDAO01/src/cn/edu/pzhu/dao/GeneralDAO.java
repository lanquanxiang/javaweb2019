package cn.edu.pzhu.dao;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * �ڹ����ӿ��ж���������б����е�ͨ�ò���
 * T���������ʵ������
 * K�����������ʵ�����������
 * @author Administrator
 *
 */
public interface GeneralDAO<T,K extends Serializable> {
	public boolean add(T data);
	public boolean detele(K key);
	public boolean update(T data);
	
	public T selectById(K key);
	public ArrayList<T> selectAll();
}
