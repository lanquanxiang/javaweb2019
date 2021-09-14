package cn.pzhu.net.util;

import cn.pzhu.net.entity.User;

public class UserUtil {
	public boolean login(User user){
		boolean flag =  false;
		
		if (user!=null && "123456".equals(user.getPassword())) {
			flag = true;
		}
		
		return flag;
	}
}
