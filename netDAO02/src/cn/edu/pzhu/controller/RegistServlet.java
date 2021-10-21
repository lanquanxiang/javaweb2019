package cn.edu.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.service.imp.UserServiceImp;
import cn.edu.pzhu.service.inf.UserService;
import cn.edu.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实例化业务层接口
		UserService us = new UserServiceImp();
		//获取表单提交的数据
		String checkcode = request.getParameter("checkcode");
		String key = (String) request.getSession().getAttribute("key");
		if (checkcode==null ||"".equals(checkcode) || !checkcode.equals(key) ) {
			response.getWriter().print("<script>alert('验证码错误!');"
					+ "window.location.href='"+request.getContextPath()+"/regist.jsp"
					+"'</script>");
			return;			
		}
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//对密码进行加密
		password = Conver2MD5.getMD5(Conver2MD5.getMD5(password)+"pzhu");
		//构造实体类 User
		User user = new User(name,password);
		//调用业务层接口实现注册，得到结果
		Message msg = us.regist(user);
		//根据不同的结果保存信息，并跳转
		if (msg.isRes()) {
			response.getWriter().print("<script>alert('"+msg.getMsg()+"');"
					+ "window.location.href='"+request.getContextPath()+"/login.jsp"
					+"'</script>");
		} else {
			response.getWriter().print("<script>alert('"+msg.getMsg()+"');"
					+ "window.location.href='"+request.getContextPath()+"/regist.jsp"
					+"'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
