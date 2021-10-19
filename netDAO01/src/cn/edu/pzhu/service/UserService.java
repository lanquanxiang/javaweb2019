package cn.edu.pzhu.service;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	//注册
	//结果：用户名为空，失败；密码为空，失败；用户名被占用，失败；其他异常，失败；添加成功，成功。
	public Message regist(User user);
	//登录
	public Message login(User user);
	//修改密码
	
	//销毁账户
	
	//检测用户名是否被占用
	public String check(String name);
}
