package cn.edu.pzhu.service;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	//��¼
	public Message login(User user);
	//ע��
	public Message regist(User user);
	//�޸�����
	
	//��ѯ�û����Ƿ����
	public String check(String name);
	//ע���˺�
	
}
