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
import cn.edu.pzhu.service.imp.UserServiceImp;

/**
 * Servlet implementation class LoginServlet
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
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		String code = request.getParameter("code");
		String answer = (String) request.getSession().getAttribute("answer");
		if (answer==null || code == null || !code.equals(answer)) {
			response.getWriter().print("<script>alert('验证码输入错误');"
					+ "window.location.href='"+request.getContextPath()+"/regist.jsp"+"'</script>");
			return;
		}
		
		
		
		User user = new User(name, password);
		//初始化业务层接口
		UserService us = new UserServiceImp();
		//调用业务层接口方法来的到执行结果
		Message message = us.regist(user);
		if (message.isSuccess()) {
			response.getWriter().print("<script>alert('"+message.getMsg()+"');"
					+ "window.location.href='"+request.getContextPath()+"/login.jsp"+"'</script>");
		} else {
			response.getWriter().print("<script>alert('"+message.getMsg()+"');"
					+ "window.location.href='"+request.getContextPath()+"/regist.jsp"+"'</script>");
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
