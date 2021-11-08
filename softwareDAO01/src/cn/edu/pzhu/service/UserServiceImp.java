package cn.edu.pzhu.service;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.UserDAOImp;
import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public class UserServiceImp implements UserService{
	
	UserDAO dao = new UserDAOImp();
	
	@Override
	public Message login(User user) {
		if (user==null) {
			return new Message(false, "���ݲ��Ϸ���");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "�û���Ϊ�գ�");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "����Ϊ�գ�");
		}
		User dbUser = dao.selectById(user.getName());
		if (dbUser==null) {
			return new Message(false, "�û������ڣ�");
		}
		if (dbUser.getPassword().equals(user.getPassword())) {
			return new Message(true, "��¼�ɹ���");
		}else{
			return new Message(false, "�������");
		}
	}

	@Override
	public Message regist(User user) {
		if (user==null) {
			return new Message(false, "���ݲ��Ϸ���");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "�û���Ϊ�գ�");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "����Ϊ�գ�");
		}
		if (dao.selectById(user.getName())!=null) {
			return new Message(false, "�û��Ѿ���ע�ᣡ");
		}
		if (dao.add(user)) {
			return new Message(true, "ע��ɹ���");
		}else{
			return new Message(false, "ע��ʧ�ܣ�");
		}
		
	}

	@Override
	public String check(String name) {
		if(name==null||name.equals("")){
			return "������û������Ϸ�";
		}
		if(dao.selectById(name)==null){
			return "���û�������ʹ��";
		}
		return "�û����Ѿ���ע��";
	}

}
