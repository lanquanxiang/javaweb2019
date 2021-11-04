package cn.edu.pzhu.service;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	//登录
	public Message login(User user);
	//注册
	public Message regist(User user);
	//修改密码
	public Message changePwd(User user);
	//销户
	public boolean destroy(User user);
	//检测用户名是否被占用
	public String check(String name);
	
}
