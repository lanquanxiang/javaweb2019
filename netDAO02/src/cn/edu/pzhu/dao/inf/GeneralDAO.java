package cn.edu.pzhu.dao.inf;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 在这个接口中定义对于所有表的通同操作
 * T代表的是任意表的映射类
 * @author Administrator
 *
 */
public interface GeneralDAO<T,K extends Serializable> {
	/**
	 * 这个方法是用来增加数据的
	 * 其中T是泛型，表示要增加的数据类
	 * @param data
	 * @return 如果增加成功返回true，否则返回失败
	 */
	public boolean insert(T data);
	
	public boolean delete(K key);
	
	public boolean update(T data);
	
	public T selectById(K key);
	public ArrayList<T> selectAll();
}
