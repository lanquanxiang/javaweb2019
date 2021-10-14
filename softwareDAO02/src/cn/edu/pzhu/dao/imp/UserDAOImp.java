package cn.edu.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public boolean add(User data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User select(String key) {
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement psta = null;
		ResultSet res = null;
		User user = null;
		try {
			String sql="select * from user where name=?";
			psta = connection.prepareStatement(sql);
			psta.setString(1, key);
			res = psta.executeQuery();
			if (res.next()) {
				user = new User(res.getString(1), res.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(connection, psta, res);
		}
		return user;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
