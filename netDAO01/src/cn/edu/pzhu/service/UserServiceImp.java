package cn.edu.pzhu.service;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.UserDAOImp;
import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public class UserServiceImp implements UserService {

	@Override
	public Message regist(User user) {
		if (user==null) {
			return new Message(false, "数据不合法!");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "用户名为空!");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "密码为空!");
		}
		UserDAO dao = new UserDAOImp();
		if (dao.selectById(user.getName())!=null) {
			return new Message(false, "用户名被占用!");
		}
		if (dao.add(user)) {
			return new Message(true, "用户注册成功!");
		}
		return new Message(false, "未知的错误!");
	}

}