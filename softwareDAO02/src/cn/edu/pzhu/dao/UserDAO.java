package cn.edu.pzhu.dao;

import cn.edu.pzhu.entity.User;

public interface UserDAO extends GeneralDAO<User, String>{
	//扩展其他方法（公共接口中无法满足需求的方法）
}
