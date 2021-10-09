package cn.edu.pzhu.dao.inf;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ������ӿ��ж���������б��ͨͬ����
 * T�������������ӳ����
 * @author Administrator
 *
 */
public interface GeneralDAO<T,K extends Serializable> {
	/**
	 * ��������������������ݵ�
	 * ����T�Ƿ��ͣ���ʾҪ���ӵ�������
	 * @param data
	 * @return ������ӳɹ�����true�����򷵻�ʧ��
	 */
	public boolean insert(T data);
	
	public boolean delete(K key);
	
	public boolean update(T data);
	
	public T selectById(K key);
	public ArrayList<T> selectAll();
}
