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
			return new Message(false, "���ݲ��Ϸ�!");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "�û���Ϊ��!");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "����Ϊ��!");
		}
		User dbuser = dao.select(user.getName());
		if (dbuser==null) {
			return new Message(false, "�û���������!");
		}
		if (dbuser.getPassword().equals(user.getPassword())) {
			return new Message(true, "��¼�ɹ�!");
		}else{
			return new Message(false, "�������!");
		}
		
	}

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
		if (dao.select(user.getName())!=null) {
			return new Message(false, "�û����Ѿ���ռ��!");
		}
		if (dao.add(user)) {
			return new Message(true, "�˺�ע��ɹ�!");
		}
		return new Message(false, "�˺�ע��ʧ��!");
	}

	@Override
	public Message changePwd(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String check(String name) {
		if (name==null || name.equals("")) {
			return "�û������Ϸ�!";
		}
		if (dao.select(name)==null) {
			return "���û�����!";	
		}else{
			return "�û����Ѿ���ע��!";
		}
	}

}
