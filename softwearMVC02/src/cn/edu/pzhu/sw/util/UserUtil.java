package cn.edu.pzhu.sw.util;

import cn.edu.pzhu.sw.entity.User;

public class UserUtil {
	public boolean login(User user){
		boolean flag = false;
		if (user==null) {
			return flag;
		}
		if("".equals(user.getUsername()) || "".equals(user.getPassword())){
			return flag;
		}
		if("111111".equals(user.getPassword())){
			return true;
		}
		return flag;
	}
}
