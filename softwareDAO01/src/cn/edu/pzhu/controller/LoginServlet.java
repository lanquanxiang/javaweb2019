package cn.edu.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Spring;

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
		//接受视图层传递的参数，并进行封装
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String save=request.getParameter("save");
		if(save==null || !save.equals("yes"))
		{
			Cookie cookie1=new Cookie("username","");
			cookie1.setMaxAge(0);
			response.addCookie(cookie1);
			Cookie cookie2=new Cookie("password", "");
			cookie2.setMaxAge(0);
			response.addCookie(cookie2);
			Cookie cookie3=new Cookie("save","");
			cookie3.setMaxAge(0);
			response.addCookie(cookie3);
		}
		String password2 = Conver2MD5.getSHA256(Conver2MD5.getSHA256(password)+"pzhu");
		User user = new User(name, password2);
		//使用业务层接口的实现类来new一个业务层接口
		UserService us = new UserServiceImp();
		Message message =us.login(user);
		if (message.isSuccess()) {
			//成功，保存用户的登录信息
			if(save!=null && save.equals("yes"))
			{
				Cookie cookie1=new Cookie("username",name);
				response.addCookie(cookie1);
				Cookie cookie2=new Cookie("password", password);
				response.addCookie(cookie2);
				Cookie cookie3=new Cookie("save","yes");
				response.addCookie(cookie3);
			}
			request.getSession().setAttribute("user", user);
			//成功，保存msg中的消息
			request.getSession().setAttribute("msg",message.getMsg());
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		}else{
			//失败，保存msg中的消息
			request.getSession().setAttribute("msg",message.getMsg());
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
