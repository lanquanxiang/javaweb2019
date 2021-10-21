package cn.edu.pzhu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.service.imp.UserServiceImp;
import cn.edu.pzhu.service.inf.UserService;

/**
 * Servlet implementation class LoginServlet
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
		UserService us = new UserServiceImp();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new User(name,password);
		Message msg = us.login(user);
		//根据不同的结果保存信息，并跳转
		PrintWriter out = response.getWriter();
		if (msg.isRes()) {
			//登录成功并且需要保存信息
			String save = request.getParameter("save");
			if (save!=null && "save".equals(save)) {
				//保存cookie
				Cookie cookie1 = new Cookie("username", name);
				Cookie cookie2 = new Cookie("password", password);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}else{
				//清除之前可能保存的cookie
				Cookie cookie1 = new Cookie("username", "");
				Cookie cookie2 = new Cookie("password", "");
				//cookie1.setMaxAge(0);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			
			
			out.print("<script>alert('"+msg.getMsg()+"');"
					+ "window.location.href='"+request.getContextPath()+"/index.jsp"+"'</script>");
			//request.getSession().setAttribute("msg", msg.getMsg());
			//response.sendRedirect(request.getContextPath()+"/day17/index.jsp");
		} else {
			out.print("<script>alert('"+msg.getMsg()+"');"
					+ "window.location.href='"+request.getContextPath()+"/login.jsp"+"'</script>");
			//request.getSession().setAttribute("msg", msg.getMsg());
			//response.sendRedirect(request.getContextPath()+"/day17/login.jsp");
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
