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
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		password = Conver2MD5.getMD5("haha"+Conver2MD5.getMD5(password)+"%@!");
		
		String code = request.getParameter("checkcode");
		String key = (String) request.getSession().getAttribute("key");
		if (code==null || "".equals(code) || !code.equals(key)) {
			response.getWriter().print("<script>alert('验证码错误！');window.location.href='"+request.getContextPath()+"/regist.jsp"+"'</script>");
			return;
		}
		
		User user = new User(name, password);
		//接口只能用他的实现类来初始化
		UserService us = new UserServiceImp();
		Message message  = us.regist(user);
		if (message.isSuccess()) {
			//成功
			request.getSession().setAttribute("msg", message.getMsg());
			//如果成功就跳转到登录界面
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		} else {
			//失败
			response.getWriter().print("<script>alert('"+message.getMsg()+"');window.location.href='"+request.getContextPath()+"/regist.jsp"+"'</script>");
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
