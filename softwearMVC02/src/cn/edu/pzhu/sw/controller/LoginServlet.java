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
		//2������һЩ��Ҫ�ı��루�������룩��ͷ����Ϣ������ֹ���棩
		//request.setCharacterEncoding("UTF-8");
		//3������V��ͼ�㷢�����Ĳ���������ֵ�����Ƕ��ֵ��
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		String[] hs = request.getParameterValues("hobby");
		//4�����б�Ҫ��������֤���жϣ�����ת�������������ԡ��Ϸ��ԣ�
		//5�������֤��ͨ�����˻أ��ض���������Զ���ת��V��ͼ��
		if("".equals(u) || "".equals(p) || hs==null){
			request.getSession().setAttribute("msg", "����������ݲ�����!");
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
			return;
		}
		//---------��C�е���M-------------------
		//6�����Գ�ʼ��һ��ֵJavaBean�����ݽ��з�װ���������ࣩ
		User user = new User(u, p);
		//7����ʼ��һ��������JavaBean�������ݽ��д����õ�������
		boolean flag = new UserUtil().login(user);
		//8�����Ʋ�C����Mģ�Ͳ�ķ��ؽ�����б�Ҫ�����ݱ��棨���������
		if(flag){
			request.getSession().setAttribute("msg", "��ӭ"+u+",��¼�ɹ���");
			request.getSession().setAttribute("hs", hs);
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
		
		}else{
			request.getSession().setAttribute("msg", "�����������");
			response.sendRedirect(request.getContextPath()+"/day06/show.jsp");
		}
		//9��������Ҫѡ���ض����������ת���ص�V��ͼ��
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
