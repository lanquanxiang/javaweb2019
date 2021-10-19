package cn.edu.pzhu.service;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.UserDAOImp;
import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public class UserServiceImp implements UserService {
	UserDAO dao = new UserDAOImp();
	@Override
	public Message regist(User user) {
		if (user==null) {
			return new Message(false, "���ݲ��Ϸ�!");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "�û���Ϊ��!");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "����Ϊ��!");
		}
		if (dao.selectById(user.getName())!=null) {
			return new Message(false, "�û�����ռ��!");
		}
		if (dao.add(user)) {
			return new Message(true, "�û�ע��ɹ�!");
		}
		return new Message(false, "δ֪�Ĵ���!");
	}

	@Override
	public Message login(User user) {
		if (user==null) {
			return new Message(false, "���ݲ��Ϸ�!");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "�û���Ϊ��!");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "����Ϊ��!");
		}
		
		User dbUser = dao.selectById(user.getName());
		if (dbUser==null) {
			return new Message(false, "�û�������!");
		}
		if (dbUser.getPassword().equals(user.getPassword())) {
			return new Message(true, "��¼�ɹ�!");
		}
		return new Message(false, "�������!");
	}

	@Override
	public String check(String name) {
		if (name==null || name.equals("")) {
			return "�û������Ϸ�!";
		}
		if (dao.selectById(name)==null) {
			return "�û�������!";
		}else{
			return "�û����Ѿ���ռ��!";
		}
	}

}