package cn.edu.pzhu.service;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.UserDAOImp;
import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public class UserServiceImp implements UserService{
	
	UserDAO dao = new UserDAOImp();
	
	@Override
	public Message login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message regist(User user) {
		if (user==null) {
			return new Message(false, "数据不合法！");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "用户名为空！");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "密码为空！");
		}
		if (dao.selectById(user.getName())!=null) {
			return new Message(false, "用户已经被注册！");
		}
		if (dao.add(user)) {
			return new Message(true, "注册成功！");
		}else{
			return new Message(false, "注册失败！");
		}
		
	}

	@Override
	public String check(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
