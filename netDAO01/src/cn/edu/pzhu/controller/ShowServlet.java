package cn.edu.pzhu.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.util.JDBCUtil;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from user";
		Statement sta = null;
		ResultSet res = null;
		ArrayList<User> list = new ArrayList<>();
		try {
			sta =  connection.createStatement();
			res = sta.executeQuery(sql);
			while(res.next()){
				User temp = new User();
				temp.setName(res.getString(1));
				temp.setPassword(res.getString(2));
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(connection, sta, res);
		}
		request.getSession().setAttribute("list", list);
		response.sendRedirect(request.getContextPath()+"/day13/show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
