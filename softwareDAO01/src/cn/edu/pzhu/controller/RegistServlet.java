package cn.edu.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.service.UserService;
import cn.edu.pzhu.service.UserServiceImp;

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
		//接受视图层传递的参数，并进行封装
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new User(name, password);
		//使用业务层接口的实现类来new一个业务层接口
		UserService us = new UserServiceImp();
		Message message =us.regist(user);
		if (message.isSuccess()) {
			//成功，保存msg中的消息
			request.getSession().setAttribute("msg",message.getMsg());
			response.sendRedirect(request.getContextPath()+"/day12/regist.jsp");
		}else{
			//失败，保存msg中的消息
			request.getSession().setAttribute("msg",message.getMsg());
			response.sendRedirect(request.getContextPath()+"/day12/regist.jsp");
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
