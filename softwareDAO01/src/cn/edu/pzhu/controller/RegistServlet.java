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
		//������ͼ�㴫�ݵĲ����������з�װ
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		String code = request.getParameter("code");
		String ans = (String) request.getSession().getAttribute("ans");
		if (code==null || "".equals(code) || !code.equals(ans)) {
			request.getSession().setAttribute("msg","��֤�����!");
			response.sendRedirect(request.getContextPath()+"/regist.jsp");
			return;
		}
		//��������м���
		password = Conver2MD5.getSHA256(Conver2MD5.getSHA256(password)+"pzhu");
		
		User user = new User(name, password);
		//ʹ��ҵ���ӿڵ�ʵ������newһ��ҵ���ӿ�
		UserService us = new UserServiceImp();
		Message message =us.regist(user);
		if (message.isSuccess()) {
			//�ɹ�������msg�е���Ϣ
			request.getSession().setAttribute("msg",message.getMsg());
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			//ʧ�ܣ�����msg�е���Ϣ
			request.getSession().setAttribute("msg",message.getMsg());
			response.sendRedirect(request.getContextPath()+"/regist.jsp");
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
