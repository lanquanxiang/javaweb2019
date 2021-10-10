package cn.edu.pzhu.dao;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 在公共接口中定义对于所有表都具有的通用操作
 * T代表的任意实体类型
 * K代表的是任意实体的主键类型
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
