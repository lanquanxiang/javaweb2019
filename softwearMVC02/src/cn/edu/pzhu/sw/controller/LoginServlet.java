package cn.edu.pzhu.sw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.sw.entity.User;
import cn.edu.pzhu.sw.util.UserUtil;

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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//2、进行一些必要的编码（中文乱码）和头部信息处理（禁止缓存）
		//request.setCharacterEncoding("UTF-8");
		//3、接受V视图层发过来的参数（单个值、还是多个值）
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		String[] hs = request.getParameterValues("hobby");
		//4、进行必要的数据验证和判断（类型转换、数据完整性、合法性）
		//5、如果验证不通过，退回（重定向或者是自动跳转）V视图层
		if("".equals(u) || "".equals(p) || hs==null){
			request.getSession().setAttribute("msg", "你输入的数据不完整!");
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
			return;
		}
		//---------在C中调用M-------------------
		//6、可以初始化一个值JavaBean对数据进行封装（参数过多）
		User user = new User(u, p);
		//7、初始化一个工具类JavaBean，对数据进行处理，得到处理结果
		boolean flag = new UserUtil().login(user);
		//8、控制层C根据M模型层的返回结果进行必要的数据保存（作用域对象）
		if(flag){
			request.getSession().setAttribute("msg", "欢迎"+u+",登录成功！");
			request.getSession().setAttribute("hs", hs);
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
		
		}else{
			request.getSession().setAttribute("msg", "密码输入错误！");
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
		}
		//9、根据需要选用重定向或者请求转发回到V视图层
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
