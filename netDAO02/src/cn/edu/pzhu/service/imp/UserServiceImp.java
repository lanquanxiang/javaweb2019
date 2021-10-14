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
			return new Message(false, "���ݲ��Ϸ�!");
		}
		if (user.getName()==null || "".equals(user.getName())) {
			return new Message(false, "�û�������Ϊ��!");
		}
		if (user.getPassword()==null || "".equals(user.getPassword())) {
			return new Message(false, "���벻��Ϊ��!");
		}
		//��ѯ�û��Ƕ���ռ����
		if (dao.selectById(user.getName())!=null) {
			return new Message(false, "�û����Ѿ���ռ��!");
		}
		
		if (dao.insert(user)) {
			return new Message(true, "�û�ע��ɹ�!");
		}
		
		return new Message(false, "�û���ע��ʧ��!");
	}

	@Override
	public Message login(User user) {
		if (user==null) {
			return new Message(false, "���ݲ��Ϸ�!");
		}
		User user2 = dao.selectById(user.getName());
		if (user2==null) {
			return new Message(false, "�û�������!");
		}
		if (user2.getPassword().equals(user.getPassword())) {
			return new Message(true, "��¼�ɹ�!");
		}else{
			return new Message(true, "�������!");
		}
	}

}
