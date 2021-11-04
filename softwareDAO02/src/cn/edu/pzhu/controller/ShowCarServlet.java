package cn.edu.pzhu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.entity.Car;
import cn.edu.pzhu.service.CarService;
import cn.edu.pzhu.service.imp.CarServiceImp;
import cn.edu.pzhu.util.PageUtil;

/**
 * Servlet implementation class ShowCarServlet
 */
@WebServlet("/show")
public class ShowCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarService cs = new CarServiceImp();
		List<Car> list = cs.show();
		
		String spage = request.getParameter("page");
		String snum = request.getParameter("num");
		int page=1;
		int num = 10;
		try {
			page = Integer.parseInt(spage);
		} catch (Exception e) {
			page=1;
		}
		try {
			num = Integer.parseInt(snum);
		} catch (Exception e) {
			num=10;
		}
		String path = request.getContextPath()+"/show";
		StringBuffer bar  = PageUtil.createBar(list,page,num,path);
		
		
		list = PageUtil.splitList(list,page,num);
		
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("bar", bar);
		request.getSession().setAttribute("num", num);
		response.sendRedirect(request.getContextPath()+"/success.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
