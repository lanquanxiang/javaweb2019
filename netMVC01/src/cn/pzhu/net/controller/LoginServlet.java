package cn.pzhu.net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.net.entity.User;
import cn.pzhu.net.util.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
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
		// TODO Auto-generated method stub
		//get提交方式被执行
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.进行必要的头部信息处理（编码重置、禁止缓存）
		request.setCharacterEncoding("UTF-8");
				
		//2.接收V传递的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] aihaos = request.getParameterValues("aihao");
		boolean flag = false;	
		//3.对参数进行必要的异常处理和判断
		if ("".equals(username)||"".equals(password)||aihaos==null) {
			request.getSession().setAttribute("msg", "你的输入不符合规定!");
			request.getSession().setAttribute("flag", false);
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
			return ;
		}
		
		//4.可能需要考虑调用值JavaBean对数据进行封装
		User user = new User(username, password);
		//5.初始化工具JavaBean（new、静态方法直接用类名调用）
		UserUtil util = new UserUtil();
		flag  = util.login(user);
		
		//6.得到M处理的返回结果
		//7.进行必要的信息保存  （选择合适的作用域）
		//8.根据需求，选择重定向或者是请求转发回到V
		if (flag) {
			request.getSession().setAttribute("msg", "欢迎"+username+"登录!");
			request.getSession().setAttribute("flag", true);
			request.getSession().setAttribute("aihao", aihaos);
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
		}else{
			request.getSession().setAttribute("msg", "密码错误!");
			request.getSession().setAttribute("flag", false);
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//post提交方式被执行
		doGet(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
