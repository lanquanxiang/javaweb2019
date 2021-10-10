package cn.edu.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.entity.Message;
import cn.edu.pzhu.entity.User;
import cn.edu.pzhu.service.imp.UserServiceImp;
import cn.edu.pzhu.service.inf.UserService;

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
		//ʵ����ҵ���ӿ�
		UserService us = new UserServiceImp();
		//��ȡ�����ύ������
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//����ʵ���� User
		User user = new User(name,password);
		//����ҵ���ӿ�ʵ��ע�ᣬ�õ����
		Message msg = us.regist(user);
		//���ݲ�ͬ�Ľ��������Ϣ������ת
		if (msg.isRes()) {
			request.getSession().setAttribute("msg", msg.getMsg());
			response.sendRedirect(request.getContextPath()+"/day14/index.jsp");
		} else {
			request.getSession().setAttribute("msg", msg.getMsg());
			response.sendRedirect(request.getContextPath()+"/day14/index.jsp");
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