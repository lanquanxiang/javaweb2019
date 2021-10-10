package cn.edu.pzhu.service;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.UserDAOImp;
import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public class UserServiceImp implements UserService {

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
		UserDAO dao = new UserDAOImp();
		if (dao.selectById(user.getName())!=null) {
			return new Message(false, "�û�����ռ��!");
		}
		if (dao.add(user)) {
			return new Message(true, "�û�ע��ɹ�!");
		}
		return new Message(false, "δ֪�Ĵ���!");
	}

}