package cn.edu.pzhu.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 定义所有表的通用操作
 * T表示任意的数据表的实体类的类型
 * K表示当前实体类主键的类型
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
