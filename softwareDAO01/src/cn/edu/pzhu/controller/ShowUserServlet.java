package cn.edu.pzhu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.util.JDBCUtil;

/**
 * Servlet implementation class ShowUserServlet
 */
@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Connection con = JDBCUtil.getConnection();
		PrintWriter out = response.getWriter();
		out.print(con);//com.mysql.jdbc.JDBC4Connection@645920d 
		//3.编写SQL语句
		String sql = "select * from user";
		//4.创建命令对象
		Statement sta = null;
		try {
			sta = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建预编译的命令对象
		//PreparedStatement psta = con.prepareStatement(sql);
		//5.执行sql
		ResultSet res = null;
		try {
			res = sta.executeQuery(sql);
			//6.处理结果
			while(res.next()){
				out.print(res.getString(1)+"|");
				out.print(res.getString(2)+"<br/>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//7.释放资源
		JDBCUtil.close(con, sta, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
