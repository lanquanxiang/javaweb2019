package cn.edu.pzhu.service.inf;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;

public interface UserService {
	/***
	 * �û�ע��
	 * @param user ��Ҫע����û���������
	 * @return message��������˳ɹ���ʧ�ܵ�boolean���ݣ��Լ�ʧ�ܵ�ԭ��
	 */
	public Message regist(User user);
	
	public Message login(User user);
	
	public String check(String name);
}
