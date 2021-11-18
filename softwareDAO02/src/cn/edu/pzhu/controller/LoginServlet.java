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
import cn.edu.pzhu.service.imp.UserServiceImp;
import cn.edu.pzhu.util.Conver2MD5;

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
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String spassword =Conver2MD5.getSHA256(Conver2MD5.getSHA256(password)+"pzhu");
		String save = request.getParameter("save");
		User user = new User(name, spassword);
		//初始化业务层接口
		UserService us = new UserServiceImp();
		//调用业务层接口方法来的到执行结果
		Message message = us.login(user);
		if(save==null || !"save".equals(save)){
			//删除cookie
			Cookie cookie1 = new Cookie("username", "");
			Cookie cookie2 = new Cookie("password", "");
			//cookie1.setMaxAge(0);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			System.out.println("服务器正在删除cookie");
		}
		if (message.isSuccess()) {			
			if("save".equals(save)){
				//写入cookie
				Cookie cookie1 = new Cookie("username", name);
				Cookie cookie2 = new Cookie("password", password);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				System.out.println("服务器正在写入cookie");
			}			
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("msg", message.getMsg());
			response.getWriter().print("<script>alert('"+message.getMsg()+"');"
					+ "window.location.href='"+request.getContextPath()+"/success.jsp"+"'</script>");
		} else {
			response.getWriter().print("<script>alert('"+message.getMsg()+"');"
					+ "window.location.href='"+request.getContextPath()+"/login.jsp"+"'</script>");
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
