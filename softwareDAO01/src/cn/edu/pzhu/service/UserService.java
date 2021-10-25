package cn.edu.pzhu.service;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	//登录
	public Message login(User user);
	//注册
	public Message regist(User user);
	//修改密码
	
	//查询用户名是否可用
	public String check(String name);
	//注销账号
	
}
