package cn.edu.pzhu.service;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	//µÇÂ¼
	public Message login(User user);
	//×¢²á
	public Message regist(User user);
	//ĞŞ¸ÄÃÜÂë
	public Message changePwd(User user);
	//Ïú»§
	public boolean destroy(User user);
}
