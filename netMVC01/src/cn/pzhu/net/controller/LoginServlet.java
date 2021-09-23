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
		//get�ύ��ʽ��ִ��
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.���б�Ҫ��ͷ����Ϣ�����������á���ֹ���棩
		request.setCharacterEncoding("UTF-8");
				
		//2.����V���ݵĲ���
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] aihaos = request.getParameterValues("aihao");
		boolean flag = false;	
		//3.�Բ������б�Ҫ���쳣������ж�
		if ("".equals(username)||"".equals(password)||aihaos==null) {
			request.getSession().setAttribute("msg", "������벻���Ϲ涨!");
			request.getSession().setAttribute("flag", false);
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
			return ;
		}
		
		//4.������Ҫ���ǵ���ֵJavaBean�����ݽ��з�װ
		User user = new User(username, password);
		//5.��ʼ������JavaBean��new����̬����ֱ�����������ã�
		UserUtil util = new UserUtil();
		flag  = util.login(user);
		
		//6.�õ�M����ķ��ؽ��
		//7.���б�Ҫ����Ϣ����  ��ѡ����ʵ�������
		//8.��������ѡ���ض������������ת���ص�V
		if (flag) {
			request.getSession().setAttribute("msg", "��ӭ"+username+"��¼!");
			request.getSession().setAttribute("flag", true);
			request.getSession().setAttribute("aihao", aihaos);
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
		}else{
			request.getSession().setAttribute("msg", "�������!");
			request.getSession().setAttribute("flag", false);
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//post�ύ��ʽ��ִ��
		doGet(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
