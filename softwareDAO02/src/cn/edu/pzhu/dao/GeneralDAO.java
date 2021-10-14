package cn.edu.pzhu.dao;

import java.io.Serializable;
import java.util.List;

/**
 * �������б��ͨ�ò���
 * T��ʾ��������ݱ��ʵ���������
 * K��ʾ��ǰʵ��������������
 * @author Administrator
 *
 */
public interface GeneralDAO<T,K extends Serializable> {
	
	public boolean add(T data);
	
	public boolean delete(K key);
	
	public boolean update(T data);
	
	public T select(K key);
	public List<T> selectAll();
}
