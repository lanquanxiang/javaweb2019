package cn.edu.pzhu.service;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	//ע��
	//������û���Ϊ�գ�ʧ�ܣ�����Ϊ�գ�ʧ�ܣ��û�����ռ�ã�ʧ�ܣ������쳣��ʧ�ܣ���ӳɹ����ɹ���
	public Message regist(User user);
	//��¼
	public Message login(User user);
	//�޸�����
	
	//�����˻�
	
	//����û����Ƿ�ռ��
	public String check(String name);
}
