package cn.edu.pzhu.sw.exp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalAreaServlet
 */
@WebServlet("/CalAreaServlet")
public class CalAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalAreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ѡ��ֵ
		String name = request.getParameter("type");
		//����ͼ�β���
		//String--->double ��������쳣���ص���ͼ��
		Shape shape = ShapeFactory.getShape(name);
		//����У�飬�������ͨ����ֱ�ӷ���
		shape.check();
		//�������
		shape.getArea();
		//����ͼ�κ�ͼ�ε������������ͼ��
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
