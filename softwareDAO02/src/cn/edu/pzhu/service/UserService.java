package cn.edu.pzhu.service;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	//��¼
	public Message login(User user);
	//ע��
	public Message regist(User user);
	//�޸�����
	public Message changePwd(User user);
	//����
	public boolean destroy(User user);
	//����û����Ƿ�ռ��
	public String check(String name);
	
}
