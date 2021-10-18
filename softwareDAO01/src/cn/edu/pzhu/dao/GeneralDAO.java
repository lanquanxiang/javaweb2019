package cn.edu.pzhu.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 * @param <T>泛型，表示任意的映射类
 * @param <K>泛型，表示映射类主键的类型
 */
public interface GeneralDAO<T,K extends Serializable> {
	//在此处定义所有表的通用操作
	//增加
	public boolean add(T data);
	//删除
	public boolean delete(K key);
	//修改
	public boolean update(T data);
	//查询
	public T selectById(K key);
	public List<T> select();
}
