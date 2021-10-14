package cn.edu.pzhu.service.imp;

import cn.edu.pzhu.dao.imp.UserDAOImp;
import cn.edu.pzhu.dao.inf.UserDAO;
import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.service.inf.UserService;

public class UserServiceImp implements UserService{

	private UserDAO dao = new UserDAOImp();
	
	@Override
	public Message regist(User user) {
		if (user==null) {
			return new Message(false, "数据不合法!");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "用户名不能为空!");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "密码不能为空!");
		}
		//查询用户是都被占用了
		if (dao.selectById(user.getName())!=null) {
			return new Message(false, "用户名已经被占用!");
		}
		
		if (dao.insert(user)) {
			return new Message(true, "用户注册成功!");
		}
		
		return new Message(false, "用户名注册失败!");
	}

	@Override
	public Message login(User user) {
		if (user==null) {
			return new Message(false, "数据不合法!");
		}
		User user2 = dao.selectById(user.getName());
		if (user2==null) {
			return new Message(false, "用户不存在!");
		}
		if (user2.getPassword().equals(user.getPassword())) {
			return new Message(true, "登录成功!");
		}else{
			return new Message(true, "密码错误!");
		}
	}

}
