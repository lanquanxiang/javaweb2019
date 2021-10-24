package cn.edu.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.service.UserService;
import cn.edu.pzhu.service.UserServiceImp;
import cn.edu.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		password = Conver2MD5.getMD5("haha"+Conver2MD5.getMD5(password)+"%@!");
		
		String save = request.getParameter("save");
		
		User user = new User(name, password);
		//接口只能用他的实现类来初始化
		UserService us = new UserServiceImp();
		Message message  = us.login(user);
		if (message.isSuccess()) {
			//成功
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("msg", message.getMsg());
			
			if (save!=null && "isSave".equals(save)) {
				Cookie cookie1 = new Cookie("username", name);
				Cookie cookie2 = new Cookie("password", password);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}else{
				Cookie cookie1 = new Cookie("username", "");
				Cookie cookie2 = new Cookie("password", "");
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			
			
			
			//如果成功就跳转到登录界面
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} else {
			//失败
			request.getSession().setAttribute("msg", message.getMsg());
			response.sendRedirect(request.getContextPath()+"/login.jsp");
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
