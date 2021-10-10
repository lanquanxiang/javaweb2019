package cn.edu.pzhu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public boolean add(User data) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement psta = null;
		
		boolean flag = false;
		String sql = "insert into user values(?,?)";
		try {
			psta = con.prepareStatement(sql);
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
	public boolean detele(String key) {
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
		Connection con = JDBCUtil.getConnection();
		PreparedStatement psta = null;
		ResultSet res = null;
		User user = null;
		String sql = "select * from user where name=?";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, key);
			res = psta.executeQuery();
			if (res.next()) {
				user = new User(res.getString(1), res.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, psta, res);
		}
		return user;
	}

	@Override
	public ArrayList<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
