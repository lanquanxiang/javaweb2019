package cn.edu.pzhu.dao.imp;

import java.sql.*;
import java.util.ArrayList;


import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.dao.inf.UserDAO;
import cn.edu.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public boolean insert(User data) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "INSERT INTO user VALUES (?,?)";
		PreparedStatement sta = null;
		boolean flag = false;
		try {
			sta = connection.prepareStatement(sql);
			sta.setString(1, data.getName());
			sta.setString(2, data.getPassword());
			int n = sta.executeUpdate();
			if (n>0) {
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(sta, connection);
		}
		return flag;
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
	public User selectById(String key) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from user where name=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		User user = null;
		try {
			sta = connection.prepareStatement(sql);
			sta.setString(1, key);
			res = sta.executeQuery();
			while(res.next()){
				user = new User();
				user.setName(res.getString(1));
				user.setPassword(res.getString(2));				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(res, sta, connection);
		}		
		return user;
	}

	@Override
	public ArrayList<User> selectAll() {
		
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from user";
		Statement sta = null;
		ResultSet res = null;
		ArrayList<User> list = new ArrayList<>();
		try {
			sta = connection.createStatement();
			res = sta.executeQuery(sql);
			while(res.next()){
				User user = new User();
				user.setName(res.getString(1));
				user.setPassword(res.getString(2));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(res, sta, connection);
		}
		
		return list;
	}

}
