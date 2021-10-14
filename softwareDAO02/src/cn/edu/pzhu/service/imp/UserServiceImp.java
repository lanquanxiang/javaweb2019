package cn.edu.pzhu.service.imp;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.imp.UserDAOImp;
import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.service.UserService;

public class UserServiceImp implements UserService{
	
	UserDAO dao = new UserDAOImp();
	
	@Override
	public Message login(User user) {
		if (user==null) {
			return new Message(false, "数据不合法!");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "用户名为空!");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "密码为空!");
		}
		User dbuser = dao.select(user.getName());
		if (dbuser==null) {
			return new Message(false, "用户名不存在!");
		}
		if (dbuser.getPassword().equals(user.getPassword())) {
			return new Message(true, "登录成功!");
		}else{
			return new Message(false, "密码错误!");
		}
		
	}

}
