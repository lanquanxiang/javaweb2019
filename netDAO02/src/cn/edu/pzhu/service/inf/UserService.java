package cn.edu.pzhu.service.inf;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	/***
	 * 用户注册
	 * @param user 需要注册的用户名和密码
	 * @return message里面包含了成功和失败的boolean数据，以及失败的原因
	 */
	public Message regist(User user);
	
	public Message login(User user);
	
	public String check(String name);
}
