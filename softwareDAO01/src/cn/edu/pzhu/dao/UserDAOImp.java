package cn.edu.pzhu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public boolean add(User data) {
		boolean flag = false;
		
		Connection con = JDBCUtil.getConnection();
		PreparedStatement psta = null;
		String sql="insert into user values(?,?)";
		try {
			psta = con.prepareStatement(sql);
			//为问号赋值
			psta.setString(1, data.getName());
			psta.setString(2, data.getPassword());
			int n = psta.executeUpdate();
			if (n>0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, psta);
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
		User user = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "select * from user where name=?";
		PreparedStatement psta = null;
		ResultSet res = null;
		try {
			psta = con.prepareStatement(sql);
			//为问号赋值
			psta.setString(1, key);
			res = psta.executeQuery();
			if (res.next()) {
				user = new User(res.getString(1), res.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, psta);
		}
		return user;
	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
