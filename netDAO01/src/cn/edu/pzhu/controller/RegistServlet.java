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
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(name, password);
		//�ӿ�ֻ��������ʵ��������ʼ��
		UserService us = new UserServiceImp();
		Message message  = us.regist(user);
		if (message.isSuccess()) {
			//�ɹ�
			request.getSession().setAttribute("msg", message.getMsg());
			//����ɹ�����ת����¼����
			response.sendRedirect(request.getContextPath()+"/day14/index.jsp");
		} else {
			//ʧ��
			request.getSession().setAttribute("msg", message.getMsg());
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
