package cn.edu.pzhu.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 * @param <T>���ͣ���ʾ�����ӳ����
 * @param <K>���ͣ���ʾӳ��������������
 */
public interface GeneralDAO<T,K extends Serializable> {
	//�ڴ˴��������б��ͨ�ò���
	//����
	public boolean add(T data);
	//ɾ��
	public boolean delete(K key);
	//�޸�
	public boolean update(T data);
	//��ѯ
	public T selectById(K key);
	public List<T> select();
}
